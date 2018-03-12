package gig.library.golympian.misc;

import android.app.Activity;
import android.content.SharedPreferences;

import java.math.BigDecimal;

import gig.library.golympian.resources.LocaleResources;

/**
 * Created by Thecarisma on 14-Nov-17.
 */

public class TreatData {

    Activity activity ;

    public TreatData(Activity activity) {
        this.activity = activity ;
    }

    public String getVolume(String volu, String currency, SharedPreferences settings) {
        String volume = "Vol.1DAY; 600M" ;
        float vol = Float.parseFloat(volu) ; vol = getVolumeValue(vol, currency, settings);
        if (vol < 100) {
            vol = round(vol, 2 ); volume = "Vol.1Day; "+ LocaleResources.getCurrencySign(currency)+vol+"T" ;
        } else if (vol < 100000) {
            vol = round(vol, 2 ); volume = "Vol.1Day; "+LocaleResources.getCurrencySign(currency)+vol+"H" ;
        } else if (vol < 1000000) {
            vol = round((vol / 1000), 2 ); volume = "Vol.1Day; "+LocaleResources.getCurrencySign(currency)+"TH" ;
        } else if (vol < 1000000000) {
            vol = round((vol / 1000000), 2 ); volume = "Vol.1Day; "+LocaleResources.getCurrencySign(currency)+vol+"M" ;
        } else if (vol < 1000000000000.0) {
            vol = round((vol / 1000000000), 2 ); volume = "Vol.1Day; "+LocaleResources.getCurrencySign(currency)+vol+"B" ;
        } else if (vol < 1000000000000000.0) {
            try {
                vol = round((vol / (1000000000 * 1000)), 2 ); volume = "Vol.1Day; "+LocaleResources.getCurrencySign(currency)+vol+"T" ;
            } catch (Exception ex) {
                volume = "Vol.1Day; "+LocaleResources.getCurrencySign(currency)+volu+"T";
            }
        } else {
            volume = "Vol.1Day; "+LocaleResources.getCurrencySign(currency)+volu+"Q";
        }

        return volume ;
    }

    public float getVolumeValue(float vol, String currency, SharedPreferences settings) {
        if (currency.equals("USD")) {

        } else if (currency.equals("NGN")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "355.000145"));
        } else if (currency.equals("EUR")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "0.843902"));
        } else if (currency.equals("GBP")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "0.75185"));
        } else if (currency.equals("ZAR")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "13.883801"));
        } else if (currency.equals("INR")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "64.622902"));
        } else if (currency.equals("CAD")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "1.27178"));
        } else if (currency.equals("LYD")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "1.366403"));
        } else if (currency.equals("BND")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "1.344797"));
        } else if (currency.equals("SGD")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "1.34543"));
        } else if (currency.equals("BRL")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "3.2216"));
        } else if (currency.equals("ILS")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "3.509099"));
        } else if (currency.equals("RUB")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "58.408983"));
        } else if (currency.equals("GHS")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "4.628501"));
        } else if (currency.equals("TRY")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "3.923503"));
        } else if (currency.equals("NZD")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "1.4503"));
        } else if (currency.equals("CHF")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "0.98128"));
        } else if (currency.equals("KYD")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "0.819951"));
        } else if (currency.equals("LVL")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "0.62055"));
        } else if (currency.equals("JOD")) {
            vol = vol * Float.parseFloat(settings.getString(currency.toUpperCase()+"RATE", "0.706501"));
        }
        return  vol ;
    }

    public String getAmountInUSD(String inprice, SharedPreferences settings, int currency) {
        float price = Float.parseFloat(inprice) ;

        if (LocaleResources.getSelectedCurrency(currency).equals("USD")) { } else {
            price = price * Float.parseFloat(settings.getString(
                    LocaleResources.getSelectedCurrency(currency).toUpperCase()+"RATE", "320.32"));
        }

        return LocaleResources.getCurrencySign(LocaleResources.getSelectedCurrency(currency))+" "+price ;
    }

    public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public String getCurrencysSign(String currency) {
        String sign = "$" ;

        if (currency.equals("USD")) { sign = "$" ; }
        else if (currency.equals("NGN")) { sign = "₦" ; }
        else if (currency.equals("EUR")) { sign = "€" ; }
        else if (currency.equals("GBP")) { sign = "£" ; }
        else if (currency.equals("ZAR")) { sign = "R" ; }
        else if (currency.equals("INR")) { sign = "₹" ; }
        else if (currency.equals("CAD")) { sign = "C$" ; }
        else if (currency.equals("LYD")) { sign = "ل.د" ; }
        else if (currency.equals("BND")) { sign = "B$" ; }
        else if (currency.equals("SGD")) { sign = "S$" ; }
        else if (currency.equals("BRL")) { sign = "R$" ; }
        else if (currency.equals("ILS")) { sign = "₪" ; }
        else if (currency.equals("RUB")) { sign = "\u20BD " ; }
        else if (currency.equals("GHS")) { sign = "¢" ; }
        else if (currency.equals("TRY")) { sign = "₺" ; }
        else if (currency.equals("NZD")) { sign = "NZ$" ; }
        else if (currency.equals("CHF")) { sign = "SFr" ; }
        else if (currency.equals("KYD")) { sign = "$" ; }
        else if (currency.equals("LVL")) { sign = "Ls" ; }
        else if (currency.equals("JOD")) { sign = "دينار"; }

        return sign ;
    }



}
