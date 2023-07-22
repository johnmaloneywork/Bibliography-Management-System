package com.company;

import javax.swing.*;

public class BookGUIInputStrategy implements ItemInputStrategy {

    @Override
    public BibItem createBibItemFromInput() {

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();

        Object [] fields = {
                "Book Title: ", field1,
                "Book Year: ", field2,
                "Book Publisher: ", field3,
                "Author First Name: ", field4,
                "Author Last Name: ", field5
        };

        JOptionPane.showConfirmDialog(null,fields,"Book Creation",JOptionPane.OK_CANCEL_OPTION);

        String bookTitle = field1.getText();
        String yearText = field2.getText();
        int year = Integer.parseInt(yearText);
        String publisherText = field3.getText();
        String bookAuthorFirstName = field4.getText();
        String bookAuthorLastName = field5.getText();
        return new AcademicBook(bookTitle, year, publisherText, new Author(bookAuthorFirstName, bookAuthorLastName));
    }
}