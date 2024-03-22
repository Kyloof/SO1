package Sorts;

import java.util.Comparator;
import Process.Process;

public class burstSort implements Comparator<Process> {
    @Override
    public int compare(Process p1, Process p2) {
        return p1.getBurstTime() - p2.getBurstTime();
    }
}
