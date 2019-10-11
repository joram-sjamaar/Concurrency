import Util.Utils;
import model.Bubblesort;
import model.MergeSort;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Opdracht3 {
    public static void Opdracht3(){
        System.out.println("_________"+ "opdracht3"+"_________");

        int[] testNumbers= {
                25000,
                50000,
                100000,
                200000,
                400000
        };

        for (int testNumber : testNumbers) {
            List<Integer> numbers = Utils.generateArrayWithNumbers(testNumber);

            System.out.printf("-=[ Starting SORT of %d numbers ]=-\n", testNumber);

            Instant startTime = Instant.now();
            //paramaters are the list halves
            numbers = bubbleMerge(numbers.subList(0, numbers.size() / 2), numbers.subList(numbers.size() / 2, numbers.size()-1));

            // Registreer de eind tijd
            Instant endTime = Instant.now();

            System.out.printf(numbers.size() + " -> Sorted %d numbers in: %s\n\n", testNumber, Duration.between(startTime, endTime));
            System.out.println(numbers);
        }






    }

    /**
     * bubble sorts and merges two list with threads
     * @return sorted list
     */
    private static List<Integer> bubbleMerge(List<Integer> part1, List<Integer> part2){

        ArrayList<Thread> threads = new ArrayList();
            Thread t1,t2;
            Bubblesort list1, list2;

            //first thread to bubblesort the first half
            list1 = new Bubblesort(part1);
            t1= new Thread(list1);
            t1.start();
            threads.add(t1);

            //second thread to bubblesort the second half

            list2 = new Bubblesort(part2);
            t2= new Thread(list2);
            t2.start();
            threads.add(t2);

            //join all threads
            for (Thread thread: threads){
                try{
                    thread.join();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            List<Integer> combinedList = list1.getList();
            combinedList.addAll(list2.getList());
            combinedList = Utils.sortAndMerge(combinedList,0,part1.size()-1);


        return combinedList;
    }

}
