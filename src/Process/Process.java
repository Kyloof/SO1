package Process;

public class Process {
    private int burstTime;
    private int arrivalTime;
    private int waitingTime=0;

    public Process( int burstTime, int arrivalTime) {
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }


    public int getBurstTime() {
        return burstTime;
    }
    public void setWaitingTime(int waitingTime){
        this.waitingTime=waitingTime;
    }

    public int getWaitingTime(){
        return this.waitingTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}