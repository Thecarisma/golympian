package gig.library.golympian.views;

/**
 * Created by thecarisma on 12/22/2017.
 */

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;

import gig.library.golympian.R;

/**
 * the class @see MenuTune is use in fine tunning menu item such as background, foregroud and lot more
 * including a lot useful stuff for the menu items
 */
public class MenuTune {

    public enum MenuItemColor {
        GREEN, BLUE, RED, YELLOW, WHITE, BLACK
    }

    public enum MenuItemTextSize {
        INVISIBLE, SMALLEST, SMALLER, SMALL,
        BIG, BIGGER, BIGGEST,
        LARGE, LARGER, LARGEST
    }

    /**
     * use this method to set the textColor of any MenuItemwith default grey
     * color
     * @param menuItem
     * @param context
     */
    public static void setMenuItemColor(Context context, MenuItem menuItem) {
        SpannableString s = new SpannableString(menuItem.getTitle());
        s.setSpan(new TextAppearanceSpan(context, R.style.TextColorGrey), 0, s.length(), 0);
        menuItem.setTitle(s);
    }

    /**
     * use this method to set the textColor of all MenuItem in an MenuInflator with default grey
     * color
     * @param menu
     * @param context
     */
    public static void setMenuItemsColor(Context context, Menu menu) {
        for(int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            setMenuItemColor(context, item);
        }
    }

    /**
     * use this method to set the textColor of any MenuItemwith default grey
     * color and custom text size
     * @param menuItem
     * @param context
     * @param size
     */
    public static void setMenuItemColor(Context context, MenuItem menuItem, MenuItemTextSize size) {
        SpannableString s = new SpannableString(menuItem.getTitle());
        s.setSpan(new TextAppearanceSpan(context, R.style.TextColorGrey), 0, s.length(), 0);
        s.setSpan(new RelativeSizeSpan(size.ordinal()), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        menuItem.setTitle(s);
    }

    /**
     * use this method to set the textColor of all MenuItems in a menu default grey
     * color and custom text size
     * @param menu
     * @param context
     * @param size
     */
    public static void setMenuItemsColor(Context context, Menu menu, MenuItemTextSize size) {
        for(int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            setMenuItemColor(context, item, size);
        }
    }

    /**
     * use this method to set the textColor of any MenuItem with custom color
     * @param menuItem
     * @param color
     * @param context
     */
    public static void setMenuItemColor(Context context, MenuItem menuItem, MenuItemColor color) {
        SpannableString s = new SpannableString(menuItem.getTitle());
        s.setSpan(new TextAppearanceSpan(context, getMenuItemColor(color)), 0, s.length(), 0);
        menuItem.setTitle(s);
    }

    /**
     * use this method to set the textColor of all MenuItem in a menu with custom color
     * @param menu
     * @param color
     * @param context
     */
    public static void setMenuItemsColor(Context context, Menu menu, MenuItemColor color) {
        for(int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            setMenuItemColor(context, item, color);
        }
    }

    /**
     * use this method to set the textColor of any MenuItem with custom color and custom text size
     * @param menuItem
     * @param context
     * @param color
     * @param size
     */
    public static void setMenuItemColor(Context context, MenuItem menuItem, MenuItemColor color, MenuItemTextSize size) {
        SpannableString s = new SpannableString(menuItem.getTitle());
        s.setSpan(new TextAppearanceSpan(context, getMenuItemColor(color)), 0, s.length(), 0);
        s.setSpan(new RelativeSizeSpan(size.ordinal()), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        menuItem.setTitle(s);
    }

    /**
     * use this method to set the textColor of all MenuItem in a menu with custom color and custom text size
     * @param menu
     * @param color
     * @param size
     * @param context
     */
    public static void setMenuItemsColor(Context context, Menu menu, MenuItemColor color, MenuItemTextSize size) {
        for(int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            setMenuItemColor(context, item, color, size);
        }
    }

    public static int getMenuItemColor(MenuItemColor color) {
        if (color == MenuItemColor.GREEN) {
            return R.style.TextColorGreen ;
        } else if (color == MenuItemColor.RED) {
            return R.style.TextColorRed ;
        } else if (color == MenuItemColor.BLUE) {
            return R.style.TextColorBlue ;
        } else if (color == MenuItemColor.YELLOW) {
            return R.style.TextColorYellow ;
        } else if (color == MenuItemColor.WHITE) {
            return R.style.TextColorWhite ;
        } else if (color == MenuItemColor.BLACK) {
            return R.style.TextColorBlack ;
        } else {
            return R.style.TextColorGrey ;
        }
    }

    /**
     * MenuInflater awesome = getMenuInflater();
     awesome.inflate(R.menu.menu_main, menu);
     for(int i = 0; i < menu.size(); i++) {
     MenuItem item = menu.getItem(i);
     SpannableString spanString = new SpannableString(menu.getItem(i).getTitle().toString());
     int end = spanString.length();
     spanString.setSpan(new RelativeSizeSpan(1.5f), 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
     item.setTitle(spanString);
     }
     */

}
