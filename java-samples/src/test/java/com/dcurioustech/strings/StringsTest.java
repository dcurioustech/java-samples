package com.dcurioustech.strings;

import org.junit.jupiter.api.Test;

public class StringsTest {
    
    @Test
    public void test() throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        long startMemory, endMemory, startTime, endTime, duration, memoryUsed;
        for (int i = 10; i < 1000000; i = i * 10) {
            System.out.println("With iterations: " + i);
            runtime.gc();
            startMemory = runtime.totalMemory() - runtime.freeMemory();
            startTime = System.nanoTime();
            Strings.concatenateBasic(i);
            endTime = System.nanoTime();
            endMemory = runtime.totalMemory() - runtime.freeMemory();
            duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            memoryUsed = (endMemory - startMemory) / 1024; // in KB
            System.out.println("Time taken using '+': " + duration + " ms, Memory used: " + memoryUsed + " KB");

            runtime.gc();
            startMemory = runtime.totalMemory() - runtime.freeMemory();
            startTime = System.nanoTime();
            Strings.concatenateStringBuilder(i);
            endTime = System.nanoTime();
            endMemory = runtime.totalMemory() - runtime.freeMemory();
            duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            memoryUsed = (endMemory - startMemory) / 1024; // in KB
            System.out.println("Time taken using StringBuilder: " + duration + " ms, Memory used: " + memoryUsed + " KB");

            runtime.gc();
            startMemory = runtime.totalMemory() - runtime.freeMemory();
            startTime = System.nanoTime();
            Strings.concatenateStringBuffer(i);
            endTime = System.nanoTime();
            endMemory = runtime.totalMemory() - runtime.freeMemory();
            duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            memoryUsed = (endMemory - startMemory) / 1024; // in KB
            System.out.println("Time taken using StringBuffer: " + duration + " ms, Memory used: " + memoryUsed + " KB");

            Thread.sleep(1000); // Sleep for 1 second between iterations
        }
    }
}
