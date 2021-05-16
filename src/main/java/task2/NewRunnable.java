package task2;

@Repeat(count = 13)
public class NewRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Hello GoIT");
    }
}
