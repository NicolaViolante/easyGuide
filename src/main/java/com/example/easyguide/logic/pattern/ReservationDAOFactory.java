package com.example.easyguide.logic.pattern;

import com.example.easyguide.logic.model.dao.ReservationDAO;
import com.example.easyguide.logic.model.dao.ReservationDAOCSV;
import com.example.easyguide.logic.model.dao.ReservationDAOJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReservationDAOFactory{
    public ReservationDAO createReservationDAO() throws IOException{
    InputStream input = new FileInputStream("src/main/java/com/example/easyguide/logic/model/dao/config.properties");
    try {
    Properties properties = new Properties();
    properties.load(input);

    String reservationDaoType = properties.getProperty("RESERVATION_DAO_TYPE");

    switch (reservationDaoType){
        case "jdbc": return new ReservationDAOJDBC();
        case "csv": return new ReservationDAOCSV();
        default: throw new IOException("Configuration file error");
    }}
    finally {
        input.close();
    }
}

}
