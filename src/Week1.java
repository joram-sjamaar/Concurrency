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

//    Schrijf een Java-programma dat een instelbaar aantal gehele getallen genereert en deze in een array
//    plaats. Sorteer deze getallen met behulp van bubble sort.
//    Bepaal nu hoeveel tijd je programma nodig heeft om de array te sorteren. Test je programma in ieder
//    geval 25.000, 50.000, 100.000, 200.000 en 400.000 getallen en toon de resultaten in je verslag. Wat
//    valt je op aan de resultaten?
//    Om betrouwbare meetresultaten te krijgen, raden we je aan om steeds meerdere metingen te doen
//            (door in je programma het sorteeralgoritme meerdere keren uit te voeren) en daarna het gemiddelde
//    van de metingen te nemen, met uitzondering van de laagste en de hoogste meting.
//    Toon je meetresultaten in je rapport in een overzichtelijke tabel.
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

//    Doe hier hetzelfde als in opdracht 1.1, maar splits nu de array vóór het sorteren in twee helften. Sorteer
//    elke array daarna (achterelkaar, in dezelfde thread). Na het sorteren moet je de twee gesorteerde
//    lijsten uiteraard weer samenvoegen.
//    Hoeveel tijd was er nu nodig voor het sorteren? Welke relatie is er tussen deze meetresultaten en die
//    van de vorige opdracht? Hoe verklaar je dit?
    private void Opdracht2() {

    }

//    Doe hier hetzelfde als in opdracht 1.2, maar laat nu de twee helften van de array door 2 threads
//    uitvoeren die ieder hun eigen helft sorteren. De main thread kan daarna de gesorteerde helften weer
//    samenvoegen tot één gesorteerde array.
//    Hoeveel tijd was er nu nodig voor het sorteren? Wat is de relatie tussen deze meetresultaten en die
//    van de vorige twee opdrachten? Hoe verklaar je dit?
    private void Opdracht3() {

    }

//    Maak nu een programma waarin bij het sorteren van de array deze weer in twee helften wordt gesplitst
//    zoals in opdracht 1.2. Start ook nu voor elke helft weer een thread, waarbij elke thread verantwoordelijk
//    is voor het sorteren van zijn deel van de lijst.
//    Dit keer echter bekijkt de thread hoeveel nummers er gesorteerd moeten worden. Is dit meer dan een
//    bepaalde drempelwaarde, dan zal de thread 2 nieuwe threads aanmaken die ieder weer één helft van
//    de lijst sorteren. Zijn die threads klaar, dan voegt de thread de twee (gesorteerde) arrays weer samen.
//    Op die manier ontstaat dus een ‘boom’ van actieve threads.
//    Threads die hun werk niet gaan ‘outsourcen’ sorteren de arrays weer met bubble sort.
//    Experimenteer nu met de drempelwaarde waarbij een thread het werk gaat uitbesteden aan twee
//    nieuwe threads. Print steeds weer uit hoe lang het duurt om de array te sorteren.
//    Toon je resultaten in een grafiek en beantwoord de volgende vragen:
//            • Vanaf welk punt leverde het verlagen van de drempelwaarde geen verbetering in snelheid
//    meer op?
//            • Kan je dit verklaren?
//            • Wat zorgt ervoor dat het werk bij bepaalde drempelwaarden sneller kan worden gedaan?
//    Waarom heeft het na verloop van tijd geen zin meer om de drempelwaarde te verlagen?
    private void Opdracht4() {

    }

//    De vorige opdracht was een typisch voorbeeld van een divide-and-conquer strategie om een probleem
//    op te lossen. Java heeft een speciaal framework om dit soort oplossingen te implementeren:
//    RecursiveTask in combinatie met een ForkJoin-threadpool.
//    Maak een versie van je programma waarbij je niet zelf de threads maakt (zoals in opdracht 1.4), maar
//    een ForkJoin threadpool gebruikt, samen met de RecursiveTask.
//    Bepaal nu weer hoe lang je programma nodig heeft om te sorteren. Hoe vergelijken de tijden met die
//    van opdracht 1.4? Hoeveel threads denk je dat gebruikt worden door de ForkJoin-pool (leg uit waarom
//            je dat denkt)?
    private void Opdracht5() {

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
