package Algorithms;

import Process.Process;
import Sorts.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FCFS extends Algorithm {
    public FCFS(ArrayList<Process> ProcessList) {
        super(ProcessList);
    }

    public void sortListByArrivalTime(){
        ProcessList.sort(new arrivalSort());
    }

    public int simulateFCFS() {
        sortListByArrivalTime();
        currentTime = ProcessList.get(0).getArrivalTime();

        Iterator<Process> iterator = ProcessList.iterator();
        while (iterator.hasNext()) {
            Process process = iterator.next();
            if (process.getArrivalTime() <= currentTime) {
                totalWaitingTime += currentTime - process.getArrivalTime();
                currentTime += process.getBurstTime();
                iterator.remove();
                iterator = ProcessList.iterator();
                if(currentTime- process.getArrivalTime()>this.STARVATION_TIME){
                    this.starvedUnits++;
                }

            }
            else{
                currentTime++;
            }
        }
        System.out.println(currentTime);
        System.out.println(starvedUnits);
        return totalWaitingTime / size;

    }
}
