package net.htlgkr.schachlv190241.hue4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Aufgabe1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner s = new Scanner(System.in);
        Aufgabe1 aufgabe1 = new Aufgabe1();
        List<Integer> numbers = new ArrayList<>();
        int divider = -1;
        int chunk = -1;

        //readCSV
        aufgabe1.readCSV(numbers);
        System.out.println("CSV wurde eingelesen");

        //checke ob teilbar durch Benutzereingabe
        System.out.println("Wie lange soll ein Chunk sein?");
        chunk = Integer.parseInt(s.nextLine());

        System.out.println("Geben Sie einen beliebigen Teiler ein:");
        divider = Integer.parseInt(s.nextLine());
        int counter = 100;

        Callable<List<Integer>> callable = new Teilen(divider, counter, numbers);
        ExecutorService executorService = Executors.newFixedThreadPool(chunk);

        for(int i = 0; i < chunk; i++){
            Future<List<Integer>> result = executorService.submit(callable);
        }
        executorService.shutdown();
    }

    public Stream<List<Integer>> seperateList(List<Integer> source, int length) throws IllegalAccessException {
        if(length <= 0){
            throw new IllegalAccessException("length = " + length);
        }
        int size = source.size();
        if(size <= 0){
            return Stream.empty();
        }
        int fullChunks = (size -1) /length;
        return IntStream.range(0, fullChunks+1)
                .mapToObj(n -> source.subList(n*length, n == fullChunks ? size : (n+1)*length));
    }

    public List<Integer> readCSV(List<Integer> n){
        try {
            Scanner scanner = new Scanner(new File("numbers.csv"));

            while (scanner.hasNextLine()){
                String read = scanner.nextLine();
                String[] split = read.split(":");

                for (int i = 0; i < split.length; i++){

                    if (split[i] != null && !split[i].equals("")&& split[i].matches("[+-]?\\d*(\\.\\d+)?")){
                        n.add(Integer.valueOf(split[i]));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return n;
    }
}
