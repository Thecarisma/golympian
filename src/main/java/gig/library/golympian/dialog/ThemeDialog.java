package gig.library.golympian.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import gig.library.golympian.R;
import gig.library.golympian.utilities.Theme;

/**
 * Created by Thecarisma on 17-Sep-17.
 */
public class ThemeDialog extends Dialog {

    TextView themeIndicator ; Activity context ;

    public ThemeDialog(Context c, TextView themein) {
        super(c); context = (Activity) c ; themeIndicator = themein ;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getWindow()!=null) getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.theme_dialog); onClick();
    }

    public void onClick() {
        findViewById(R.id.theme_red_fire).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(Theme.Themes.REDFIRE);
            }
        });
        findViewById(R.id.theme_nature).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(Theme.Themes.NATURE);
            }
        });
        findViewById(R.id.theme_green_life).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(Theme.Themes.GREENLIFE);
            }
        });
        findViewById(R.id.theme_sky_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(Theme.Themes.SKYBLUE);
            }
        });
        findViewById(R.id.theme_cool_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(Theme.Themes.COOLBLUE);
            }
        });
        findViewById(R.id.theme_aqua_marine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(Theme.Themes.AQUAMARINE);
            }
        });
        findViewById(R.id.theme_butter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(Theme.Themes.BUTTER);
            }
        });
        findViewById(R.id.theme_dark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(Theme.Themes.DARK);
            }
        });
        findViewById(R.id.theme_night_walker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(Theme.Themes.NIGHTWALKER);
            }
        });
    }

    private void setTheme(Theme.Themes themeval) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("THEME", Theme.getThemeId(themeval)).apply();
        android.content.res.Configuration config = context.getBaseContext().getResources().getConfiguration();
        context.getResources().updateConfiguration(config, context.getBaseContext().getResources().getDisplayMetrics());
        themeIndicator.setText(Theme.getTheme(themeval)); dismiss(); context.recreate();
    }


}
