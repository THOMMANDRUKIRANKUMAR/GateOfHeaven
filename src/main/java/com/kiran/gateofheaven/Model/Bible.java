package com.kiran.gateofheaven.Model;

public class Bible {
    private int verseNumber;
    private String verse;
    private int chapter;
    private String bookName;
    private String bookNameEnglish;

    public int getVerseNumber() {
        return verseNumber;
    }

    public void setVerseNumber(int verseNumber) {
        this.verseNumber = verseNumber;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookNameEnglish() {
        return bookNameEnglish;
    }

    public void setBookNameEnglish(String bookNameEnglish) {
        this.bookNameEnglish = bookNameEnglish;
    }
}
