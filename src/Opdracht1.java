import Util.Utils;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Opdracht1 {

//    Schrijf een Java-programma dat een instelbaar aantal gehele getallen genereert en deze in een array
//    plaats. Sorteer deze getallen met behulp van bubble sort.
//    Bepaal nu hoeveel tijd je programma nodig heeft om de array te sorteren. Test je programma in ieder
//    geval 25.000, 50.000, 100.000, 200.000 en 400.000 getallen en toon de resultaten in je verslag. Wat
//    valt je op aan de resultaten?
//    Om betrouwbare meetresultaten te krijgen, raden we je aan om steeds meerdere metingen te doen
//            (door in je programma het sorteeralgoritme meerdere keren uit te voeren) en daarna het gemiddelde
//    van de metingen te nemen, met uitzondering van de laagste en de hoogste meting.
//    Toon je meetresultaten in je rapport in een overzichtelijke tabel.

    public static void Opdracht1(){
        System.out.println("_________"+ "opdracht1"+"_________");


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

            // Begin met het sorteren van de nummers
             numbers = Utils.bubbleSort(numbers);

            // Registreer de eind tijd
            Instant endTime = Instant.now();

            // Laat resultaat zien
            System.out.printf(" -> Sorted %d numbers in: %s\n", testNumber, Duration.between(startTime, endTime));
        }

    }
}
