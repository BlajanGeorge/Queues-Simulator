package Task;

public class Task {
    private final int arrivalTime;
    private int processingTime;
    private final int ID;
    private static int contor = 0;
    private int waitTime;

    public Task(int arrivalTime, int processingTime) {
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
        contor++;
        this.waitTime = 0;
        this.ID = contor;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getProcessingTime() {
        return this.processingTime;
    }

    public String toString() {
        return ("(" + this.ID + "," + this.arrivalTime + "," + this.processingTime + ")");
    }

    public void decrementProcessingTime() {
        this.processingTime=this.processingTime-1;
    }

    public void setWaitTime(int a) {
        this.waitTime = a;
    }

    public int getWaitTime() {
        return this.waitTime;
    }


}
