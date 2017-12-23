package gig.library.golympian.base;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by thecarisma on 12/22/2017.
 */

public class Constants {

    public static Constants aresconstants = new Constants();
    Context context ;

    /**
     * Boolean constants
     */
    public static boolean LOGERROR = true ;
    public static boolean TOASTERROR = true ;

    /**
     * String constants : tag
     */
    String DEFAULTTAG = "GIG.LIBRARY.GOLYMPIAN" ;
    public String USERDEVICETAG = "GOLYMPIAN.USERDEVICE" ;
    public String VIEWETAG = "GOLYMPIAN.VIEW" ;
    public String UTILITYETAG = "GOLYMPIAN.UTILITIES" ;

    /**
     * String constants : shared preference
     */
    public String LANGUAGEPREFERENCE = "LANGUAGEPREFERENCE" ;
    public String LANGUAGE = "LANGUAGE" ;
    public String FONT = "FONT" ;
    public String THEME = "THEME" ;

    /**
     * constant base initializer with context
     * @param context
     */
    public Constants(Context context) {
        this.context = context ;
    }

    /**
     * constant bases initializer with no context
     */
    public Constants() {

    }

    /**
     * this basically treat exception to either loging or throwing it depends on the
     * developer choice
     * @param ex the exception
     */
    public void treatException(Exception ex) {
        if (LOGERROR) {
            Log.e(DEFAULTTAG, ""+ex.getMessage());
        } else if (TOASTERROR) {
            toastError(ex);
        } else {
            ex.printStackTrace();
        }
    }

    /**
     * this basically treat exception to either loging or throwing it depends on the
     * developer choice and with a custom tag
     * @param tag custom tag
     * @param ex  the exception
     */
    public void treatException(String tag, Exception ex) {
        if (LOGERROR) {
            Log.e(tag, ex.getMessage());
        } else if (TOASTERROR) {
            toastError(ex, tag);
        } else {
            ex.printStackTrace();
        }
    }

    /**
     * this basically treat debug to either loging or throwing it depends on the
     * developer choice
     * @param message debugable string
     */
    public void treatDebug(String message) {
        Log.d(DEFAULTTAG, ""+message);
    }

    /**
     * this basically treat debug to either loging or throwing it depends on the
     * developer choice and with a custom tag
     * @param tag custom tag
     * @param message debugable string
     */
    public void treatException(String message, String tag) {
        Log.d(tag, ""+message);
    }

    /**
     * this basically display a message as an error in the log console
     * @param message string to display as error
     */
    public void debugError(String message) {
        Log.e(DEFAULTTAG, ""+message);
    }

    /**
     * this basically display a message as an error in the log console with custom tag
     * @param tag custom tag
     * @param message string to display as error
     */
    public void debugError(String tag, String message) {
        Log.e(tag, ""+message);
    }

    /**
     * show error as toast to user with default tag
     * @param ex
     */
    public void toastError(Exception ex) {
        if (context != null) {
            Toast.makeText(context, DEFAULTTAG+" "+ex.getMessage(), Toast.LENGTH_SHORT).show();
        } else {
            Log.e(DEFAULTTAG, ""+ex.getMessage());
        }
    }

    /**
     * show error as toast to user with custom tag
     * @param ex
     * @param tag
     */
    public void toastError(Exception ex, String tag) {
        if (context != null) {
            Toast.makeText(context, tag+" "+ex.getMessage(), Toast.LENGTH_SHORT).show();
        } else {
            Log.e(tag, ""+ex.getMessage());
        }
    }

}
