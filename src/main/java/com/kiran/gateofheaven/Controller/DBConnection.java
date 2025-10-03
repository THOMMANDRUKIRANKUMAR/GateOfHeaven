package com.kiran.gateofheaven.Controller;


import com.kiran.gateofheaven.View.Songs;

import java.sql.*;


public class DBConnection {
    SQLQueries query = new SQLQueries();

    public DBConnection() throws ClassNotFoundException {
        System.out.println("DBConnection Object Created.");
        Class.forName("org.postgresql.Driver");
    }

    public Connection setConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(query.DBURL, query.USERNAME, query.PASSWORD);
        return conn;
    }

    public Statement stmt() throws SQLException {
        Statement stmt = setConnection().createStatement();
        return stmt;
    }

    public ResultSet resultSet(String query, int id) throws SQLException {

        Songs song = new Songs();
        PreparedStatement preparedStatement = setConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public ResultSet resultSet(String query,String artist) throws SQLException {

        Songs song = new Songs();
        PreparedStatement preparedStatement = setConnection().prepareStatement(query);
        preparedStatement.setString(1, artist);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public void closeConnection() throws SQLException {
        Statement stmt = stmt();
        stmt.close();
    }
}
