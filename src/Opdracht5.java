import Util.Utils;
import model.ForkList;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Opdracht5 {
    private static int amountOfTries = 20;
    private static int xNumbers = 25000;
    private static int threshold = 1000;


    public static void opdracht5() {
        System.out.println("_________" + "opdracht5" + "_________");
        for (int i = 0; i < amountOfTries; i++) {


            List<Integer> numbers = Utils.generateArrayWithNumbers(xNumbers);
            ForkJoinPool commonForkPool = ForkJoinPool.commonPool();
            System.out.println("try: " + (i + 1));

            System.out.println("            poolsize: " + commonForkPool.getPoolSize());

            Instant startTime = Instant.now();
            numbers = sortWithForkList(numbers, commonForkPool);
            Instant endTime = Instant.now();

            System.out.println("    --+ finished in: " + Duration.between(startTime, endTime));
//            System.out.println(numbers);

        }


    }

    public static List<Integer> sortWithForkList(List<Integer> numbers, ForkJoinPool commonPool) {
        ForkList task = new ForkList(numbers, threshold);
        commonPool.execute(task);
        try {
            task.get().size();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return task.getNumbers();
    }
}
