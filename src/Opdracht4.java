import Util.Utils;
import model.ArrayDivider;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Maak nu een programma waarin bij het sorteren van de array deze weer in twee helften wordt gesplitst
 * zoals in opdracht 1.2. Start ook nu voor elke helft weer een thread, waarbij elke thread verantwoordelijk
 * is voor het sorteren van zijn deel van de lijst.
 * Dit keer echter bekijkt de thread hoeveel nummers er gesorteerd moeten worden. Is dit meer dan een
 * bepaalde drempelwaarde, dan zal de thread 2 nieuwe threads aanmaken die ieder weer één helft van
 * de lijst sorteren. Zijn die threads klaar, dan voegt de thread de twee (gesorteerde) arrays weer samen.
 * Op die manier ontstaat dus een ‘boom’ van actieve threads.
 * Threads die hun werk niet gaan ‘outsourcen’ sorteren de arrays weer met bubble sortWithForkList.
 * Experimenteer nu met de drempelwaarde waarbij een thread het werk gaat uitbesteden aan twee
 * nieuwe threads. Print steeds weer uit hoe lang het duurt om de array te sorteren.
 * Toon je resultaten in een grafiek en beantwoord de volgende vragen:
 * • Vanaf welk punt leverde het verlagen van de drempelwaarde geen verbetering in snelheid meer op?
 * • Kan je dit verklaren?
 * • Wat zorgt ervoor dat het werk bij bepaalde drempelwaarden sneller kan worden gedaan?
 * Waarom heeft het na verloop van tijd geen zin meer om de drempelwaarde te verlagen?
 */

public class Opdracht4 {

    public static void Opdracht4() {

        int[] maxArray = {
                100
        };

        for (int max : maxArray) {

            // Begin sorteren
            List<Integer> numbers = Utils.generateArrayWithNumbers(25000);
            System.out.printf("-=[ Starting SORT with a max of %d ]=-\n", max);

            // Registreer de begin tijd
            Instant startTime = Instant.now();

            divideAndConquer(numbers, max);

            // Registreer de eind tijd
            Instant endTime = Instant.now();

            System.out.printf("  -> Sorted with a max of %d in: %s\n\n", max, Duration.between(startTime, endTime));
        }

    }

    private static List<Integer> divideAndConquer(List<Integer> integers, int max) {
        ArrayDivider div = new ArrayDivider(integers, max);
        Thread divThread = new Thread(div);
        divThread.start();
        try {
            divThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return div.getNumbersList();
    }


}
