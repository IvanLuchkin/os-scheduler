import java.util.Stack;

public class Scheduler {

    private Stack<Process> executionStack;
    private static final int MAX_EXECUTION_TIME_IN_MIL = 2000;

    public Scheduler(int countOfProcesses) {
        executionStack = new Stack<>();
        generateProcesses(countOfProcesses);
    }

    public void generateProcesses(int countOfProcesses) {
        for (int i = 0; i < countOfProcesses; i++) {
            Process process = new Process(i, (int) (Math.random() * MAX_EXECUTION_TIME_IN_MIL));
            this.addProcessToScheduler(process);
        }
    }

    public void addProcessToScheduler(Process process) {
        if (executionStack.size() != 0) {
            for (Process waitingProcess : executionStack) {
                waitingProcess.setWaitTime(waitingProcess.getWaitTime() + process.getExecutionTime());
            }
        }
        executionStack.push(process);
    }

    public double averageWaitingTime() {
        return executionStack
                .stream()
                .mapToDouble(Process::getWaitTime)
                .reduce(0 , Double::sum)
                / executionStack.size();
    }

    public void printExecutionStack() {
        for (Process process : this.executionStack) {
            System.out.println(process.toString());
        }
        System.out.println("Average waiting time: " + averageWaitingTime());
    }

    public void start(){
        for (Process process : executionStack) {
            System.out.println("Process " + process.getId() + " was added to the execution stack");
        }
        for (int i = executionStack.size() - 1; i >= 0; i--) {
            Process currentProcess = executionStack.get(i);
            System.out.println("Process " + currentProcess.getId() + " is being executed");
            try {
                Thread.sleep(currentProcess.getExecutionTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Process " + currentProcess.getId() + " has finished. " + currentProcess.getExecutionTime() + "ms");
        }
    }
}
