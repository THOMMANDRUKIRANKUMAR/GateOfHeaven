package com.kiran.gateofheaven.View;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/BibleView")
public class BibleView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Map<String, Object>> OT = new ArrayList<>();
        List<Map<String, Object>> NT = new ArrayList<>();

        // --- Old Testament ---
        OT.add(Map.of("name","Genesis","telugu","ఆదికాండము","chapters",50));
        OT.add(Map.of("name","Exodus","telugu","నిర్గమకాండము","chapters",40));
        OT.add(Map.of("name","Leviticus","telugu","లేవీయకాండము","chapters",27));
        OT.add(Map.of("name","Numbers","telugu","సంఖ్యాకాండము","chapters",36));
        OT.add(Map.of("name","Deuteronomy","telugu","ద్వితీయోపదేశకాండము","chapters",34));
        OT.add(Map.of("name","Joshua","telugu","యెహొషువ","chapters",24));
        OT.add(Map.of("name","Judges","telugu","న్యాయాధిపతులు","chapters",21));
        OT.add(Map.of("name","Ruth","telugu","రూతు","chapters",4));
        OT.add(Map.of("name","1 Samuel","telugu","సమూయేలు మొదటి గ్రంథము","chapters",31));
        OT.add(Map.of("name","2 Samuel","telugu","సమూయేలు రెండవ గ్రంథము","chapters",24));
        OT.add(Map.of("name","1 Kings","telugu","రాజులు మొదటి గ్రంథము","chapters",22));
        OT.add(Map.of("name","2 Kings","telugu","రాజులు రెండవ గ్రంథము","chapters",25));
        OT.add(Map.of("name","1 Chronicles","telugu","దినవృత్తాంతములు మొదటి గ్రంథము","chapters",29));
        OT.add(Map.of("name","2 Chronicles","telugu","దినవృత్తాంతములు రెండవ గ్రంథము","chapters",36));
        OT.add(Map.of("name","Ezra","telugu","ఎజ్రా","chapters",10));
        OT.add(Map.of("name","Nehemiah","telugu","నెహెమ్యా","chapters",13));
        OT.add(Map.of("name","Esther","telugu","ఎస్తేరు","chapters",10));
        OT.add(Map.of("name","Job","telugu","యోబు గ్రంథము","chapters",42));
        OT.add(Map.of("name","Psalms","telugu","కీర్తనల గ్రంథము","chapters",150));
        OT.add(Map.of("name","Proverbs","telugu","సామెతలు","chapters",31));
        OT.add(Map.of("name","Ecclesiastes","telugu","ప్రసంగి","chapters",12));
        OT.add(Map.of("name","Song of Solomon","telugu","పరమగీతము","chapters",8));
        OT.add(Map.of("name","Isaiah","telugu","యెషయా గ్రంథము","chapters",66));
        OT.add(Map.of("name","Jeremiah","telugu","యిర్మీయా","chapters",52));
        OT.add(Map.of("name","Lamentations","telugu","విలాపవాక్యములు","chapters",5));
        OT.add(Map.of("name","Ezekiel","telugu","యెహెజ్కేలు","chapters",48));
        OT.add(Map.of("name","Daniel","telugu","దానియేలు","chapters",12));
        OT.add(Map.of("name","Hosea","telugu","హొషేయ","chapters",14));
        OT.add(Map.of("name","Joel","telugu","యోవేలు","chapters",3));
        OT.add(Map.of("name","Amos","telugu","ఆమోసు","chapters",9));
        OT.add(Map.of("name","Obadiah","telugu","ఓబద్యా","chapters",1));
        OT.add(Map.of("name","Jonah","telugu","యోనా","chapters",4));
        OT.add(Map.of("name","Micah","telugu","మీకా","chapters",7));
        OT.add(Map.of("name","Nahum","telugu","నహూము","chapters",3));
        OT.add(Map.of("name","Habakkuk","telugu","హబక్కూకు","chapters",3));
        OT.add(Map.of("name","Zephaniah","telugu","జెఫన్యా","chapters",3));
        OT.add(Map.of("name","Haggai","telugu","హగ్గయి","chapters",2));
        OT.add(Map.of("name","Zechariah","telugu","జెకర్యా","chapters",14));
        OT.add(Map.of("name","Malachi","telugu","మలాకీ","chapters",4));

        // --- New Testament ---
        NT.add(Map.of("name","Matthew","telugu","మత్తయి సువార్త","chapters",28));
        NT.add(Map.of("name","Mark","telugu","మార్కు సువార్త","chapters",16));
        NT.add(Map.of("name","Luke","telugu","లూకా సువార్త","chapters",24));
        NT.add(Map.of("name","John","telugu","యోహాను సువార్త","chapters",21));
        NT.add(Map.of("name","Acts","telugu","అపొస్తలుల కార్యములు","chapters",28));
        NT.add(Map.of("name","Romans","telugu","రోమీయులకు","chapters",16));
        NT.add(Map.of("name","1 Corinthians","telugu","1 కొరింథీయులకు","chapters",16));
        NT.add(Map.of("name","2 Corinthians","telugu","2 కొరింథీయులకు","chapters",13));
        NT.add(Map.of("name","Galatians","telugu","గలతీయులకు","chapters",6));
        NT.add(Map.of("name","Ephesians","telugu","ఎఫెసీయులకు","chapters",6));
        NT.add(Map.of("name","Philippians","telugu","ఫిలిప్పీయులకు","chapters",4));
        NT.add(Map.of("name","Colossians","telugu","కొలొస్సయులకు","chapters",4));
        NT.add(Map.of("name","1 Thessalonians","telugu","1 థెస్సలొనీకయులకు","chapters",5));
        NT.add(Map.of("name","2 Thessalonians","telugu","2 థెస్సలొనీకయులకు","chapters",3));
        NT.add(Map.of("name","1 Timothy","telugu","1 తిమోతికి","chapters",6));
        NT.add(Map.of("name","2 Timothy","telugu","2 తిమోతికి","chapters",4));
        NT.add(Map.of("name","Titus","telugu","తీతుకు","chapters",3));
        NT.add(Map.of("name","Philemon","telugu","ఫిలేమోనుకు","chapters",1));
        NT.add(Map.of("name","Hebrews","telugu","హెబ్రీయులకు","chapters",13));
        NT.add(Map.of("name","James","telugu","యాకోబు","chapters",5));
        NT.add(Map.of("name","1 Peter","telugu","1 పేతురు","chapters",5));
        NT.add(Map.of("name","2 Peter","telugu","2 పేతురు","chapters",3));
        NT.add(Map.of("name","1 John","telugu","1 యోహాను","chapters",5));
        NT.add(Map.of("name","2 John","telugu","2 యోహాను","chapters",1));
        NT.add(Map.of("name","3 John","telugu","3 యోహాను","chapters",1));
        NT.add(Map.of("name","Jude","telugu","యూదా","chapters",1));
        NT.add(Map.of("name","Revelation","telugu","ప్రకటన గ్రంథము","chapters",22));

        req.setAttribute("OT", OT);
        req.setAttribute("NT", NT);
        req.getRequestDispatcher("/teluguBible.jsp").forward(req, resp);
    }
}
