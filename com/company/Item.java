package com.company;

import java.util.HashMap;

public class Item {

    private static Item me;

    private HashMap<String, BibItem> bibItemHashMap;

    protected Item(){
        this.bibItemHashMap = new HashMap<String, BibItem>();
    }

    public static Item getInstance(){
        if (me == null) me = new Item();
        return me;
    }

    public HashMap<String, BibItem> getBibItemHashMap() {
        return bibItemHashMap;
    }
}
