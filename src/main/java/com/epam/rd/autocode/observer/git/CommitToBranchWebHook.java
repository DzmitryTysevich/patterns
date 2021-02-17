package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class CommitToBranchWebHook implements WebHook {
    private final String branchName;

    public CommitToBranchWebHook(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String branch() {
        return branchName;
    }

    @Override
    public Event.Type type() {
        return Event.Type.COMMIT;
    }

    @Override
    public List<Event> caughtEvents() {
        List<Event> events = new ArrayList<>();
        events.add(NewRepository.eventToCommitBranch);
        return events;
    }

    @Override
    public void onEvent(Event event) {

    }

    @Override
    public String toString() {
        return caughtEvents().toString();
    }
}