package com.company;

public class GUIItemInputStrategy implements ItemInputStrategy {

    private BookGUIInputStrategy bookGUIInputStrategy;
    private ArticleGUIInputStrategy articleGUIInputStrategy;
    private TechReportGUIInputStrategy techReportGUIInputStrategy;

    public GUIItemInputStrategy(BookGUIInputStrategy bookGUIInputStrategy, ArticleGUIInputStrategy articleGUIInputStrategy, TechReportGUIInputStrategy techReportGUIInputStrategy){
        this.bookGUIInputStrategy = bookGUIInputStrategy;
        this.articleGUIInputStrategy = articleGUIInputStrategy;
        this.techReportGUIInputStrategy = techReportGUIInputStrategy;
    }

    public ArticleGUIInputStrategy getArticleGUIInputStrategy() {
        return articleGUIInputStrategy;
    }

    public void setArticleGUIInputStrategy(ArticleGUIInputStrategy articleGUIInputStrategy) {
        this.articleGUIInputStrategy = articleGUIInputStrategy;
    }

    public BookGUIInputStrategy getBookGUIInputStrategy() {
        return bookGUIInputStrategy;
    }

    public void setBookGUIInputStrategy(BookGUIInputStrategy bookGUIInputStrategy) {
        this.bookGUIInputStrategy = bookGUIInputStrategy;
    }

    public TechReportGUIInputStrategy getTechReportGUIInputStrategy() {
        return techReportGUIInputStrategy;
    }

    public void setTechReportGUIInputStrategy(TechReportGUIInputStrategy techReportGUIInputStrategy) {
        this.techReportGUIInputStrategy = techReportGUIInputStrategy;
    }

    @Override
    public BibItem createBibItemFromInput() {
        return null;
    }
}