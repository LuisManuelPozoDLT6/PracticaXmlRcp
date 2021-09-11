package com.example.PracticaXml.server;

import com.example.PracticaXml.database.ConnectionMysql;
import com.example.PracticaXml.user.User;

import java.sql.*;

public class Handler {
    Connection con;
    PreparedStatement pstm;
    Statement statement;
    ResultSet rs;


    public boolean createUser (String name, int status){
        User user = new User();
        boolean state = false;
        try {
            user.setName(name);
            user.setStatus(status);
            con = ConnectionMysql.getConnection();
            String query = "insert into user (user.name, user.status) values (?, ?);";
            pstm = con.prepareStatement(query);
            pstm.setString(1, user.getName());
            pstm.setInt(2, user.getStatus());
            state = pstm.executeUpdate() == 1;
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
        return state;
    }

    public void closeConnection(){
        try{
            if (con != null){
                con.close();
            }
            if (pstm != null){
                pstm.close();
            }
            if (rs != null){
                rs.close();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
