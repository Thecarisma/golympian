package thecarisma.golympian.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import gig.library.golympian.R;

import static thecarisma.golympian.base.Constants.aresconstants;

/**
 * Created by thecarisma on 12/22/2017.
 */

public class SoulWindow {

    Activity activity ; private Rect rectangle = new Rect(); private Window window ;

    public SoulWindow(Activity activity) {
        this.activity = activity ; window = activity.getWindow();
    }

    /**
     * if you want a completely dependable transparent staus/notification bar on any device
     * with compatibility
     */
    @TargetApi(21)
    public void makeStatusbarTransparent() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            Window w = activity.getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.setNavigationBarColor(activity.getResources().getColor(R.color.colorGolympianBlack));
        }
    }

    public void noTitle() {
        try {
            activity.setTitle("");
        } catch (Exception ex) {
            try {
                ((AppCompatActivity) activity).getSupportActionBar().setTitle("");
            } catch (Exception e) {
                aresconstants.treatException(aresconstants.VIEWETAG, e);
            }

        }
    }

    public int getStatusBarHeight() {
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        int statusBarHeight = rectangle.top;
        int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
        return (contentViewTop - statusBarHeight);
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rectangle = new Rect();Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        int statusBarHeight = rectangle.top;
        int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
        if ((contentViewTop - statusBarHeight) <= 0) {
            return 35 ;
        }
        return (contentViewTop - statusBarHeight);
    }

    public static void getDistanceFromTop(View view) {
        View tableView = view.getRootView();
        int offsetY = tableView.getTop();

        // horizontal line start pos (x1, x2), end pos (x3, x4)
        // t1 position is relative to t1's parent(== custom_board_table) position
        int x2 = view.getTop() + view.getHeight() + 2 + offsetY;
        aresconstants.debugError("X2 : "+x2+", INFO : "+tableView.getContentDescription());
    }
}
