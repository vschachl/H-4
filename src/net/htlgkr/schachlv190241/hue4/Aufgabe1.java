package net.htlgkr.schachlv190241.hue4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Aufgabe1 {
    List<Integer> numbers = new ArrayList<>();
    public static void main(String[] args) {
        Aufgabe1 aufgabe1 = new Aufgabe1();

        //readCSV
        aufgabe1.readCSV();

        aufgabe1.numbers.forEach(s -> System.out.println(s));
    }

    public void readCSV(){
        try {
            Scanner scanner = new Scanner(new File("numbers.csv"));

            while (scanner.hasNextLine()){
                String read = scanner.nextLine();
                String[] split = read.split(":");
                String alphabet = "abcdefghijklmnopqrstuvwxyz";

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
