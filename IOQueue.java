import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class IOQueue {
    private static IOQueue instance;
    private Queue<Process> ioQueue;

    private IOQueue() {
        ioQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getPriority).reversed());
    }

    public static IOQueue getInstance() {
        if (instance == null) {
            instance = new IOQueue();
        }
        return instance;
    }

    public void add(Process process) {
        ioQueue.add(process);
    }

    public boolean remove(Process process) {
        return ioQueue.remove(process);
    }

    public Process peek() {
        return ioQueue.peek();
    }

    public boolean isEmpty() {
        return ioQueue.isEmpty();
    }

    public Iterator<Process> iterator() {
        return ioQueue.iterator();
    }

    public Process poll() {
        return ioQueue.poll();
    }
}
