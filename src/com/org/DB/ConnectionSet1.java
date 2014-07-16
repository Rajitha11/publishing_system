/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tuan
 */
public class ConnectionSet1 {

    private static ConnectionSet1 con;
    
    private String severIp = "localhost";
    private String severPort = "3306";
    private String userName = "root";
    private String password = "";
    private ResultSet rs;

    private ConnectionSet1() {
    }

    public static synchronized ConnectionSet1 getInstance() {
        if (con == null) {
            con = new ConnectionSet1();
            System.out.println("q");
        }
        System.out.println("w");
        return con;
    }

    public void setSeverIp(String Ip) {
        severIp = Ip;
    }

    public void setSeverPort(String Port) {
        severPort = Port;
    }

    public void SetUserName(String Name) {
        userName = Name;
    }

    public void setPassword(String passWord) {
        password = passWord;
    }

    public ResultSet getResult(String url) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cc = (Connection) DriverManager.getConnection("jdbc:mysql://" + getSeverIp() + ":" + getSeverPort() + "/publishing_system", getUserName(), getPassword());

        Statement s = cc.createStatement();
        rs = s.executeQuery(url);
//          java.sql.ResultSet rs = (ResultSet) DriverManager.getConnection("jdbc:mysql://"+getSeverIp()+":"+getSeverPort()+"/inqua",getUserName(), getPassword()).createStatement().executeQuery(url);

        return rs;


    }

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cc = (Connection) DriverManager.getConnection("jdbc:mysql://" + getSeverIp() + ":" + getSeverPort() + "/publishing_system", getUserName(), getPassword());
        return cc;
    }

    public void setResult(String url) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cc = (Connection) DriverManager.getConnection("jdbc:mysql://" + getSeverIp() + ":" + getSeverPort() + "/publishing_system", getUserName(), getPassword());
        Statement s = (Statement) cc.createStatement();

        s.executeUpdate(url);
    }

    public PreparedStatement setImage(String url) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cc = (Connection) DriverManager.getConnection("jdbc:mysql://" + getSeverIp() + ":" + getSeverPort() + "/publishing_system", getUserName(), getPassword());
        PreparedStatement s = cc.prepareStatement(url);

        return s;

    }

    public String getSeverIp() {
        return severIp;
    }

    public String getSeverPort() {
        return severPort;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
