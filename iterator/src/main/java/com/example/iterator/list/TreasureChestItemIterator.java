package com.example.iterator.list;

import com.example.iterator.Iterator;

/**
 * TreasureChestItemIterator.
 */
public class TreasureChestItemIterator implements Iterator<Item> {

    private TreasureChest chest;
    private int idx;
    private ItemType type;

    /**
     * Constructor.
     */
    public TreasureChestItemIterator(TreasureChest chest, ItemType type) {
        this.chest = chest;
        this.type = type;
        this.idx = -1;
    }

    @Override
    public boolean hasNext() {
        return findNextIdx() != -1;
    }

    @Override
    public Item next() {
        idx = findNextIdx();
        if (idx != -1) {
            return chest.getItems().get(idx);
        }
        return null;
    }

    private int findNextIdx() {
        var items = chest.getItems();
        var tempIdx = idx;
        while (true) {
            tempIdx++;
            if (tempIdx >= items.size()) {
                tempIdx = -1;
                break;
            }
            if (type.equals(ItemType.ANY) || items.get(tempIdx).getType().equals(type)) {
                break;
            }
        }
        return tempIdx;
    }
}
