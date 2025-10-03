package com.kiran.gateofheaven.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/Post")
public class PostController extends HttpServlet {

    SQLQueries sqlQueries = new SQLQueries();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String songName = req.getParameter("songName");
        String songNameEnglish = req.getParameter("songNameEnglish");
        String songData = req.getParameter("songData");
        String songArtist = req.getParameter("songArtist");
        String songCategory = req.getParameter("songCategory");
        Date songDate = Date.valueOf(req.getParameter("songDate"));

        try {
            DBConnection connection = new DBConnection();
            connection.setConnection();

            PreparedStatement preparedStatement = connection.setConnection().prepareStatement(sqlQueries.check);
            preparedStatement.setString(1, songName);
            preparedStatement.setString(2, songNameEnglish);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                resultSet.next();
                int count = resultSet.getInt(1);

                if(count > 0){
                    // 🚨 Song already exists
                    resp.sendRedirect("post.jsp?exists=true");
                    return;
                }
            }
            // ✅ Otherwise insert
            try (PreparedStatement ps = connection.setConnection().prepareStatement(sqlQueries.insert)) {
                ps.setString(1, songName);
                ps.setString(2, songNameEnglish);
                ps.setString(3, songData);
                ps.setString(4, songArtist);
                ps.setString(5, songCategory);
                ps.setDate(6, songDate);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    resp.sendRedirect("post.jsp?success=true");
                } else {
                    resp.sendRedirect("post.jsp?success=false");
                }
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
