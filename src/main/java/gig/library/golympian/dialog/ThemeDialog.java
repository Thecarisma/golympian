package gig.library.golympian.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.gig.networkcompanion.R;
import com.gig.networkcompanion.utilities.Theme;

import gig.library.golympian.R;

import static com.gig.networkcompanion.base.ConstantBases.basecontext;

/**
 * Created by Thecarisma on 17-Sep-17.
 */
public class ThemeDialog extends Dialog {

    TextView themeIndicator ;

    public ThemeDialog(Context c, TextView themein) {
        super(c); themeIndicator = themein ;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getWindow()!=null) getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.theme_dialog); onClick();
    }

    public void onClick() {
        findViewById(R.id.theme_green_culture_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(R.style.GreenTheme);
            }
        });
        findViewById(R.id.theme_hot_red_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(R.style.RedTheme);
            }
        });
        findViewById(R.id.theme_black_danger_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(R.style.RedBlackTheme);
            }
        });
        findViewById(R.id.theme_light_blue_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(R.style.LightBlueTheme);
            }
        });
        findViewById(R.id.theme_blue_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(R.style.BlueTheme);
            }
        });
        findViewById(R.id.theme_yellow_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(R.style.SunsetTheme);
            }
        });
    }

    private void setTheme(int themeval) {
        PreferenceManager.getDefaultSharedPreferences(basecontext.getApplicationContext()).edit().putInt("THEME", themeval).apply();
        android.content.res.Configuration config = basecontext.getBaseContext().getResources().getConfiguration();
        basecontext.getBaseContext().getResources().updateConfiguration(config, basecontext.getBaseContext().getResources().getDisplayMetrics());
        themeIndicator.setText(Theme.getTheme()); dismiss(); basecontext.recreate();
    }


}
