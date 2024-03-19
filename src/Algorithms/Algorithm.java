package Algorithms;

import java.util.ArrayList;
import Process.Process;

public abstract class Algorithm {
    static ArrayList<Process> ProcessList;
    public Algorithm(ArrayList<Process> ProcessList){
        Algorithm.ProcessList =ProcessList;
    }
}
