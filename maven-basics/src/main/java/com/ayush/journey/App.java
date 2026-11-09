package com.ayush.journey;

public class App {
    public static void main(String[] args) {
        String raw = "   design   the   login API   ";
        System.out.println("Raw: '" + raw + "'");
        System.out.println("Formatted: '" + TaskTitleFormatter.format(raw) + "'");
        System.out.println("Running on Java " + Runtime.version().feature());
    }
}