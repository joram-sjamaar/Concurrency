import Util.Utils;
import model.MergeSort;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Opdracht2 {

    //    Doe hier hetzelfde als in opdracht 1.1, maar splits nu de array vóór het sorteren in twee helften. Sorteer
    //    elke array daarna (achterelkaar, in dezelfde thread). Na het sorteren moet je de twee gesorteerde lijsten uiteraard weer samenvoegen.
    //    Hoeveel tijd was er nu nodig voor het sorteren? Welke relatie is er tussen deze meetresultaten en die
    //    van de vorige opdracht? Hoe verklaar je dit?
    public static void Opdracht2() {
        System.out.println("_________"+ "opdracht2"+"_________");



        int[] testNumbers= {
                25000,
                50000,
                100000,
                200000,
                400000
        };

        for (int testNumber : testNumbers) {

            // Genereer een Lijst met wikkeleurige getallen
            List<Integer> numbers = Utils.generateArrayWithNumbers(testNumber);

            System.out.printf("-=[ Starting SORT of %d numbers ]=-\n", testNumber);

            // Registreer de begin tijd
            Instant startTime = Instant.now();

            // Splits de array
            List<Integer> part1 = numbers.subList(0, numbers.size() / 2);
            List<Integer> part2 = numbers.subList(numbers.size() / 2, numbers.size());

            part1 = Utils.bubbleSort(part1);
            part2 = Utils.bubbleSort(part2);

            part1.addAll(part2);

            numbers = Utils.sortAndMerge(part1, 0, part1.size()-1);


            // Registreer de eind tijd
            Instant endTime = Instant.now();

            // Laat resultaat zien
            System.out.printf(" -> Sorted %d numbers in: %s\n\n", testNumber, Duration.between(startTime, endTime));

        }

    }
}
