package Algorithms;

import java.util.ArrayList;
import java.util.Collections;

import Process.Process;

public abstract class Algorithm {
    int currentTime = 0;
    int size;
    int totalWaitingTime = 0;

    ArrayList<Process> ProcessList;
    int starvedUnits = 0;

    int STARVATION_TIME;

    public Algorithm(ArrayList<Process> ProcessList) {
        this.ProcessList = new ArrayList<>(ProcessList); // Inicjowanie listy docelowej przy użyciu konstruktora kopiującego
        this.size = ProcessList.size();
        this.STARVATION_TIME=  10;
    }
}
