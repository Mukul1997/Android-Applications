package com.example.mukul_pc.loginandregistration;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

    String ip,db,DBUserNameStr,DBPasswordStr,url;
    Connection connect;
    String ConnectionResult = "";
    Boolean isSuccess = false;

    @SuppressLint("NewApi")
    public Connection connectionclasss()
    {
        url = "jdbc:mysql://127.0.0.1/tinderer";
        DBUserNameStr = "root";
        DBPasswordStr = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection connection = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url,"root","");
        }
        catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }

    public boolean getData(String usr,int pass)
    {
        try
        {
            DatabaseConnector conStr=new DatabaseConnector();
            connect = conStr.connectionclasss();        // Connect to database
            if (connect == null)
            {
                ConnectionResult = "Check Your Internet Access!";
            }
            else
            {
                String query = "select * from member where users = "+usr+" and pass = "+pass+";";
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    isSuccess=true;
                }


                ConnectionResult = " successful";
                connect.close();
            }
        }
        catch (Exception ex)
        {
            isSuccess = false;
            ConnectionResult = ex.getMessage();
        }

        return isSuccess;
    }
}