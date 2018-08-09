package gig.library.golympian.userdevice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static gig.library.golympian.base.Constants.aresconstants;

/**
 * Created by thecarisma on 12/24/2017.
 */

public class App {

    Activity activity ; private SharedPreferences settings ;

    /**
     * app constructor with activity
     * @param activity the initializer activity
     */
    public App(Activity activity) {
        this.activity = activity ;
        settings = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    /**
     * this method check the app preference to determin if it is first time the app is run on the device
     * of if the preference has been created in first instance
     * @return if it first run
     */
    private boolean checkFirstRun() {
        return settings.getBoolean(aresconstants.ISFIRSTRUN, true);
    }

    /**
     * it is available to check if the app is run for the first time and if it run for the first time then it assignrd
     * a false condition to the aresconstants.ISFIRSTRUN preference condition to ensure that whenever the condition
     * is called again we don't end up with true always
     * @return actual if it first run
     */
    public boolean isFirstRun() {
        if (checkFirstRun()) {
            settings.edit().putBoolean(aresconstants.ISFIRSTRUN, false).apply();
            return !checkFirstRun() ;
        } else {
            return checkFirstRun() ;
        }
    }

}
