package net.htlgkr.schachlv190241.hue4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Summenformel implements Callable<Integer> {
    List<Integer> numbers = new ArrayList<>();
    private int lastNumber;
    public Summenformel(int lastNumber) {
        this.lastNumber = lastNumber;
    }


    public int sumUp(List<Integer> integers){
        int sum = 0;
        for (int i = 0; i < integers.size(); i++){
            sum = sum + integers.get(i);
        }
        return sum;
    }

    public void befüllen(List<Integer> n){
        for (int i = 0; i <= lastNumber; i++){
            n.add(i);
        }
    }

    @Override
    public Integer call() throws Exception {
        befüllen(numbers);
        return sumUp(numbers);
    }
}
