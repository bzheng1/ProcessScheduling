/**
 * @author Bryan Zheng
 * @version 4/2/2018.
 */
public class Main {
    private static Object[] processa = new Object[]{"A", 0, 10};
    private static Object[] processb = new Object[]{"B", 1, 29};
    private static Object[] processc = new Object[]{"C", 2, 8};
    private static Object[] processd = new Object[]{"D", 3, 4};
    public static Object[] current;
    public static Object[] queue = new Object[3];
    public int turnaround = 0;
    public static int i = 1;
    public static int counter = 0;
    public static void main(String args[]){
        FCFS(processa, processb,processc,processd);
    }

    public static void FCFS(Object[] processA, Object[] processB, Object[] processC, Object[] processD){
        if(processA[1].equals(0)){
            printout(processA);
            current = processA;
        }else if(processB[1].equals(0)){
            printout(processB);
            current = processB;
        }else if(processC[1].equals(0)){
            printout(processC);
            current = processC;
        }else if(processD[1].equals(0)){
            printout(processD);
            current = processD;
        }
        counter++;
        // For loop adds all processes to the queue.
        for(i = 1; i < 4 ; i++){
            if(processA[1].equals(i)){
                queue[i-1] = processA[0];
                printout1(processA, current, queue);
            }else if(processB[1].equals(i)){
                queue[0] = processB[0];
                printout1(processB, current, queue);
            }else if(processC[1].equals(i)){
                queue[i-1] = processC[0];
                printout1(processC, current, queue);
            }else if(processD[1].equals(i)){
                queue[i-1] = processD[0];
                printout1(processD, current, queue);
            }
        }
        //For loop will run all processes until finish.
        for(int time = 0; time < 1000; time++){
            counter++;
            if(isComplete(current) == true){

            }
        }
    }

    public static void printout(Object[] process){
        System.out.printf("At time %d, proc%s arrives and is scheduled to run since queue is empty. \n",counter, process[0]);
    }

    public static void printout1(Object[] process, Object[] currentProcess, Object[] queue){
        if(i == 3){
            System.out.printf("At time %d, proc%s arrives but is put in queue[%s%s%s] since %s is running. \n",counter, process[0],queue[0], queue[1], queue[2], currentProcess[0]);
            counter++;
        }else if(i == 2)
        {
            System.out.printf("At time %d, proc%s arrives but is put in queue[%s%s] since %s is running. \n",counter, process[0],queue[0], queue[1] , currentProcess[0]);
            counter++;
        }else if(i == 1) {
            System.out.printf("At time %d, proc%s arrives but is put in queue[%s] since %s is running. \n",counter, process[0],queue[0], currentProcess[0]);
            counter++;
        }
    }

    public static void printoutfinished(Object[] process, Object[] nextup, int time){
        System.out.printf("At time %d, proc%s completes(turnaround is %d), and proc%s starts",counter, time, nextup[0]);
    }
    public static boolean isComplete(Object[] process){
        process[2] = counter;
        return true;
    }
//    public static Object[] returnLowest(Object[] processA, Object[] processB, Object[] processC, Object[] processD){
//        int a = (int) processA[2];
//        int b = (int) processB[2];
//        int c = (int) processC[2];
//        int d = (int) processD[2];
//    }
}
