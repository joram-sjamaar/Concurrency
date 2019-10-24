package model;

import Util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;



public class ForkList extends RecursiveTask<List<Integer>> {
    private List<Integer> numbers;
    private int max;
    private List<Integer> tempList;

    public ForkList(List<Integer> numbers, int max) {
        this.numbers = numbers;
        this.max = max;
    }


    @Override
    protected List<Integer> compute() {
        if (numbers.size() <= max) {
            return  Utils.bubbleSort(numbers);
        }

        List<Integer> part1 = numbers.subList(0, numbers.size() / 2);
        List<Integer> part2 = numbers.subList(numbers.size() / 2, numbers.size());

        ForkList leftFork = new ForkList(part1, max);
        ForkList rightFork = new ForkList(part2, max);

        leftFork.fork();
        rightFork.fork();

        leftFork.join();
        rightFork.join();

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        try {
            leftList.addAll(leftFork.get());
            rightList.addAll(rightFork.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        tempList = Utils.mergeLists(rightList ,leftList );
        return tempList;
    }


    public List<Integer> getNumbers() {
        numbers = tempList;
        return numbers;
    }

//    public List<Integer> mergeLists(List<Integer> leftList, List<Integer> rightList) {
////        int[] left = new int[leftList.size()];
////        int[] right = new int[rightList.size()];
////        for (int i = 0; i < leftList.size(); i++) {
////            left[i] = leftList.get(i);
////        }
////        for (int i = 0; i < rightList.size(); i++) {
////            right[i] = rightList.get(i);
////        }
//
//        int[] result = Utils.mergeLists(leftList, rightList);
//
//        List<Integer> tempList = new ArrayList<>();
//
//        for (int i : result) {
//            tempList.add(i);
//        }
//
//        return tempList;
//    }
}
