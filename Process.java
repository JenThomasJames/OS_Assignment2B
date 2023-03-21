public class Process implements Runnable {
    private int id;
    private int priority;
    private int cpuBurstTime;
    private int ioBurstTime;
    private int executionTime;
    private int remainingCPUTime;
    private int totalTimeTaken;
    private IOQueue ioQueue;
    private ReadyQueue readyQueue;

    public Process() {
    }

    public Process(int id, int priority, int cpuBurstTime, int ioBurstTime, int executionTime) {
        this.ioQueue = IOQueue.getInstance();
        this.readyQueue = ReadyQueue.getInstance();
        this.id = id;
        this.priority = priority;
        this.cpuBurstTime = cpuBurstTime;
        this.ioBurstTime = ioBurstTime;
        this.executionTime = executionTime;
        this.remainingCPUTime = executionTime;
        this.totalTimeTaken = 0;
    }

    public int getId() {
        return this.id;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getCpuBurstTime() {
        return this.cpuBurstTime;
    }

    public void setCpuBurstTime(int cpuBurstTime) {
        this.cpuBurstTime = cpuBurstTime;
    }

    public int getIoBurstTime() {
        return this.ioBurstTime;
    }

    public void setIoBurstTime(int ioBurstTime) {
        this.ioBurstTime = ioBurstTime;
    }

    public int getExecutionTime() {
        return this.executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getRemainingCPUTime() {
        return this.remainingCPUTime;
    }

    public void setRemainingCPUTime(int remainingCPUTime) {
        this.remainingCPUTime = remainingCPUTime;
    }

    public int getTotalTimeTaken() {
        return this.totalTimeTaken;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void interrupt() {
        this.interrupt();
    }

    @Override
    public void run() {
        if (this.executionTime == -1) {
            while (true) {
                for (int i = 0; i < this.cpuBurstTime; i++) {
                    try {
                        Thread.sleep(ioBurstTime * 60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    totalTimeTaken++;
                }
                try {
                    if (ioBurstTime != 0) {
                        readyQueue.remove(this);
                        ioQueue.add(this);
                        Thread.sleep(ioBurstTime * 1000);
                        ioBurstTime = 0;
                        readyQueue.add(this);
                        ioQueue.remove(this);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            while (executionTime != 0) {
                for (int i = 0; i < this.cpuBurstTime; i++) {
                    totalTimeTaken++;
                    this.executionTime--;
                }
                try {
                    Thread.sleep(ioBurstTime * 1000);
                    ioBurstTime = 0;
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
