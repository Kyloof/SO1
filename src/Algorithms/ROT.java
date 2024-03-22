package Algorithms;

import Process.Process;
import Sorts.*;

import java.util.ArrayList;
import java.util.Iterator;
public class ROT extends Algorithm{
    int size;
    ArrayList<Process> ProcessListResult;
    public ROT(ArrayList<Process> ProcessList) {
        super(ProcessList);
        this.size=ProcessList.size();
        this.ProcessListResult=new ArrayList<>(ProcessList);
    }

    public ArrayList<Process> checkNewArrival(int currentTime, ArrayList<Process> queue){
        Iterator<Process> iterator = ProcessList.iterator();
        while (iterator.hasNext()) {
            Process process = iterator.next();
            if (process.getArrivalTime() <= currentTime) {
                iterator.remove();
                queue.add(process);
            }
        }
        return queue;
    }

    public int simulateROT(int quantum) {
        int currentTime = 0;

        ArrayList<Process> queue = new ArrayList<Process>();
        Iterator<Process> iterator = ProcessList.iterator();
        boolean isLoop = true;
        while  (!ProcessList.isEmpty()){
            checkNewArrival(currentTime, queue);
            for (int i = 0; i < queue.size(); i++) {
                Process currentProcess = queue.get(i);
                if (currentProcess.getBurstTime() - quantum > 0) {
                    queue.remove(currentProcess);
                    totalWaitingTime += currentTime - currentProcess.getArrivalTime();
                    currentProcess.setWaitingTime(currentTime- currentProcess.getArrivalTime());
                    if (i!=0)
                        i--;
                    currentProcess.setBurstTime(currentProcess.getBurstTime() - quantum);
                    queue.add(currentProcess);
                    currentTime += quantum;
                    checkNewArrival(currentTime, queue);
                } else if (currentProcess.getBurstTime() - quantum == 0) {
                    queue.remove(currentProcess);
                    currentProcess.setWaitingTime(currentTime- currentProcess.getArrivalTime());
                    ProcessListResult.add(currentProcess);
                    totalWaitingTime += currentTime - currentProcess.getArrivalTime();

                    if (i!=0)
                        i--;
                    currentTime += quantum;
                    checkNewArrival(currentTime, queue);

                } else {
                    queue.remove(currentProcess);
                    currentProcess.setWaitingTime(currentTime- currentProcess.getArrivalTime());
                    ProcessListResult.add(currentProcess);
                    totalWaitingTime += currentTime - currentProcess.getArrivalTime();
                    if (i!=0)
                        i--;
                    int processTime = quantum - currentProcess.getBurstTime();
                    int j = i;
                    currentTime+=quantum - currentProcess.getBurstTime();
                    while (processTime > 0 && j < queue.size()) {
                        Process nextProcess = queue.get(j);
                        if (nextProcess.getBurstTime() - processTime > 0) {
                            queue.remove(nextProcess);
                            totalWaitingTime += currentTime - currentProcess.getArrivalTime();
                            currentProcess.setWaitingTime(currentTime- currentProcess.getArrivalTime());
                            currentTime+=processTime;
                            if (i!=0)
                                i--;
                            nextProcess.setBurstTime(nextProcess.getBurstTime() - processTime);
                            queue.add(nextProcess);
                        }
                        else if ( processTime-nextProcess.getBurstTime() > 0) {
                            queue.remove(nextProcess);
                            currentProcess.setWaitingTime(currentTime- currentProcess.getArrivalTime());
                            ProcessListResult.add(currentProcess);
                            totalWaitingTime += currentTime - currentProcess.getArrivalTime();

                            currentTime+=processTime-nextProcess.getBurstTime();
                            if (i!=0)
                                    i--;
                        }else if (currentProcess.getBurstTime() - processTime == 0) {
                            queue.remove(currentProcess);
                            currentProcess.setWaitingTime(currentTime- currentProcess.getArrivalTime());
                            ProcessListResult.add(currentProcess);
                            totalWaitingTime += currentTime - currentProcess.getArrivalTime();

                            currentTime+=processTime;

                            if (i!=0)
                                i--;
                        }
                        j++;
                    }
                    checkNewArrival(currentTime, queue);
                }

            }
            currentTime++;

        }
        for (Process process:ProcessListResult){
            if(process.getWaitingTime()>STARVATION_TIME){
                starvedUnits++;
            }
        }
        System.out.println(currentTime);
        System.out.println(starvedUnits);
        return totalWaitingTime/size;
    }

}
