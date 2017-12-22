package gig.library.golympian.views;

/**
 * Created by thecarisma on 12/22/2017.
 */

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.TextAppearanceSpan;
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

    /**
     * use this method to set the textColor of any MenuItemwith default grey
     * color
     * @param menuItem
     */
    public static void setMenuItemColor(Context context, MenuItem menuItem) {
        SpannableString s = new SpannableString(menuItem.getTitle());
        s.setSpan(new TextAppearanceSpan(context, R.style.TextColorGrey), 0, s.length(), 0);
        menuItem.setTitle(s);
    }

    /**
     * use this method to set the textColor of any MenuItem with custom color
     * @param menuItem
     */
    public static void setMenuItemColor(Context context, MenuItem menuItem, MenuItemColor color) {
        SpannableString s = new SpannableString(menuItem.getTitle());
        s.setSpan(new TextAppearanceSpan(context, getMenuItemColor(color)), 0, s.length(), 0);
        //s.setSpan(new RelativeSizeSpan(1.5f), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        menuItem.setTitle(s);
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
