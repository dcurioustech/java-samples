package com.dcurioustech.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsSamples {
    public static void main(String[] args) {

        System.out.println("================================");
        // Inefficient use of parallel streams
        List<Integer> largeNumbers = new java.util.Random().ints(1_000, 1, 1000).boxed().collect(Collectors.toList());
        System.out.println("Sample count:" + largeNumbers.size());

        // Using sequential streams
        long startTime = System.nanoTime();
        largeNumbers.stream().filter(StreamsSamples::isPrime).count();
        long endTime = System.nanoTime();
        float sequentialTime = endTime - startTime;
        System.out.println("Sequential stream time (milli seconds): " + (sequentialTime)/1_000_000);

        // Using parallel streams
        startTime = System.nanoTime();
        largeNumbers.parallelStream().filter(StreamsSamples::isPrime).count();
        endTime = System.nanoTime();
        float parallelTime = endTime - startTime;
        System.out.println("Parallel stream time (milli seconds): " + (parallelTime)/1_000_000);
        System.out.println("Speedup: " + sequentialTime/parallelTime);

        System.out.println("================================");
        // Efficient use of sequential streams
        largeNumbers = new java.util.Random().ints(10_000_000, 1, 1000).boxed().collect(Collectors.toList());
        System.out.println("Sample count:" + largeNumbers.size());

        // Using sequential streams
        startTime = System.nanoTime();
        largeNumbers.stream().filter(StreamsSamples::isPrime).count();
        endTime = System.nanoTime();
        sequentialTime = endTime - startTime;
        System.out.println("Sequential stream time (milli seconds): " + (sequentialTime)/1_000_000);

        // Using parallel streams
        startTime = System.nanoTime();
        largeNumbers.parallelStream().filter(StreamsSamples::isPrime).count();
        endTime = System.nanoTime();
        parallelTime = endTime - startTime;
        System.out.println("Parallel stream time (milli seconds): " + (parallelTime)/1_000_000);
        System.out.println("Speedup: " + sequentialTime/parallelTime);
    }

    // Intentionally inefficient CPU intensive method
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}