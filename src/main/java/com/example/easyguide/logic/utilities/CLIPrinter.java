package com.example.easyguide.logic.utilities;

public class CLIPrinter {
    private CLIPrinter() { throw new IllegalStateException("Utility class");}
    public static void printMessage(String s) { System.out.print(s);}
    public static void printListOfAvailableTours(int i, String name, float price) {System.out.printf("%s) Tour: %s, prezzo %s\n",i , name, price);}
    public static void printListOfAvailableDates(int i, java.sql.Date date) {System.out.printf("%s)  %s\n",i , date);}
    public static void printNumbers(int i) {System.out.printf("%s) ", i);}
}
