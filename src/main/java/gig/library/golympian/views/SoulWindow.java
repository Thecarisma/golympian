package gig.library.golympian.views;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by thecarisma on 12/22/2017.
 */

public class SoulWindow {

    Activity activity ;

    public SoulWindow(Activity activity) {
        this.activity = activity ;
    }

    /**
     * if you want a completely dependable transparent staus/notification bar on any device
     * with compatibility
     */
    public void makeStatusbarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = activity.getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}
