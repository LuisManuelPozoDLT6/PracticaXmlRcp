package com.example.PracticaXml.database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/xmlrcp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
    }

    public static void main(String[] args) {
        try {
            Connection con = ConnectionMysql.getConnection();
            System.out.println("Conexión exitosa!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
