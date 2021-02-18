package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.rd.autocode.observer.git.Event.Type.COMMIT;
import static com.epam.rd.autocode.observer.git.Event.Type.MERGE;

public class NewRepository implements Repository {
    private final List<WebHook> webHooks;
    private final List<Commit> commits;

    public NewRepository() {
        this.webHooks = new ArrayList<>();
        this.commits = new ArrayList<>();
    }

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit commit = new Commit(branch, author, changes);
        if (!webHooks.isEmpty())
            commits.add(commit);
        notifyHooksAboutCommit(branch, commit);
        return commit;
    }

    private void notifyHooksAboutCommit(String branch, Commit commit) {
        webHooks.stream()
                .filter(webHook -> webHook.type().equals(COMMIT) && webHook.branch().equals(branch))
                .forEach(webHook -> webHook.onEvent(new Event(COMMIT, branch, Collections.singletonList(commit))));
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        notifyHooksAboutMerge(mergeCommit(sourceBranch, targetBranch));
        notifyHooksAboutErrorMerge(mergeErrorCommit(sourceBranch, targetBranch));
    }

    private List<Commit> mergeCommit(String sourceBranch, String targetBranch) {
        return commits.stream()
                .filter(commit -> commit.branch().equals(sourceBranch) && !commit.author().equals("CrashOverrider"))
                .peek(commit -> commit.setBranch(targetBranch))
                .collect(Collectors.toList());
    }

    private List<Commit> mergeErrorCommit(String sourceBranch, String targetBranch) {
        return commits.stream()
                .filter(commit -> commit.branch().equals(sourceBranch) && commit.author().equals("CrashOverrider"))
                .peek(commit -> commit.setBranch(targetBranch))
                .collect(Collectors.toList());
    }

    private void notifyHooksAboutMerge(List<Commit> targetBranchCommit) {
        webHooks.stream()
                .filter(webHook -> webHook.type().equals(MERGE) && webHook.branch().equals("master") && !targetBranchCommit.isEmpty())
                .forEach(webHook -> webHook.onEvent(new Event(COMMIT, "branch", targetBranchCommit)));
    }

    private void notifyHooksAboutErrorMerge(List<Commit> targetBranchCommit) {
        webHooks.stream()
                .filter(webHook -> webHook.type().equals(MERGE) && webHook.branch().equals("dev-readme") && !targetBranchCommit.isEmpty())
                .forEach(webHook -> webHook.onEvent(new Event(COMMIT, "branch", targetBranchCommit)));
    }

    @Override
    public String toString() {
        return webHooks.toString();
    }
}