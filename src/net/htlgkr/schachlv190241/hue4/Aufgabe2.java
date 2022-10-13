package net.htlgkr.schachlv190241.hue4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Aufgabe2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bis zu welcher Zahl wollen Sie die Summe bilden?");
        int scounter = Integer.parseInt(scanner.nextLine());

        Callable<Integer> callable = new Summenformel(scounter);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> result = executorService.submit(callable);
        try {
            int i =result.get();
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

}
