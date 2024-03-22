package Process;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;
public class ProcessGenerator {
    private static Random random = new Random();

    public static Process generateRandomProcess(){
        int arrivalTime = random.nextInt(5);
        int burstTime = random.nextInt(1,3);
        return new Process(arrivalTime,burstTime);
    }

    public static ArrayList<Process> generateProcessList(int size){
        ArrayList<Process> newProcessList = new ArrayList<Process>();
        for (int i = 0; i<size;i++){
            newProcessList.add(generateRandomProcess());
        }
        return newProcessList;
    }
}
