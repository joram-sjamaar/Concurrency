import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Week1 {
    public static void main(String[] args) {
        new Week1().run();
    }

    public void run(){
        Opdracht1();
    }

    public void Opdracht1(){

        int[] testNumbers= {
            25000,
            50000,
            100000,
            200000,
            400000
        };

        for (int testNumber : testNumbers) {

            // Genereer een Lijst met wikkeleurige getallen
            ArrayList<Integer> numbers = generateArrayWithNumbers(testNumber);

            System.out.println("***************************************");
            System.out.printf("* Starting SORT of %d numbers\n", testNumber);
            System.out.println("***************************************");

            // Registreer de begin tijd
            Instant startTime = Instant.now();

            // Begin met het sorteren van de nummers
            bubbleSort(numbers);

            // Registreer de eind tijd
            Instant endTime = Instant.now();

            // Laat resultaat zien
            System.out.printf(" -> Sorted %d numbers in: %s\n", testNumber, Duration.between(startTime, endTime));

        }



    }
    public static void bubbleSort(ArrayList<Integer> list) {
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
