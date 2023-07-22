package com.company;

public class AcademicBook extends BibItem{

    private String title;
    private int year;
    private String publisher;
    private Author author;
    private String citeKey;

    public AcademicBook(String title, int year, String publisher, Author author){
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.author = author;
        this.citeKey = author.getLastName() + year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCiteKey() {
        return citeKey;
    }

    public void setCiteKey(String citeKey) {
        this.citeKey = citeKey;
    }

    @Override
    String harvard() {
        return (author.getLastName() + ", " + author.getFirstName() + ". (" + year + "). " + title + ". " + publisher);
    }

    @Override
    String bibTex() {
        return ("@" + getClass() + "{" + citeKey + ",\n" +
                "author     = " + author.getLastName() + ", " + author.getFirstName() + ",\n" +
                "title      = " + title + "\n" +
                "year       = " + year + ",\n" +
                "publisher  = " + publisher + "\n" +
                "}");
    }
}
