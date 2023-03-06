public class Process {
    private int id;
    private int priority;
    private int cpuBurstTime;
    private int ioBurstTime;
    private int executionTime;
    private int remainingCPUTime;
    private int remainingIOTime;

    public Process() {
    }

    public Process(int id, int priority, int cpuBurstTime, int ioBurstTime, int executionTime) {
        this.id = id;
        this.priority = priority;
        this.cpuBurstTime = cpuBurstTime;
        this.ioBurstTime = ioBurstTime;
        this.executionTime = executionTime;
        this.remainingCPUTime = cpuBurstTime;
        this.remainingIOTime = ioBurstTime;
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

    public int getRemainingIOTime() {
        return this.remainingIOTime;
    }
}
