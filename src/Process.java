public class Process {
    private final long id;
    private final int execTime;
    private int waitTime;

    public Process(long id, int execTime) {
        this.id = id;
        this.execTime = execTime;
    }

    public long getId() {
        return id;
    }

    public int getExecTime() {
        return execTime;
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
                "ID : " + id +
                "  EXEC TIME : " + execTime +
                "  WAITING : " + waitTime;
    }
}
