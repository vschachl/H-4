package net.htlgkr.schachlv190241.hue4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamsTester {
    public static void main(String[] args) {
        JavaStreamsTester javaStreamsTester = new JavaStreamsTester();
        List<String> strings = new ArrayList<>();
        strings.add("Apfel");
        strings.add("");
        strings.add("Birne");
        strings.add("Uhr");
        strings.add("");

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(16);
        integers.add(25);
        integers.add(36);

        int estring = getCountEmptyString(strings);
        System.out.println(estring);
        int clength = getCountLength3(strings);
        System.out.println(clength);
        List<String> emtystring = deleteEmtyStrings(strings);
        emtystring.forEach(s -> System.out.println(s));
        String mearged = getMergedString(emtystring, ";");
        System.out.println(mearged);

        List<Integer> squared = getSquares(integers);
        squared.forEach(s -> System.out.println(s));

        int max = getMax(integers);
        int min = getMin(integers);
        int sum = getSum(integers);
        int average = getAverage(integers);
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);
        System.out.println(average);
    }
    private static int getCountEmptyString(List<String> strings){
        return (int) strings.stream().filter(w -> w.isEmpty()).count();
    }

    private static int getCountLength3(List<String> strings){
        return (int) strings.stream().filter(w -> w.length() == 3).count();
    }

    private static List<String> deleteEmtyStrings(List<String> strings){
        return strings.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String separator){
        return strings.stream().collect(Collectors.joining(separator));
    }

    private static List<Integer> getSquares(List<Integer> numbers){
        return numbers.stream().map(w -> (int) Math.sqrt((double) w)).collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers){
        return numbers.stream().mapToInt(c -> c).max().orElseThrow();
    }

    private static int getMin(List<Integer> numbers){
        return numbers.stream().mapToInt(c -> c).min().orElseThrow();
    }

    private static int getSum(List<Integer> numbers){
        return numbers.stream().reduce(0,Integer::sum);
    }

    private static int getAverage(List<Integer> numbers){
        return (int) numbers.stream().mapToInt(c -> c).average().getAsDouble();
    }
}
