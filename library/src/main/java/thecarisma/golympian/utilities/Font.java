package thecarisma.golympian.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;

import java.lang.reflect.Field;

import thecarisma.golympian.base.BaseActivity;

import static thecarisma.golympian.base.Constants.aresconstants;

/**
 * Created by Thecarisma on 09-Nov-17.
 */

public class Font {

    Activity activity ; SharedPreferences settings ;

    public enum Fonts {
        OSWARD, SERIF, PACIFICO
    }

    /**
     * font constructor with activity
     * @param activity the initializer activity
     */
    public Font(Activity activity) {
        this.activity = activity ;
        settings = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    /**
     * font constructor with shared preference
     * @param settings the shared preference that hold settings
     */
    public Font(SharedPreferences settings) {
        this.settings = settings ;
    }

    /**
     * initialize the activity to avoid exceptions and errors
     * @param activity the initializer activity
     */
    public void setActivity(Activity activity) {
        this.activity = activity ;
    }

    /**
     * initialize the shared preference settings to avoid exceptions and errors
     * @param settings the shared preference that hold settings
     */
    public void setSharedPreference(SharedPreferences settings) {
        this.settings = settings ;
    }

    /**
     * Using reflection to override default typeface
     *
     * NOTICE: DO NOT FORGET TO SET TYPEFACE FOR APP THEME AS DEFAULT TYPEFACE WHICH WILL BE OVERRIDDEN
     * @param context to work with assets
     * @param defaultFontNameToOverride for example "monospace"
     * @param customFontFileNameInAssets file name of the font from assets
     */
    public void overrideFont(Context context, String defaultFontNameToOverride, String customFontFileNameInAssets) {
        try {
            final Typeface customFontTypeface = Typeface.createFromAsset(context.getAssets(), customFontFileNameInAssets);

            final Field defaultFontTypefaceField = Typeface.class.getDeclaredField(defaultFontNameToOverride);
            defaultFontTypefaceField.setAccessible(true);
            defaultFontTypefaceField.set(null, customFontTypeface);
        } catch (Exception e) {
            aresconstants.treatException(aresconstants.UTILITYETAG, e);
        }
    }


    /**
     * returns the asset path of saved font
     * @param settings the shared preference that saved the font
     * @return the saved font asset path
     */
    public String getSavedFont(SharedPreferences settings) {
        return "fonts/"+settings.getString("FONT", "oswald.ttf");
    }

    /**
     * returns the asset path of saved font
     * @param baseActivity the base activity that parent the shared preference
     * @return the save font assets path
     */
    public String getSavedFont(BaseActivity baseActivity) {
        return "fonts/"+ baseActivity.settings.getString("FONT", "oswald.ttf");
    }

    /**
     * returns the asset path of saved font from initialize settings or activity
     * @return the saved font assets path
     */
    public String getSavedFont() {
        try {
            return "fonts/"+ settings.getString("FONT", "oswald.ttf");
        } catch (Exception ex) {
            ((BaseActivity) activity).settings.getString("FONT", "oswald.ttf");
            aresconstants.treatException(aresconstants.UTILITYETAG, ex);
            return "fonts/oswald.ttf" ;
        }
    }

    public static void setDefaultFont(Context context,
                                      String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);
    }

    protected static void replaceFont(String staticTypefaceFieldName,
                                      final Typeface newTypeface) {
        try {
            final Field staticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}