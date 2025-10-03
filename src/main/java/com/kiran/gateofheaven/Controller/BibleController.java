package com.kiran.gateofheaven.Controller;

import com.kiran.gateofheaven.Model.Bible;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibleController {

    DBConnection connection; // your connection manager
    SQLQueries sqlQueries;   // holds SQL strings

    public BibleController() {
        try {
            connection = new DBConnection(); // make sure DBConnection is initialized
            sqlQueries = new SQLQueries();   // initialize SQLQueries
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Bible> chapterView(String chapter_name, int chapter_no) {
        List<Bible> list = new ArrayList<>();
        String sql = sqlQueries.chapterVerses; // e.g. SELECT verse_number, verse FROM telugu_bible WHERE "book_name_english"=? AND "chapter_number"=? ORDER BY "verse_number"

        try (Connection conn = connection.setConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, chapter_name);
            ps.setInt(2, chapter_no);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bible b = new Bible();
                    b.setBookName(rs.getString("book_name_telugu"));
                    b.setVerseNumber(rs.getInt("verse_number"));
                    b.setVerse(rs.getString("verse"));
                    list.add(b);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
