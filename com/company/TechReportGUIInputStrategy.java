package com.company;

import javax.swing.*;

public class TechReportGUIInputStrategy implements ItemInputStrategy{

    @Override
    public BibItem createBibItemFromInput() {

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        JTextField field6 = new JTextField();

        Object [] fields = {
                "Report Title: ", field1,
                "Report Year: ", field2,
                "Report Institution: ", field3,
                "Author First Name: ", field4,
                "Author Last Name: ", field5,
                "Date Published: ", field6,
        };

        JOptionPane.showConfirmDialog(null,fields,"Book Creation",JOptionPane.OK_CANCEL_OPTION);

        String reportTitle = field1.getText();
        String yearText = field2.getText();
        int reportYear = Integer.parseInt(yearText);
        String reportInstitution = field3.getText();
        String reportAuthorFirstName = field4.getText();
        String reportAuthorSecondName = field5.getText();
        String dateText = field6.getText();
        long date = Integer.parseInt(dateText);
        return new TechnicalReport(reportTitle, reportYear, reportInstitution, new Author(reportAuthorFirstName, reportAuthorSecondName), date);
    }
}
