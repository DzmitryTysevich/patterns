package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class NewRepository implements Repository {
    private final List<WebHook> webHooks;
    private final List<Commit> commits;
    public static Event eventToMergeBranch;
    public static Event eventToCommitBranch;

    public NewRepository() {
        this.webHooks = new ArrayList<>();
        this.commits = new ArrayList<>();
    }

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
        eventToMergeBranch = eventToBranch(webHook, Event.Type.MERGE);
        eventToCommitBranch = eventToBranch(webHook, Event.Type.COMMIT);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit commit = new Commit(branch, author, changes);
        commits.add(commit);
        return commit;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        commits.stream()
                .filter(commit -> commit.branch().equals(sourceBranch))
                .forEach(commit -> commit.setBranch(targetBranch));

        for (WebHook webHook : webHooks) {

        }
    }

    private Event eventToBranch(WebHook webHook, Event.Type type) {
        Event event = null;
        if (webHook.type().equals(type))
            event = new Event(webHook.type(), webHook.branch(), commits);
        return event;
    }

    @Override
    public String toString() {
        return commits.toString();
    }
}