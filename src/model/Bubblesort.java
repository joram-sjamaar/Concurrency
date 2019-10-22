package model;

import Util.Utils;

import java.util.List;

public class Bubblesort implements Runnable {
    private List<Integer>list;
    public Bubblesort(List<Integer>list) {
        this.list = list;
    }

    @Override
    public void run() {
        list = Utils.bubbleSort(list);
    }

    /*
        bubble sortWithForkList method with threads
     */


    public List<Integer> getList() {
        return list;
    }
}
