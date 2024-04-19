package Cap5;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed {
    private String data;
    private long delay;

    public DelayedElement(String data, long delay) {
        this.data = data;
        this.delay = delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delay - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(delay, ((DelayedElement) o).delay);
    }

    @Override
    public String toString() {
        return "DelayedElement{" +
                "data='" + data + '\'' +
                '}';
    }

    public static void main(String[] args) {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();
        delayQueue.offer(new DelayedElement("Task 1", 2000));
        delayQueue.offer(new DelayedElement("Task 2", 3000));
        delayQueue.offer(new DelayedElement("Task 3", 1000));

        while (!delayQueue.isEmpty()) {
            try {
                DelayedElement element = delayQueue.take();
                System.out.println(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

