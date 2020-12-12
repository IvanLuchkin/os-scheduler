public class Main {

    public static void main(String...args) {
        Scheduler scheduler = new Scheduler(10);
        scheduler.start();
        scheduler.printExecutionStack();
    }
}
