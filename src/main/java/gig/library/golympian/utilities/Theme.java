package gig.library.golympian.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.ColorInt;
import android.widget.TextView;

import gig.library.golympian.R;
import gig.library.golympian.base.BaseActivity;

import static gig.library.golympian.base.Constants.aresconstants;

/**
 * Created by thecarisma on 12/23/2017.
 */

public class Theme {

    private Activity activity ; private SharedPreferences settings ;

    /**
     * the currently supported themes
     */
    public enum Themes {
        HERATHEME, REDFIRE, NATURE, GREENLIFE, SKYBLUE, COOLBLUE, AQUAMARINE, BUTTER, DARK,
        NIGHTWALKER
    }

    /**
     * theme constructor with activity
     * @param activity the initializer activity
     */
    public Theme(Activity activity) {
        this.activity = activity ;
        settings = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    /**
     * set the theme you desire after constructing with the activity initializer
     * else error will occur
     * @throws null activity error
     * @param theme the theme you wish to apply
     */
    public void setTheme(Themes theme) {
        activity.setTheme(getThemeId(theme));
    }

    /**
     * set the theme you desire after constructing with the activity initializer during runtime anytime
     * else error will occur
     * @throws null activity error
     * @param theme the theme you wish to apply
     */
    public void applyTheme(Themes theme) {
        activity.setTheme(getThemeId(theme)); activity.recreate();
    }

    /**
     * set the theme you desire passing the activity and the themes
     * @throws null activity error
     * @param theme the theme you wish to apply
     */
    public static void setTheme(Activity activity, Themes theme) {
        activity.setTheme(getThemeId(theme));
    }

    /**
     * set the theme you desire passing the activity and the themes during runtime anytime
     * @throws null activity error
     * @param theme the theme you wish to apply
     */
    public static void applyTheme(Activity activity, Themes theme) {
        activity.setTheme(getThemeId(theme)); activity.recreate();
    }

    /**
     * returns developers the theme saved in the activity preference
     * @return saved theme
     */
    public Themes getSavedTheme() {
        return getThemeId(settings.getInt(aresconstants.THEME, R.style.HeraTheme));
    }

    /**
     * get the themes value of the style id
     * @param id the style id you wish to get
     * @return the themes value of the theme
     */
    public static Themes getThemeId(int id) {
        if (id == R.style.HeraTheme) {
            return Themes.HERATHEME ;
        } else if (id == R.style.RedFire ) {
            return Themes.REDFIRE ;
        } else if (id == R.style.Nature ) {
            return Themes.NATURE ;
        } else if (id == R.style.GreenLife ) {
            return Themes.GREENLIFE ;
        } else if (id == R.style.SkyBlue ) {
            return Themes.SKYBLUE ;
        } else if (id == R.style.CoolBlue ) {
            return Themes.COOLBLUE ;
        } else if (id == R.style.AquaMarine ) {
            return Themes.AQUAMARINE ;
        } else if (id == R.style.Butter ) {
            return Themes.BUTTER ;
        } else if (id == R.style.Dark ) {
            return Themes.DARK ;
        } else if (id == R.style.NightWalker ) {
            return Themes.NIGHTWALKER ;
        }
        return Themes.HERATHEME ;
    }

    /**
     * get the style id of the theme you wish to apply
     * @param theme the theme you wish to apply
     * @return the style id of the theme
     */
    public static int getThemeId(Themes theme) {
        if (theme == Themes.HERATHEME) {
            return R.style.HeraTheme ;
        } else if (theme == Themes.REDFIRE) {
            return R.style.RedFire ;
        } else if (theme == Themes.NATURE) {
            return R.style.Nature ;
        } else if (theme == Themes.GREENLIFE) {
            return R.style.GreenLife ;
        } else if (theme == Themes.SKYBLUE) {
            return R.style.SkyBlue ;
        } else if (theme == Themes.COOLBLUE) {
            return R.style.CoolBlue ;
        } else if (theme == Themes.AQUAMARINE) {
            return R.style.AquaMarine ;
        } else if (theme == Themes.BUTTER) {
            return R.style.Butter ;
        } else if (theme == Themes.DARK) {
            return R.style.Dark ;
        } else if (theme == Themes.NIGHTWALKER) {
            return R.style.NightWalker ;
        }
        return R.style.HeraTheme ;
    }

    public static void setIndicator(SharedPreferences settings, TextView indicator) {
        indicator.setText(getTheme(getThemeId(settings.getInt("THEME",R.style.HeraTheme))));
    }

    /**
     * get the string value of the theme you wish to apply
     * @param theme the theme you wish to get the value
     * @return the string value of the theme
     */
    public static String getTheme(Themes theme) {
        if (theme == Themes.HERATHEME) {
            return "HeraTheme" ;
        } else if (theme == Themes.REDFIRE) {
            return "RedFire" ;
        } else if (theme == Themes.NATURE) {
            return "Nature";
        } else if (theme == Themes.GREENLIFE) {
            return "GreenLife" ;
        } else if (theme == Themes.SKYBLUE) {
            return "SkyBlue" ;
        } else if (theme == Themes.COOLBLUE) {
            return "CoolBlue" ;
        } else if (theme == Themes.AQUAMARINE) {
            return "AquaMarine" ;
        } else if (theme == Themes.BUTTER) {
            return "Butter" ;
        } else if (theme == Themes.DARK) {
            return "Dark" ;
        } else if (theme == Themes.NIGHTWALKER) {
            return "Night Walker" ;
        }
        return "HeraTheme" ;
    }

    public static int getColorPrimaryDark(Themes theme) {
        if (theme == Themes.HERATHEME) {
            return R.color.colorGolympianPrimaryDark ;
        } else if (theme == Themes.REDFIRE) {
            return R.color.colorGolympianRed ;
        } else if (theme == Themes.NATURE) {
            return R.color.colorGolympianGreen ;
        } else if (theme == Themes.GREENLIFE) {
            return R.color.colorGolympianGreenDark ;
        } else if (theme == Themes.SKYBLUE) {
            return R.color.colorGolympianBlueLight ;
        } else if (theme == Themes.COOLBLUE) {
            return R.color.colorGolympianBlueDark ;
        } else if (theme == Themes.AQUAMARINE) {
            return R.color.colorGolympianAquaBlue ;
        } else if (theme == Themes.BUTTER) {
            return R.color.colorGolympianYellowDark ;
        } else if (theme == Themes.DARK) {
            return R.color.colorGolympianGreyDark ;
        } else if (theme == Themes.NIGHTWALKER) {
            return R.color.colorGolympianWhite ;
        }
        return R.color.colorGolympianPrimaryDark ;
    }

    @ColorInt
    public static int getColorPrimaryDark(Context context, Themes theme) {
        if (theme == Themes.HERATHEME) {
            return context.getResources().getColor(R.color.colorGolympianPrimaryDark) ;
        } else if (theme == Themes.REDFIRE) {
            return context.getResources().getColor(R.color.colorGolympianRed) ;
        } else if (theme == Themes.NATURE) {
            return context.getResources().getColor(R.color.colorGolympianGreen) ;
        } else if (theme == Themes.GREENLIFE) {
            return context.getResources().getColor(R.color.colorGolympianGreenDark) ;
        } else if (theme == Themes.SKYBLUE) {
            return context.getResources().getColor(R.color.colorGolympianBlueLight) ;
        } else if (theme == Themes.COOLBLUE) {
            return context.getResources().getColor(R.color.colorGolympianBlueDark) ;
        } else if (theme == Themes.AQUAMARINE) {
            return context.getResources().getColor(R.color.colorGolympianAquaBlue) ;
        } else if (theme == Themes.BUTTER) {
            return context.getResources().getColor(R.color.colorGolympianYellowDark) ;
        } else if (theme == Themes.DARK) {
            return context.getResources().getColor(R.color.colorGolympianGreyDark) ;
        } else if (theme == Themes.NIGHTWALKER) {
            return context.getResources().getColor(R.color.colorGolympianWhite) ;
        }
        return context.getResources().getColor(R.color.colorGolympianPrimaryDark) ;
    }

    @ColorInt
    public static int getColorPrimaryDark(BaseActivity context) {
        if (context.theme == Themes.HERATHEME) {
            return context.getResources().getColor(R.color.colorGolympianPrimaryDark) ;
        } else if (context.theme == Themes.REDFIRE) {
            return context.getResources().getColor(R.color.colorGolympianRed) ;
        } else if (context.theme == Themes.NATURE) {
            return context.getResources().getColor(R.color.colorGolympianGreen) ;
        } else if (context.theme == Themes.GREENLIFE) {
            return context.getResources().getColor(R.color.colorGolympianGreenDark) ;
        } else if (context.theme == Themes.SKYBLUE) {
            return context.getResources().getColor(R.color.colorGolympianBlueLight) ;
        } else if (context.theme == Themes.COOLBLUE) {
            return context.getResources().getColor(R.color.colorGolympianBlueDark) ;
        } else if (context.theme == Themes.AQUAMARINE) {
            return context.getResources().getColor(R.color.colorGolympianAquaBlue) ;
        } else if (context.theme == Themes.BUTTER) {
            return context.getResources().getColor(R.color.colorGolympianYellowDark) ;
        } else if (context.theme == Themes.DARK) {
            return context.getResources().getColor(R.color.colorGolympianGreyDark) ;
        } else if (context.theme == Themes.NIGHTWALKER) {
            return context.getResources().getColor(R.color.colorGolympianWhite) ;
        }
        return context.getResources().getColor(R.color.colorGolympianPrimaryDark) ;
    }

}
