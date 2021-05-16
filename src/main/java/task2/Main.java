package task2;

public class Main {
    public static void main(String[] args) {
        NewThreadPoolExecutor executor = new NewThreadPoolExecutor(20);
        executor.execute(new NewRunnable());
        executor.shutdown();
    }
}
