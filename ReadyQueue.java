import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReadyQueue {
    private static ReadyQueue instance;
    private Queue<Process> readyQueue;

    private ReadyQueue() {
        readyQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getPriority).reversed());
    }

    public static ReadyQueue getInstance() {
        if (instance == null) {
            instance = new ReadyQueue();
        }
        return instance;
    }

    public void add(Process process) {
        readyQueue.add(process);
    }

    public boolean remove(Process process) {
        return readyQueue.remove(process);
    }

    public Process peek() {
        return readyQueue.peek();
    }

    public boolean isEmpty() {
        return readyQueue.isEmpty();
    }

    public Process poll() {
        return readyQueue.poll();
    }
}
