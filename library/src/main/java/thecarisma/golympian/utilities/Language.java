package thecarisma.golympian.utilities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;

import java.util.Locale;

import static thecarisma.golympian.base.Constants.aresconstants;

/**
 * Created by thecarisma on 12/23/2017.
 */

public class Language {

    private Activity activity ; private SharedPreferences settings ;
    private Configuration config ;

    /**
     * the currently supported languages
     */
    public enum Languages {
        ENGLISH, YORUBA
    }

    /**
     * language constructor with activity
     * @param activity the initializer activity
     */
    public Language(Activity activity) {
        this.activity = activity ;
        settings = PreferenceManager.getDefaultSharedPreferences(activity);
        config = activity.getBaseContext().getResources().getConfiguration();
    }

    /**
     * set the device language to defined language
     * @param language the type of language to set
     */
    public void setLanguage(Languages language) {
        String lang = getLanguage(language);
        Locale.setDefault(new Locale(lang));
        config.locale = new Locale(lang);
        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());
    }

    /**
     * set the device language to defined language
     * @param activity the activity that hold everything
     * @param language the type of language to set
     */
    public static void setLanguage(Activity activity, Languages language) {
        Configuration config = activity.getBaseContext().getResources().getConfiguration();
        String lang = getLanguage(language);
        Locale.setDefault(new Locale(lang));
        config.locale = new Locale(lang);
        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());
    }

    /**
     * set the device language to defined language
     * @param activity the activity that hold everything
     * @param language the type of language to set
     */
    public static void setLanguage(Activity activity, String language) {
        Configuration config = activity.getBaseContext().getResources().getConfiguration();
        String lang = language;
        Locale.setDefault(new Locale(lang));
        config.locale = new Locale(lang);
        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());
    }

    /**
     * set the application language according to the saved value in the shared preference
     * @param settings the shared preference to load language from
     */
    public void setLanguage(SharedPreferences settings) {
        config = activity.getBaseContext().getResources().getConfiguration();
        String lang = settings.getString(aresconstants.LANGUAGE, "en");
        Locale.setDefault(new Locale(lang));
        config.locale = new Locale(lang);
        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());
    }

    /**
     * returns developers the language saved in the activity preference
     * @return saved language
     */
    public Languages getSavedLanguage() {
        return getLanguageCode(settings.getString(aresconstants.LANGUAGE, "en"));
    }

    /**
     * fetch the languages language with the user provided languages language
     * @param language the user defined language
     * @return the short code of language
     */
    public static String getLanguage(Languages language) {
        if (language == Languages.ENGLISH) {
            return "en" ;
        } else if (language == Languages.YORUBA) {
            return "yo" ;
        }
        return "en" ;
    }

    /**
     * fetch the languages lang withe the user provided language code
     * @param lang the short code of language to get the Languages enum value
     * @return the requested language
     */
    public static Languages getLanguageCode(String lang) {
        if (lang.equals(getLanguage(Languages.ENGLISH))) {
            return Languages.ENGLISH ;
        } else if (lang.equals(getLanguage(Languages.YORUBA))) {
            return Languages.YORUBA ;
        }
        return Languages.ENGLISH ;
    }

}
