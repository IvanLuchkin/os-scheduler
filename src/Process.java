public class Process {
    private final long id;
    private final int executionTime;
    private int waitTime;

    public Process(long id, int executionTime) {
        this.id = id;
        this.executionTime = executionTime;
    }

    public long getId() {
        return id;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                " execution time: " + executionTime +
                " waiting time: " + waitTime;
    }
}
