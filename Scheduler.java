public class Scheduler {
    private ReadyQueue readyQueue;
    private IOQueue ioQueue;

    public Scheduler() {
        readyQueue = ReadyQueue.getInstance();
        ioQueue = IOQueue.getInstance();
    }

    public void addProcessToReadyQueue(Process process) {
        readyQueue.add(process);
        Thread processThread = new Thread(process);
        processThread.start();
        readyQueue.remove(process);
    }

    public void addProcessToIOQueue(Process process) {
        ioQueue.add(process);
        ioQueue.remove(process);
    }

    public boolean interruptProcess(int id) {
        boolean isFound = false;
        while (!readyQueue.isEmpty()) {
            Process process = readyQueue.poll();
            if (process.getId() == id) {
                readyQueue.remove(process);
                process.interrupt();
                return true;
            }
        }
        if (!isFound) {
            while (!ioQueue.isEmpty()) {
                Process process = ioQueue.poll();
                if (process.getId() == id) {
                    ioQueue.remove(process);
                    process.interrupt();
                    return true;
                }
            }
        }
        return false;
    }

    public void printStatus() {
        System.out.println("Ready Queue");
        System.out.println("------------");
        while (!readyQueue.isEmpty()) {
            Process process = readyQueue.poll();
            System.out.println("PID: " + process.getId());
            System.out.println("Total Time Taken: " + process.getTotalTimeTaken());
            System.out.println("Priority: " + process.getPriority());
            System.out.println();
            System.out.println();
        }
        System.out.println("IO Queue");
        System.out.println("------------");
        while (!ioQueue.isEmpty()) {
            Process process = ioQueue.poll();
            System.out.println("PID: " + process.getId());
            System.out.println("Total Time Taken: " + process.getTotalTimeTaken());
            System.out.println("Priority: " + process.getPriority());
            System.out.println();
            System.out.println();
        }
    }
}
