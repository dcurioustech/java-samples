package com.dcurioustech.strings;

public class Strings {

    public static void concatenateBasic(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result = result + "word ";
        }
    }

    public static void concatenateStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("word ");
        }
        String result = sb.toString();
    }

    public static void concatenateStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("word ");
        }
        String result = sb.toString();
    }
}
