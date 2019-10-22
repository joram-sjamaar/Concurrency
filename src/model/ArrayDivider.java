package model;

import Util.Utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayDivider extends Thread{
    private List<Integer> numbers;
    private int max;

    public ArrayDivider(List<Integer> numbers, int max) {
        this.numbers = numbers;
        this.max = max;
    }

    @Override
    public void run() {
        if (numbers.size()<= max){
            numbers = Utils.bubbleSort(numbers);
        }else{
            ArrayList<ArrayDivider> arrayDividers= new ArrayList<>();
            // split array in 2
            List<Integer> part1 = numbers.subList(0, numbers.size() / 2);
            List<Integer> part2 = numbers.subList(numbers.size() / 2, numbers.size());

            //recursive decleration to divide the array in equal parts until it has reached the max
            ArrayDivider div1 = new ArrayDivider(part1,max);
            arrayDividers.add(div1);
            ArrayDivider div2 = new ArrayDivider(part2,max);
            arrayDividers.add(div2);

            // enable new threads
            for (ArrayDivider arrayDivider: arrayDividers){
                arrayDivider.start();
            }

            //join threads
            for (ArrayDivider arrayDivider: arrayDividers){
                try{
                    arrayDivider.join();

                }catch (Exception e ){
                    e.printStackTrace();
                }
            }


            numbers = Utils.mergeLists(div1.getNumbersList(),div2.getNumbersList());



        }
    }

    public List<Integer> getNumbersList() {
        return numbers;
    }
}
