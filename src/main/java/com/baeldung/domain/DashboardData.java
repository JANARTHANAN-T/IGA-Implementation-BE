package com.baeldung.domain;

public class DashboardData {
    private int totalRequests;
    private int pendingRequests;
    private int completedRequests;
    private int rejectedRequests;
    private int totalTasks;
    private int pendingTasks;

    public int getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(int totalRequests) {
        this.totalRequests = totalRequests;
    }

    public int getPendingRequests() {
        return pendingRequests;
    }

    public void setPendingRequests(int pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

    public int getCompletedRequests() {
        return completedRequests;
    }

    public void setCompletedRequests(int completedRequests) {
        this.completedRequests = completedRequests;
    }

    public int getRejectedRequests() {
        return rejectedRequests;
    }

    public void setRejectedRequests(int rejectedRequests) {
        this.rejectedRequests = rejectedRequests;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }

    public int getPendingTasks() {
        return pendingTasks;
    }

    public void setPendingTasks(int pendingTasks) {
        this.pendingTasks = pendingTasks;
    }
}
