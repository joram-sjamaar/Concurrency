package Util;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    /**
     * generates a list with random numbers
     *
     * @param amount_of_numbers specified amount of numbers to generate
     * @return list with random numbers
     */
    public static ArrayList<Integer> generateArrayWithNumbers(int amount_of_numbers) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 1; i <= amount_of_numbers; i++) {
            array.add((int) (Math.random() * 1000 + 1));
        }

        return array;
    }





    public static List<Integer> bubbleSort(List<Integer> list) {
        int temp;
        if (list.size() > 1) // check if the number of orders is larger than 1
        {
            for (int x = 0; x < list.size(); x++) // bubble sortWithForkList outer loop
            {
                for (int i = 0; i < list.size() - x - 1; i++) {
                    if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                    }
                }
            }
        }
        return list;
    }

    public static List<Integer> sortAndMerge(List<Integer> list, int start, int end) {
        if ((end - start) >= 2) {
            int mid = (end - start) / 2;
            sortAndMerge(list, start, start + mid);
            sortAndMerge(list, start + mid + 1, end);

            int i = start;
            int j = start + mid + 1;
            while (i < j && j <= end) {
                if (list.get(i) > list.get(j)) {
                    list.add(i, list.remove(j));
                    i++;
                    j++;
                } else if (list.get(i) == list.get(j)) {
                    list.add(i + 1, list.remove(j));
                    i++;
                    j++;
                } else {
                    i++;
                }
            }

        } else {
            if (end > start) {
                if (list.get(start) > list.get(end)) {
                    int endValue = list.remove(end);
                    list.add(start, endValue);
                }
            }
        }
        // if done return list
        return list;
    }

    public static List<Integer> mergeLists(List<Integer>l1, List<Integer>l2){
        List <Integer> mergedList = new ArrayList<>();

        int c = 0, d = 0, e = 0;

        while ((c < l1.size()) & (d < l2.size())) {
            if (l1.get(c) <= l2.get(d)) {
                mergedList.add(e, l1.get(c));
                c++;
            } else {
                mergedList.add(e, l2.get(d));
                d++;
            }
            e++;
        }
        while (c < l1.size()) {
            mergedList.add(e, l1.get(c));
            c++;
            e++;
        }
        while (d < l2.size()) {
            mergedList.add(e, l2.get(d));
            d++;
            e++;
        }
         System.out.println(mergedList.size()+"     "+mergedList);

        return mergedList;
    }



}
