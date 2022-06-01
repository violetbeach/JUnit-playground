package com.violetbeach.junitex;

public class Study {
    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    public Study(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public StudyStatus getStatus() {
        return status;
    }
}
