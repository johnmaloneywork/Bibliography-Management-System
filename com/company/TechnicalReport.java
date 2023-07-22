package com.company;

public class TechnicalReport extends BibItem{

    private String title;
    private int year;
    private String institution;
    private Author author;
    private long date;
    private String citeKey;

    public TechnicalReport(String title, int year, String institution, Author author, long date){
        this.title = title;
        this.year = year;
        this.institution = institution;
        this.author = author;
        this.date = date;
        this.citeKey = author.getLastName() + ":" + year + ":" + date;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getCiteKey() {
        return citeKey;
    }

    public void setCiteKey(String citeKey) {
        this.citeKey = citeKey;
    }

    @Override
    String harvard() {
        return (author.getLastName()) + ", " + author.getFirstName() + ". (" + year + "). " + title + ". " + institution;
    }

    @Override
    String bibTex() {
        return ("@" + getClass() + "{" + citeKey + ", \n author = " + author.getLastName() + ", " + author.getFirstName() + ", \n title = " +
                title + ", \n year = " + year + ", \n institution = " + institution + "\n }");
    }
}
