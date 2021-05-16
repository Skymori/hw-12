package task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NewThreadPoolExecutor extends ThreadPoolExecutor {
    public static final int maximumPoolSize = Integer.MAX_VALUE;
    public static final long keepAliveTime = 60;
    public static final TimeUnit unit = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(50);
    public NewThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        int count =1;
        if (command.getClass().isAnnotationPresent(Repeat.class)){
            Repeat annotation = command.getClass().getAnnotation(Repeat.class);
            count = annotation.count();
        }
        for (int i = 0; i < count; i++) {
            super.execute(command);
        }
    }
}
