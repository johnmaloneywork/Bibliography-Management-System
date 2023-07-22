package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main extends JFrame implements ActionListener {

    private static JFrame menuFrame;

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu Demo");
        setBounds(100, 100, 450, 300);
        setUpGUI(this.getContentPane());
    }

    private void setUpGUI(Container pane) {
        setLayout(new GridLayout(6, 0));
        initComponents(pane);
    }

    private void initComponents(Container pane) {
        JButton button1 = new JButton("Load a BibTex file to the bibliography");
        pane.add(button1);
        button1.setActionCommand("Load");
        button1.addActionListener(this);
        JButton button2 = new JButton("Save your bibliography to a file");
        pane.add(button2);
        button2.setActionCommand("Save");
        button2.addActionListener(this);
        JButton button3 = new JButton("Add an entry to the bibliography");
        pane.add(button3);
        button3.setActionCommand("Add");
        button3.addActionListener(this);
        JButton button4 = new JButton("Delete an entry from the bibliography");
        pane.add(button4);
        button4.setActionCommand("Delete");
        button4.addActionListener(this);
        JButton button5 = new JButton("View the bibliography entries");
        pane.add(button5);
        button5.setActionCommand("View");
        button5.addActionListener(this);
        JButton button6 = new JButton("Quit");
        pane.add(button6);
        button6.setActionCommand("Quit");
        button6.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Quit")) {
            System.out.println("\nQuitting...");
            System.exit(0);
        }
        if (command.equals("Load")) {
            loadFromFile();
        }
        if(command.equals("View")){
            viewBibliography(Item.getInstance().getBibItemHashMap());
        }
        if(command.equals("Save")){
            writeToFile(Item.getInstance().getBibItemHashMap());
        }
        if(command.equals("Add")){
            addBib();
        }
        if(command.equals("Delete")){
            deleteEntry(Item.getInstance().getBibItemHashMap());
        }
    }

    public static void main(String[] args) {

        Author techAuthor = new Author("J", "Q");
        Author bookAuthor = new Author("P", "X");
        Author artAuthor = new Author("N", "C");

        TechnicalReport techRep = new TechnicalReport("Tech Report", 2000, "NUIG", techAuthor, 21022000);
        AcademicBook acaBook = new AcademicBook("Academic Report", 1999, "Penguin", bookAuthor);
        AcademicArticle acaArt = new AcademicArticle("Academic Article", 2010, "Publishing Co.", artAuthor,
                "Article Ting", "The Journal", "23-3434-DFHH");

        Item.getInstance().getBibItemHashMap().put(acaArt.getCiteKey(), acaArt);
        Item.getInstance().getBibItemHashMap().put(techRep.getCiteKey(), techRep);
        Item.getInstance().getBibItemHashMap().put(acaBook.getCiteKey(), acaBook);

        new Main().setVisible(true);

    }

    public static void loadFromFile(){
        System.out.println("Loading from file");
    }

    public static void deleteEntry(HashMap<String, BibItem> bibItemHashMap){
        JTextField textField = new JTextField();
        Object[] fields = {"Cite Key: ", textField};
        JOptionPane.showConfirmDialog(null,fields,"Deleting Entry",JOptionPane.OK_CANCEL_OPTION);

        String citeKey = textField.getText();

        bibItemHashMap.entrySet().removeIf(entry -> Objects.equals(citeKey, entry.getKey()));
    }

    public static void addBib(){
        Object[] possibilities = {"Academic Book", "Academic Article", "Technical Report"};
        String s = (String) JOptionPane.showInputDialog(menuFrame, "Choose a type: ", "Bib Type",
                JOptionPane.PLAIN_MESSAGE, null, possibilities, "Academic Book");


        String citeKey = "";

        GUIItemInputStrategy guiItemInputStrategy = new GUIItemInputStrategy(new BookGUIInputStrategy(), new ArticleGUIInputStrategy(), new TechReportGUIInputStrategy());

        ConcreteBibItemFactory concreteBibItemFactory = new ConcreteBibItemFactory(guiItemInputStrategy);

        if(s.equals("Academic Book")){
            AcademicBook book = (AcademicBook) concreteBibItemFactory.createBibItem(s);
            citeKey = (book.getCiteKey());
            Item.getInstance().getBibItemHashMap().put(citeKey, book);
        }
        if(s.equals("Academic Article")){
            AcademicArticle article = (AcademicArticle) concreteBibItemFactory.createBibItem(s);
            citeKey = (article.getCiteKey());
            Item.getInstance().getBibItemHashMap().put(citeKey, article);
        }
        if(s.equals("Technical Report")){
            TechnicalReport technicalReport = (TechnicalReport) concreteBibItemFactory.createBibItem(s);
            citeKey = (technicalReport.getCiteKey());
            Item.getInstance().getBibItemHashMap().put(citeKey, technicalReport);
        }
    }

    public static void viewBibliography(HashMap<String, BibItem> bibItemHashMap){

        for (BibItem item : Item.getInstance().getBibItemHashMap().values()) {
            System.out.println(item.harvard());
        }

    }

    public static void writeToFile(HashMap<String, BibItem> bibItemHashMap){
        JTextField textField = new JTextField();
        Object[] fields = {"File Name: ", textField};
        JOptionPane.showConfirmDialog(null,fields,"Saving To File",JOptionPane.OK_CANCEL_OPTION);

        String fileName = textField.getText();

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Iterator<BibItem> i = Item.getInstance().getBibItemHashMap().values().iterator(); i.hasNext();){
                bufferedWriter.write(i.next().bibTex());
                System.out.println("\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

