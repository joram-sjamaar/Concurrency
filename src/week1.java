import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class week1 {
    public static void main(String[] args) {
        new week1().run();
    }

    public void run(){
        opdracht1();
    }

    public void opdracht1(){
//
        int[] testNumbers= {25000,50000,100000,200000,400000};

        for (int i = 0; i < testNumbers.length; i++) {
            // generates a list with random numbers
            ArrayList<Integer> numbers = generateArrayWithNumbers(testNumbers[i]);

            System.out.println("  --            starting to sort            --");

            Instant startTime  = Instant.now();
            bubblesrt(numbers);
            Instant endTime = Instant.now();

            Duration time = Duration.between(startTime,endTime);

            String string = String.format(" -> Sorted %d numbers in: %s\n", testNumbers[i], time);
            System.out.println(string);

        }



    }
    public static void bubblesrt(ArrayList<Integer> list) {
        int temp;
        if (list.size() > 1) // check if the number of orders is larger than 1
        {
            for (int x = 0; x < list.size(); x++) // bubble sort outer loop
            {
                for (int i = 0; i < list.size() -x - 1; i++) {
                    if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                    }
                }
            }
        }
    }

    private ArrayList<Integer> generateArrayWithNumbers(int amount_of_numbers) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i <= amount_of_numbers; i ++) {
            array.add((int)(Math.random() * 1000 + 1));
        }

        return array;
    }

}
