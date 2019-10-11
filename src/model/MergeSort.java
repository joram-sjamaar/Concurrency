package model;

import Util.Utils;

import java.util.List;

public class MergeSort implements Runnable {
    private List<Integer> list;
    public MergeSort(List<Integer> numbers){
        this.list = numbers;
    }


    public void run(){
        Utils.sortAndMerge(list, 0, list.size() - 1);
    }

    public List<Integer> getList() {
        return list;
    }
}
