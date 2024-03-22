package Main;
import Algorithms.FCFS;
import Algorithms.ROT;
import Algorithms.SJF;
import Process.Process;
import Process.ProcessGenerator;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        ArrayList<Process> ProcessList = ProcessGenerator.generateProcessList(1000);

        SJF sjf = new SJF(ProcessList);
        System.out.println(sjf.SimulateSJF());

        System.out.println();

        FCFS fcfs = new FCFS(ProcessList);
        System.out.println(fcfs.simulateFCFS());

        System.out.println();

        ROT rot = new ROT(ProcessList);
        System.out.println(rot.simulateROT(3));

    }
}
