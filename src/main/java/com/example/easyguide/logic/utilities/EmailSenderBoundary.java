package com.example.easyguide.logic.utilities;

import com.example.easyguide.logic.exceptions.EmailSenderException;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.pattern.Observer;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailSenderBoundary implements Observer {
    private Reservation reservation;
    private static final String EMAIL_FILE = "EmailSentFile.txt";
    public EmailSenderBoundary(Reservation reservation) throws EmailSenderException {
        checkFile();
        this.reservation = reservation;
    }
    @Override
    public void update() {


            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(EMAIL_FILE)))) {

            checkFile();
                String state = "";
                if (reservation.getState().getId() == 1)
                    state = "accepted";
                else if (reservation.getState().getId() == 2)
                    state = "rejected";
                printWriter.println("Email sent from: " + reservation.getGuideMail());
                printWriter.println("Email sent to: " + reservation.getTouristMail());
                printWriter.printf("The reservation for %s, date: %s, time: %s, people: %s, price: %s has been %s",
                        reservation.getTourName(),
                        reservation.getDate(),
                        reservation.getTime(),
                        reservation.getPeople(),
                        reservation.getPrice(),
                        state);

        }
        catch (IOException | EmailSenderException e) {
            Logger.getAnonymousLogger().log(Level.INFO,e.getMessage());
        }
    }

    private void checkFile() throws EmailSenderException {
        File f = new File(EMAIL_FILE);

        if(!f.exists())
            throw new EmailSenderException("File doesn't exists");

        if(!f.canWrite())
            throw new EmailSenderException("Cannot write on file");
    }
}


