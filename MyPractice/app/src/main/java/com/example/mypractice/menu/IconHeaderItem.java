package com.example.mypractice.menu;

import androidx.leanback.widget.HeaderItem;

public class IconHeaderItem extends HeaderItem {

    private static final String TAG = "IconHeaderItem";
    public static final int ICON_NONE = -1;
    private int icon = ICON_NONE;

    public IconHeaderItem(long id, String name) {
        this(id, name, ICON_NONE);
    }

    public IconHeaderItem(String name) {
        super(name);
    }

    public IconHeaderItem(long id, String name, int icon) {
        super(id, name);
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
