package task1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Water {
    private final Semaphore oxygenSemaphore;
    private final Semaphore hydrogenSemaphore;
    private final CyclicBarrier cyclicBarrier;

    public Water(){
        oxygenSemaphore = new Semaphore(1);
        hydrogenSemaphore = new Semaphore(2);
        cyclicBarrier = new CyclicBarrier(3);
    }
    public void oxygen(Runnable oxygenRelease) throws InterruptedException{
        oxygenSemaphore.acquire();
        try {
            cyclicBarrier.await();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
        oxygenRelease.run();
        oxygenSemaphore.release();
    }
    public void hydrogen(Runnable hydrogenRelease) throws InterruptedException{
        hydrogenSemaphore.acquire();
        try {
            cyclicBarrier.await();
        }catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        hydrogenRelease.run();
        hydrogenSemaphore.release();
    }
}
