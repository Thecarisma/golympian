package gig.library.golympian.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import gig.library.golympian.utilities.Font;
import gig.library.golympian.utilities.Language;
import gig.library.golympian.utilities.Theme;
import gig.library.golympian.views.LightView;

/**
 * Created by thecarisma on 12/23/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public SharedPreferences settings ;
    public Font font ; public static BaseActivity baseActivity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = PreferenceManager.getDefaultSharedPreferences(this); initActivity() ;
        baseActivity = this ;
    }

    public void initActivity() {
        Theme.setTheme(this, Theme.Themes.COOLBLUE); font = new Font(this);
        Language.setLanguage(this, Language.Languages.ENGLISH);
        font.overrideFont(this, "SERIF", font.getSavedFont());
    }

    public void setTitle(String title) {
        if ( getSupportActionBar() != null) getSupportActionBar().setTitle(title);
    }

    //we are not using a custom shared preference becuse we want other activity that extends this class
    //to have access to the shared preference
    //settings = this.getSharedPreferences(aresconstants.SHAREDPREFERENCENAME, MODE_PRIVATE);
}
