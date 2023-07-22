package com.company;

import javax.swing.*;

public class ArticleGUIInputStrategy implements ItemInputStrategy{

    @Override
    public BibItem createBibItemFromInput() {

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        JTextField field6 = new JTextField();
        JTextField field7 = new JTextField();
        JTextField field8 = new JTextField();

        Object [] fields = {
                "Article Title: ", field1,
                "Article Year: ", field2,
                "Article Publisher: ", field3,
                "Author First Name: ", field4,
                "Author Last Name: ", field5,
                "Article Name: ", field6,
                "Journal Name: ", field7,
                "DOI Ending: ", field8
        };

        JOptionPane.showConfirmDialog(null,fields,"Book Creation",JOptionPane.OK_CANCEL_OPTION);

        String articleTitle = field1.getText();
        String yearText = field2.getText();
        int articleYear = Integer.parseInt(yearText);
        String articlePublisher = field3.getText();
        String articleAuthorFirstName = field4.getText();
        String articleAuthorLastName = field5.getText();
        String articleName = field6.getText();
        String journalName = field7.getText();
        String doiEnding = field8.getText();
        return new AcademicArticle(articleTitle, articleYear, articlePublisher, new Author(articleAuthorFirstName, articleAuthorLastName), articleName, journalName, doiEnding);
    }
}