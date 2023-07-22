package com.company;

public class ConcreteBibItemFactory implements BibItemFactory {

    private GUIItemInputStrategy inputStrategies;

    public ConcreteBibItemFactory(GUIItemInputStrategy inputStrategies){
        this.inputStrategies = new GUIItemInputStrategy(new BookGUIInputStrategy(), new ArticleGUIInputStrategy(), new TechReportGUIInputStrategy());
    }

    public GUIItemInputStrategy getInputStrategies() {
        return inputStrategies;
    }

    public void setInputStrategies(GUIItemInputStrategy inputStrategies) {
        this.inputStrategies = inputStrategies;
    }

    @Override
    public BibItem createBibItem(String type) {
        BibItem bibItem = null;
        switch (type) {
            case "Academic Book":
                bibItem = createBibItemUsingStrategy(inputStrategies.getBookGUIInputStrategy());
                return bibItem;
            case "Academic Article":
                bibItem = createBibItemUsingStrategy(getInputStrategies().getArticleGUIInputStrategy());
                return bibItem;
            case "Technical Report":
                bibItem = createBibItemUsingStrategy(getInputStrategies().getTechReportGUIInputStrategy());
                return bibItem;
            default:
                return null;
        }
    }

    private BibItem createBibItemUsingStrategy(ItemInputStrategy itemInputStrategy){
        return itemInputStrategy.createBibItemFromInput();
    }
}
