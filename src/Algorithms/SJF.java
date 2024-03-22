package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Process.Process;
import Sorts.arrivalSort;
import Sorts.burstSort;

public class SJF extends Algorithm{

    public SJF(ArrayList<Process> ProcessList) {
        super(ProcessList);
    }

    public void sortListByBurstTime(){
        ProcessList.sort(new burstSort());
    }
    public void sortListByArrivalTime(){
        ProcessList.sort(new arrivalSort());
    }

    /**
     * Method that simulates SJF algorithm for N amount of processes.
     * First, the ProcessList needs to be sorted by burstTime.
     * Once the list is sorted we can iterate through the list and remove the shortest available process
     */
    public int SimulateSJF(){
        sortListByArrivalTime();
        currentTime = 0;
        sortListByBurstTime();
        Iterator<Process> iterator = ProcessList.iterator();
        while(!ProcessList.isEmpty()) {
            while (iterator.hasNext()) {

               /* for (int i = 0; i<ProcessList.size(); i++){
                    System.out.println();

                    System.out.println(i);
                    System.out.println(currentTime);
                    System.out.print(ProcessList.get(i).getArrivalTime()+" ");
                    System.out.print(ProcessList.get(i).getBurstTime());
                    System.out.println();
                }*/
                Process process = iterator.next();

                if (process.getArrivalTime() <= currentTime) {
                    totalWaitingTime += currentTime - process.getArrivalTime();
                  /*  System.out.println();
                    System.out.println(process);
                    System.out.println(currentTime);
                    System.out.print(process.getArrivalTime()+" ");
                    System.out.println(process.getBurstTime());


                    System.out.println(currentTime - process.getArrivalTime());

                    System.out.println();

                   */
                    if(currentTime- process.getArrivalTime()>this.STARVATION_TIME){
                        this.starvedUnits++;
                    }



                    currentTime += process.getBurstTime();
                    iterator.remove();
                    iterator = ProcessList.iterator();
                }
            }
            iterator = ProcessList.iterator();
            currentTime++;


        }
        System.out.println(currentTime);
        System.out.println((starvedUnits));
        return totalWaitingTime / size;
    }






}
