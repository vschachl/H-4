package net.htlgkr.schachlv190241.hue4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Aufgabe1 {
    List<Integer> numbers = new ArrayList<>();
    Stream<List<Integer>> chunks = null;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Aufgabe1 aufgabe1 = new Aufgabe1();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) newFixedThreadPool(2);

        int divider = -1;
        int chunk = -1;

        //readCSV
        aufgabe1.readCSV();

        //checke ob teilbar durch Benutzereingabe
        System.out.println("Wie lange soll ein Chunk sein?");
        chunk = Integer.parseInt(s.nextLine());
        try {
            aufgabe1.chunks = aufgabe1.batches(aufgabe1.numbers, chunk);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("Geben Sie einen beliebigen Teiler ein:");
        divider = Integer.parseInt(s.nextLine());
        for (int i = 0; i <= 2; i++){

        }
        aufgabe1.checkDivider(divider);
    }
    public void checkDivider(int divider){
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i)%divider == 0){
                System.out.println(numbers.get(i));
            }
        }
    }

    public Stream<List<Integer>> batches(List<Integer> source, int length) throws IllegalAccessException {
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

    public void readCSV(){
        try {
            Scanner scanner = new Scanner(new File("numbers.csv"));

            while (scanner.hasNextLine()){
                String read = scanner.nextLine();
                String[] split = read.split(":");

                for (int i = 0; i < split.length; i++){

                    if (split[i] != null && !split[i].equals("")&& split[i].matches("[+-]?\\d*(\\.\\d+)?")){
                        numbers.add(Integer.valueOf(split[i]));
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
