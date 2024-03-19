package Algorithms;

import java.util.ArrayList;
import Process.Process;

public class SJF extends Algorithm{
    private static int currentTime = 0;
    private static float totalWaitingTime = 0;
    public SJF(ArrayList<Process> ProcessList) {
        super(ProcessList);
    }

    public static void sortListByArrivalTime(){

    }

    public static void SimulateSJF(){
        for (Process process: ProcessList ){
            if ( process.getArrivalTime() >= currentTime ){

            }
        }
    }





}
