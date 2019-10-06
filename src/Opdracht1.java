import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Opdracht1 {

    private ArrayList<Integer> wholeNumbers = new ArrayList<>();

    public static void main(String[] args) {
        new Opdracht1().run();
    }

    private void run() {

        Opgave1();
//        Opgave2();

    }

    private void Opgave1() {

        List<Integer> amount = new ArrayList<>();
        amount.add(100);
        amount.add(100);
//        amount.add(25000);
//        amount.add(50000);
//        amount.add(100000);
//        amount.add(200000);
//        amount.add(400000);

//        for (Integer number_to_generate : amount) {
//
//            List<Integer> numbers = generateArrayWithNumbers(number_to_generate);
//
//            System.out.println("***************************************");
//             System.out.printf("* Starting SORT of %d numbers\n", number_to_generate);
//            System.out.println("***************************************");
//
//            Instant begin = Instant.now();
//
//            List<Integer> sortedList = bubbleSort(numbers);
//
//            Instant eind = Instant.now();
//            Duration tijd = Duration.between(begin, eind);
//
//            String string = String.format(" -> Sorted %d numbers in: %s\n", number_to_generate, tijd);
//            System.out.print(string);
//            System.out.println();
//
//        }
//    }

//    public void Opgave2() {
//
//        List<Integer> amount = new ArrayList<>();
//        amount.add(100);
//
//        for (Integer number_to_generate : amount) {
//
//            List<Integer> numbers = generateArrayWithNumbers(number_to_generate);
//            int middle = numbers.size() / 2;
//
//            // Split array
//            List<Integer> part1 = numbers.subList(0, middle);
//            List<Integer> part1_sorted = bubbleSort(part1);
//
//            List<Integer> part2 = numbers.subList(middle, numbers.size());
//            List<Integer> part2_sorted = bubbleSort(part2);
//
//            System.out.println(part1_sorted);
//            System.out.println(part2_sorted);
//
//        }
//    }

//    @SuppressWarnings("SuspiciousListRemoveInLoop")
//    private List<Integer> bubbleSort(List<Integer> array) {
//
//        int temp;
//        for (int j = 0; j < array.size(); j++) {
//            for (int i = 1; i < array.size() - j; i++) {
//                if (array.get(i - 1) > array.get(i)) {
//
//                    // Sla tijdelijk op
//                    temp = array.get(i);
//
//                    // Wissel getal 1
//                    array.remove(i);
//                    array.add(i, array.get(i - 1));
//
//                    // Wissel getal 2
//                    array.remove(i - 1);
//                    array.add(i - 1, temp);
//                }
//            }
//        }
//
//        return array;
//    }
//
//    private List<Integer> generateArrayWithNumbers(int amount_of_numbers) {
//        List<Integer> array = new ArrayList<>();
//
//        for (int i = 0; i <= amount_of_numbers; i ++) {
//            array.add((int)(Math.random() * 1000 + 1));
//        }
//
//        return array;
//    }
    }
}
