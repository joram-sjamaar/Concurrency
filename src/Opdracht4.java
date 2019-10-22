import Util.Utils;
import model.ArrayDivider;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 *  Maak nu een programma waarin bij het sorteren van de array deze weer in twee helften wordt gesplitst
 *     zoals in opdracht 1.2. Start ook nu voor elke helft weer een thread, waarbij elke thread verantwoordelijk
 *     is voor het sorteren van zijn deel van de lijst.
 *     Dit keer echter bekijkt de thread hoeveel nummers er gesorteerd moeten worden. Is dit meer dan een
 *     bepaalde drempelwaarde, dan zal de thread 2 nieuwe threads aanmaken die ieder weer één helft van
 *     de lijst sorteren. Zijn die threads klaar, dan voegt de thread de twee (gesorteerde) arrays weer samen.
 *     Op die manier ontstaat dus een ‘boom’ van actieve threads.
 *     Threads die hun werk niet gaan ‘outsourcen’ sorteren de arrays weer met bubble sortWithForkList.
 *     Experimenteer nu met de drempelwaarde waarbij een thread het werk gaat uitbesteden aan twee
 *     nieuwe threads. Print steeds weer uit hoe lang het duurt om de array te sorteren.
 *     Toon je resultaten in een grafiek en beantwoord de volgende vragen:
 *             • Vanaf welk punt leverde het verlagen van de drempelwaarde geen verbetering in snelheid meer op?
 *             • Kan je dit verklaren?
 *             • Wat zorgt ervoor dat het werk bij bepaalde drempelwaarden sneller kan worden gedaan?
 *     Waarom heeft het na verloop van tijd geen zin meer om de drempelwaarde te verlagen?
 */

public class Opdracht4 {
    private static int max= 1000;

    public static void Opdracht4(){

//        System.out.println("_________"+ "opdracht4"+"_________");
//
//        ArrayList<Thread> threads = new ArrayList<>();
//        ArrayList<String> halloLijst = new ArrayList<>();
//
//        int test = 50000;
//
//        Instant startTime = Instant.now();
//        System.out.printf("\n-=[ Starting number %d ]=-\n", test);
//        threads.add(new Thread(new MijnMerger(halloLijst, test)));
//
//        try {
//            for (Thread t : threads) {
//                t.start();
//                t.join();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Registreer de eind tijd
//        Instant endTime = Instant.now();
//
//        System.out.println("Threads finished!. Took: " + Duration.between(startTime, endTime));

        int testNumbers=25000;

        // test it 5 times
        Instant start = Instant.now();
        for (int i = 0; i < 5; i++) {


            List<Integer> numbers = Utils.generateArrayWithNumbers(testNumbers);

            System.out.printf("-=[ Starting SORT of %d numbers ]=-\n", testNumbers);

            Instant startTime = Instant.now();
            //paramaters are the list halves
            numbers = divideAndConquer(numbers);

            // Registreer de eind tijd
            Instant endTime = Instant.now();

            System.out.printf(numbers+"  -> Sorted %d numbers in: %s\n\n", testNumbers, Duration.between(startTime, endTime));
            System.out.println(numbers);
        }
        Instant end = Instant.now();
        System.out.printf(" sorting finished in: %s\n\n", Duration.between(start, end));

    }

    private static List<Integer> divideAndConquer(List<Integer> integers){
        ArrayDivider div = new ArrayDivider(integers, max);
        Thread divThread = new Thread(div);
        divThread.start();
        try{
            divThread.join();
        }catch (Exception e ){
            e.printStackTrace();
        }
        return div.getNumbersList();
    }

    public static class MijnMerger implements Runnable {
        private List<String> lijst;
        private int drempelwaarde;

        public MijnMerger(List<String> lijst, int drempelwaarde) {
            this.lijst = lijst;
            this.drempelwaarde = drempelwaarde;
        }

        @Override
        public void run() {
            ArrayList<Thread> threads = new ArrayList<>();

            if (drempelwaarde >= 1) {

                drempelwaarde--;

                threads.add(new Thread(new MijnMerger(lijst, drempelwaarde)));
                for (Thread t : threads) {
                    try {
                        t.start();
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // TODO
            }
        }
    }

}
