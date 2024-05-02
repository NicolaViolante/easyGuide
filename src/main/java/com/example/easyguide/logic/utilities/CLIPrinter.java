package com.example.easyguide.logic.utilities;

import com.example.easyguide.logic.model.domain.Status;

public class CLIPrinter {
    private CLIPrinter() { throw new IllegalStateException("Utility class");}
    public static void printMessage(String s) { System.out.print(s);}
    public static void newLine() {System.out.printf("%n");}
    public static void printListOfAvailableTours(int i, String name, float price) {System.out.printf("%s) Tour: %s, price %s€%n",i , name, price);}
    public static void printListOfAvailableDates(int i, java.sql.Date date) {System.out.printf("%s)  %s%n",i , date);}
    public static void printListOfAvailableTimes(int i, java.sql.Time time) {System.out.printf("%s)  %s%n",i , time);}
    public static void printNumbers(int i) {System.out.printf("%s) ", i);}
    public static void printReservation(int i, String tourName, float price, java.sql.Date date, java.sql.Time time,
                                        int people, String touristMail)
                                            {System.out.printf("%s) %s; price %s€; date %s; time %s; people %s; touristMail %s.%n",
                                                    i, tourName, price, date, time, people, touristMail);
                                            }
    public static void printRequest(String tourName, float price, java.sql.Date date, java.sql.Time time,
                                        int people, String guideMail, Status status)
    {System.out.printf("%s; price %s€; date %s; time %s; people %s; guideMail %s; status %s.%n",
             tourName, price, date, time, people, guideMail, status);
    }
}
