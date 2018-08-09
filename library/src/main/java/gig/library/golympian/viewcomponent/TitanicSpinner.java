package gig.library.golympian.viewcomponent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.support.v7.widget.AppCompatSpinner;

import gig.library.golympian.R;
import gig.library.golympian.views.SoulWindow;

import static gig.library.golympian.base.Constants.aresconstants;

/**
 * Created by thecarisma on 12/26/2017.
 */

public class TitanicSpinner extends android.support.v7.widget.AppCompatSpinner
{
    public TitanicSpinner(Context context)
    {
        super(context);
    }

    public TitanicSpinner(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public TitanicSpinner(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public TitanicSpinner(Context context, AttributeSet attrs, int defStyle, int mode)
    {
        super(context, attrs, defStyle, mode);
    }

    public TitanicSpinner(Context context, int mode)
    {
        super(context, mode);
    }

    /**@Override
    public boolean performClick()
    {
        boolean bClicked = super.performClick();
        try
        {
            Field mPopupField = AppCompatSpinner.class.getDeclaredField("mPopup");
            mPopupField.setAccessible(true);
            ListPopupWindow pop = (ListPopupWindow) mPopupField.get(this);
            ListView listview = pop.getListView();

            Field mScrollCacheField = View.class.getDeclaredField("mScrollCache");
            mScrollCacheField.setAccessible(true);
            Object mScrollCache = mScrollCacheField.get(listview);
            Field scrollBarField = mScrollCache.getClass().getDeclaredField("scrollBar");
            scrollBarField.setAccessible(true);
            Object scrollBar = scrollBarField.get(mScrollCache);
            Method method = scrollBar.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
            method.setAccessible(true);
            method.invoke(scrollBar, getResources().getDrawable(R.drawable.scroller_style));

            Field mVerticalScrollbarPositionField = View.class.getDeclaredField("mVerticalScrollbarPosition");
            mVerticalScrollbarPositionField.setAccessible(true);
            mVerticalScrollbarPositionField.set(listview, SCROLLBAR_POSITION_LEFT);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return bClicked;
    }**/

    @Override
    public void getWindowVisibleDisplayFrame(Rect outRect) {
        WindowManager wm = (WindowManager) this.getContext().getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        d.getRectSize(outRect); try {
            outRect.set(outRect.left, 195, outRect.right, outRect.bottom+25);
        } catch (Exception ex) {
            aresconstants.debugError(ex.getMessage());
            outRect.set(outRect.left, 195, outRect.right, outRect.bottom);
        }
    }


}
