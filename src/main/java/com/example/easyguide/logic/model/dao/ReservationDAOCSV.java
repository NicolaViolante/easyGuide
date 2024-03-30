package com.example.easyguide.logic.model.dao;

import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.User;

import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.easyguide.logic.session.SessionManager;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;


public class ReservationDAOCSV implements ReservationDAO{
    private File fd;
    private static final String CSV_FILE_NAME = "localDBFile.csv";
    private static final int INDEX_GUIDEMAIL = 1;
    private static final int INDEX_TOURISTMAIL = 2;
    private static final int INDEX_PEOPLE = 3;
    private static final int INDEX_TIME = 4;
    private static final int INDEX_DATE = 5;
    private static final int INDEX_PRICE = 6;
    private static final int INDEX_TOURNAME = 7;
    private static final int INDEX_STATE = 8;

    public ReservationDAOCSV() throws IOException{
        this.fd = new File(CSV_FILE_NAME);

        if(!fd.exists()){
            throw new IOException(CSV_FILE_NAME + " file does not exists");
        }
    }


    @Override
    public int registerReservation(Reservation reservation) throws IOException, CsvException {

        CSVReader reader = new CSVReader(new BufferedReader(new FileReader(fd)));
        List<String[]> csvBody = reader.readAll();

        for(int i=0; i<csvBody.size(); i++){
            String[] strArray = csvBody.get(i);
            if(strArray[INDEX_GUIDEMAIL].equalsIgnoreCase(reservation.getGuideMail())
                    && strArray[INDEX_TOURISTMAIL].equalsIgnoreCase(reservation.getTouristMail())
                    && strArray[INDEX_TIME].equalsIgnoreCase(String.valueOf(reservation.getTime()))
                    && strArray[INDEX_DATE].equalsIgnoreCase(String.valueOf(reservation.getDate()))
                    && strArray[INDEX_TOURNAME].equalsIgnoreCase(reservation.getTourName())) {
                reader.close();
                return -1;
            }
        }
        reader.close();




        CSVWriter csvWriter = new CSVWriter(new BufferedWriter(new FileWriter(fd, true)));
        String[] reservationRecord = new String[9];

        reservationRecord[INDEX_GUIDEMAIL] = reservation.getGuideMail();
        reservationRecord[INDEX_TOURISTMAIL] = reservation.getTouristMail();
        reservationRecord[INDEX_PEOPLE] = String.valueOf(reservation.getPeople());
        reservationRecord[INDEX_TIME] = reservation.getTime().toString();
        reservationRecord[INDEX_DATE] = reservation.getDate().toString();
        reservationRecord[INDEX_PRICE] = reservation.getPrice().toString();
        reservationRecord[INDEX_TOURNAME] = reservation.getTourName();
        reservationRecord[INDEX_STATE] = "0";


        csvWriter.writeNext(reservationRecord);
        csvWriter.flush();
        csvWriter.close();
        return 1;
    }

    @Override
    public List<Reservation> findTourToAcceptOrDecline(User user) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new BufferedReader(new FileReader(fd)));
        String[] reservationRecord;
        List<Reservation> reservationList = new ArrayList<>();

        while ((reservationRecord = csvReader.readNext())!= null){
            String guideMail = reservationRecord[INDEX_GUIDEMAIL];
            String touristMail = reservationRecord[INDEX_TOURISTMAIL];
            int people = Integer.parseInt(reservationRecord[INDEX_PEOPLE]);
            Time time = Time.valueOf(reservationRecord[INDEX_TIME]);
            Date date = Date.valueOf(reservationRecord[INDEX_DATE]);
            float price = Float.parseFloat(reservationRecord[INDEX_PRICE]);
            String tourName = reservationRecord[INDEX_TOURNAME];
            int state = Integer.parseInt(reservationRecord[INDEX_STATE]);


            if (state == 0 && Objects.equals(guideMail, SessionManager.getInstance().getCurrentUser().getEmail())){
                Reservation reservation = new Reservation(touristMail,
                        people,
                        time,
                        date,
                        price,
                        tourName);

                reservationList.add(reservation);
            }
        }

        csvReader.close();
        return reservationList;

    }

    @Override
    public void changeStatus(Reservation reservation) throws IOException, CsvException {


        CSVReader reader = new CSVReader(new BufferedReader(new FileReader(fd)));
        List<String[]> csvBody = reader.readAll();

        for(int i=0; i<csvBody.size(); i++){
            String[] strArray = csvBody.get(i);
                if(strArray[INDEX_GUIDEMAIL].equalsIgnoreCase(reservation.getGuideMail())
                && strArray[INDEX_TOURISTMAIL].equalsIgnoreCase(reservation.getTouristMail())
                && strArray[INDEX_TIME].equalsIgnoreCase(String.valueOf(reservation.getTime()))
                && strArray[INDEX_DATE].equalsIgnoreCase(String.valueOf(reservation.getDate()))
                && strArray[INDEX_TOURNAME].equalsIgnoreCase(reservation.getTourName())) {
                    csvBody.get(i)[INDEX_STATE] = String.valueOf(reservation.getState());
                }
        }
        reader.close();
        CSVWriter csvWriter = new CSVWriter(new BufferedWriter(new FileWriter(fd)));
        csvWriter.writeAll(csvBody);
        csvWriter.flush();
        csvWriter.close();

    }

}

