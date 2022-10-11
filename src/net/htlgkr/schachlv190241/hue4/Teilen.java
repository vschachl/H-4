package net.htlgkr.schachlv190241.hue4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Teilen implements Callable<List<Integer>> {
private int divider;
private int chunk;
    List<Integer> numbers = new ArrayList<>();
    Stream<List<Integer>> chunks = null;

    public Teilen(int divider, int chunk, List<Integer> numbers) {
        this.divider = divider;
        this.chunk = chunk;
        this.numbers = numbers;
    }

    public void checkDivider(List<Integer> n, int divider){
        for (int i = 0; i < n.size(); i++){
            if (n.get(i)%divider == 0){
                System.out.println(n.get(i));
            }
        }
    }

    @Override
    public List<Integer> call() throws Exception {
        return numbers;
    }
}
