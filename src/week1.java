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
        int[] testNumbers= {25000,50000,100000,200000,400000};

        for (int i = 0; i < testNumbers.length; i++) {
            // generates a list with random numbers
            List<Integer> numbers = generateArrayWithNumbers(testNumbers[i]);

            System.out.println("  --            starting to sort            --");

            Instant startTime  = Instant.now();
            List<Integer> sortedList = bubbleSort(numbers);
            Instant endTime = Instant.now();

            Duration time = Duration.between(startTime,endTime);

            String string = String.format(" -> Sorted %d numbers in: %s\n", testNumbers[i], time);
            System.out.println(string);

        }



    }


    private List<Integer> bubbleSort(List<Integer> array) {

        int temp;
        for (int j = 0; j < array.size(); j++) {
            for (int i = 1; i < array.size() - j; i++) {
                if (array.get(i - 1) > array.get(i)) {

                    // Sla tijdelijk op
                    temp = array.get(i);

                    // Wissel getal 1
                    array.remove(i);
                    array.add(i, array.get(i - 1));

                    // Wissel getal 2
                    array.remove(i - 1);
                    array.add(i - 1, temp);
                }
            }
        }

        return array;
    }

    private List<Integer> generateArrayWithNumbers(int amount_of_numbers) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i <= amount_of_numbers; i ++) {
            array.add((int)(Math.random() * 1000 + 1));
        }

        return array;
    }

}
