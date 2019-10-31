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
    private static int[] threshold = {20, 40, 60, 120, 240, 480, 960, 1920, 3840, 7680};


    public static void opdracht5() {
        System.out.println("_________" + "opdracht5" + "_________");
        for (int i = 0; i < threshold.length; i++) {


            List<Integer> numbers = Utils.generateArrayWithNumbers(xNumbers);
            ForkJoinPool commonForkPool = ForkJoinPool.commonPool();
            System.out.printf("\nTry #%d: Size: %d \n", i + 1, threshold[i]);


            Instant startTime = Instant.now();
            numbers = sortWithForkList(numbers, commonForkPool, threshold[i]);
            Instant endTime = Instant.now();
            System.out.printf("Poolsize: %d | Steals: %d ", commonForkPool.getPoolSize(), commonForkPool.getStealCount());

            System.out.println("    --+ finished in: " + Duration.between(startTime, endTime));
//            System.out.println(numbers);

        }


    }

    public static List<Integer> sortWithForkList(List<Integer> numbers, ForkJoinPool commonPool, int threshold) {
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
