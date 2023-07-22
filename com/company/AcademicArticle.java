package com.company;

public class AcademicArticle extends BibItem{

    private int year;
    private String publisher;
    private Author author;
    private String articleName;
    private String title;
    private String journal;
    private String citeKey;
    private String doi;
    private String doiEnding;

    public AcademicArticle(String title, int year, String publisher, Author author, String articleName, String journal, String doiEnding){
        this.year = year;
        this.publisher = publisher;
        this.author = author;
        this.articleName = articleName;
        this.title = title;
        this.journal = journal;
        this.citeKey = author.getLastName() + (year % 10) + publisher;
        this.doi = "https://doi.org/" + (int)(Math.random()*9) + "" + (int)(Math.random()*9) +
                "." + (int)(Math.random()*9) + "" + (int)(Math.random()*9) + "" + (int)(Math.random()*9) + "" + (int)(Math.random()*9) + "/";
        this.doiEnding = doiEnding;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJournalTitle(String journalTitle) {
        this.title = journalTitle;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getCiteKey() {
        return citeKey;
    }

    public void setCiteKey(String citeKey) {
        this.citeKey = author.getLastName();
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getDoiEnding() {
        return doiEnding;
    }

    public void setDoiEnding(String doiEnding) {
        this.doiEnding = doiEnding;
    }

    @Override
    String harvard() {
        return (author.getLastName() + ", " + author.getFirstName() + ". (" + year + "). " + title + ". " + publisher + ". " + doi + doiEnding);
    }

    @Override
    String bibTex() {
        return ("@" + getClass() + "{" + citeKey + ",\n" +
                "author     = " + author.getLastName() + ", " + author.getFirstName() + ",\n" +
                "title      = " + title + "\n" +
                "year       = " + year + ",\n" +
                "journal  = " + publisher + "\n" +
                "doi = " + doi + doiEnding + "\n" +
                "}");
    }
}