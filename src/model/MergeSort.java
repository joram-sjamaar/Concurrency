package model;

import java.util.List;

public class MergeSort {
    public static void  sort(List<Integer> list) {
        sortAndMerge(list, 0, list.size() - 1);
    }

    private static void sortAndMerge(List<Integer> list, int start, int end) {
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
    }
}
