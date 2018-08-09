package thecarisma.golympian.resources;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 *
 *  Created by Azeez Adewale on 11/25/2017.
 *  Copyright Great Innovation Group
 *  Licenced under tri Licence
 *      MIT LICENCE
 *      GNU LICENCE
 *      CDDL LICENCE
 *  on this day 11/25/2017 : 11:09 PM
 *
 *  Class : LocaleResources
 *  Filename : LocaleResources.java
 *  Project : Coin World
 *  Package : com.gig.olympus.resources
 *  Computer Name : Thecarisma
 *
 */

/**
 * the locale resources to fine tune your app
 * 20 for now
 *
 * @author Azeez Adewale
 */
public class LocaleResources {

    /**
     *
     * the image url to fetch the country icon for the corresponding index (country)
     * andcoincap github repository
     * advice : do not change the image url
     *
     * @TODO to change the repository to gig dedicate server in future
     *
     */
    public static String imageurl = "http://raw.githubusercontent.com/Thecarisma/andcoincap/master/coinworld/denomlogo/" ;

    /**
     *
     * this method accept currency as parameter to fetch image ;)
     * ensure you take note of how the images are fetched from our github repository
     * eg we are replacing "countryname" in the image url @imageLocation with the
     * country name/code name. you do not need to worry about data usage the network
     * loading occurs once and Glide is awesome with cache so it automatically load
     * the cached image nexttime this method is called :wink:
     *
     * @param currency the currency you wish to get the locale flag
     * @param context the context that Glide requires as base
     * @param imageView the imageview to load the image into
     */
    public static void loadLocaleFlag(Currency currency, Context context, ImageView imageView) {

        if (currency == Currency.USD ) {
            /**
             * USA
             */
            String nimageurl = imageurl+"usa.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.NGN) {
            /**
             * NGN
             */
            String nimageurl = imageurl+"nigeria.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.EUR) {
            /**
             * EURO
             */
            String nimageurl = imageurl+"euro.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.GBP) {
            /**
             * BRITAIN
             */
            String nimageurl = imageurl+"britain.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.ZAR) {
            /**
             * SOUTH AFRICA
             */
            String nimageurl = imageurl+"south_africa.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.INR) {
            /**
             * INDIA
             */
            String nimageurl = imageurl+"india.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.CAD) {
            /**
             * CANADA
             */
            String nimageurl = imageurl+"canada.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.LYD) {
            /**
             * LIBYA
             */
            String nimageurl = imageurl+"libya.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.BND) {
            /**
             * BRUNEI
             */
            String nimageurl = imageurl+"brunei.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.SGD) {
            /**
             * SINGAPORE
             */
            String nimageurl = imageurl+"singapore.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.BRL) {
            /**
             * BRAZIL
             */
            String nimageurl = imageurl+"brazil.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.ILS) {
            /**
             * ISREAL
             */
            String nimageurl = imageurl+"isreal.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.RUB) {
            /**
             * RUSSIA
             */
            String nimageurl = imageurl+"russia.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.GHS) {
            /**
             * GHANA
             */
            String nimageurl = imageurl+"ghana.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.TRY) {
            /**
             * TURKEY
             */
            String nimageurl = imageurl+"turkey.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.NZD) {
            /**
             * NEW ZEALAND
             */
            String nimageurl = imageurl+"new_zealand.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.CHF) {
            /**
             * SWITZERLAND
             */
            String nimageurl = imageurl+"switzerland.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.KYD) {
            /**
             * CAYMAN
             */
            String nimageurl = imageurl+"cayman.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.LVL) {
            /**
             * LATVIA
             */
            String nimageurl = imageurl+"latvia.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        } else if (currency == Currency.JOD) {
            /**
             * JORDAN
             */
            String nimageurl = imageurl+"jordan.png" ;
            Glide.with(context).load(nimageurl).into(imageView);
        }
    }

    /**
     *
     * yea right here we fetch the corresponding locale currency name by index
     * for using in your project you can revise the documentation to be familiar
     * with the corresponding country at a given index
     *
     * @param currency the currency you wish to get the locale currency
     * @return the locale country at given index
     */
    public static String getLocaleCurrency(Currency currency) {

        String scurrency = "US Dollar" ;

        if (currency == Currency.USD) {
            scurrency = "US Dollar" ;
        } else if (currency == Currency.NGN) {
            scurrency = "Nigeria Naira" ;
        } else if (currency == Currency.EUR) {
            scurrency = "Euro" ;
        } else if (currency == Currency.GBP) {
            scurrency = "British Pound" ;
        } else if (currency == Currency.ZAR) {
            scurrency = "South Africa Rand" ;
        } else if (currency == Currency.INR) {
            scurrency = "Indian Rupee" ;
        } else if (currency == Currency.CAD) {
            scurrency = "Canadian Dollar" ;
        } else if (currency == Currency.LYD) {
            scurrency = "Libyan Dollar" ;
        } else if (currency == Currency.BND) {
            scurrency = "Brunei Dollar" ;
        } else if (currency == Currency.SGD) {
            scurrency = "Singapore Dollar" ;
        } else if (currency == Currency.BRL) {
            scurrency = "Brazillian Real" ;
        } else if (currency == Currency.ILS) {
            scurrency = "Isreal New Shekel" ;
        } else if (currency == Currency.RUB) {
            scurrency = "Russia Rubble" ;
        } else if (currency == Currency.GHS) {
            scurrency = "Ghananian Cedi" ;
        } else if (currency == Currency.TRY) {
            scurrency = "Turkish Lira" ;
        } else if (currency == Currency.NZD) {
            scurrency = "New Zealand Dollar" ;
        } else if (currency == Currency.CHF) {
            scurrency = "Switzerland Franc" ;
        } else if (currency == Currency.KYD) {
            scurrency = "Cayman Island Dolar" ;
        } else if (currency == Currency.LVL) {
            scurrency = "Latvian Lat" ;
        } else if (currency == Currency.JOD) {
            scurrency = "Jordanian Dinar" ;
        }

        return scurrency ;
    }

    /**
     *
     *  this method returns the corresponding given currency sign/symbol
     *
     * @param currency the currency you wish to get the symbol
     * @return the corresponding sign/symbol of the given currency
     */
    public static String getCurrencySign(Currency currency) {
        String sign = "$" ;

        if (currency == Currency.USD) { sign = "$" ; }
        else if (currency == Currency.NGN) { sign = "₦" ; }
        else if (currency == Currency.EUR) { sign = "€" ; }
        else if (currency == Currency.GBP) { sign = "£" ; }
        else if (currency == Currency.ZAR) { sign = "R" ; }
        else if (currency == Currency.INR) { sign = "₹" ; }
        else if (currency == Currency.CAD) { sign = "C$" ; }
        else if (currency == Currency.LYD) { sign = "ل.د" ; }
        else if (currency == Currency.BND) { sign = "B$" ; }
        else if (currency == Currency.SGD) { sign = "S$" ; }
        else if (currency == Currency.BRL) { sign = "R$" ; }
        else if (currency == Currency.ILS) { sign = "₪" ; }
        else if (currency == Currency.RUB) { sign = "\u20BD " ; }
        else if (currency == Currency.GHS) { sign = "¢" ; }
        else if (currency == Currency.TRY) { sign = "₺" ; }
        else if (currency == Currency.NZD) { sign = "NZ$" ; }
        else if (currency == Currency.CHF) { sign = "SFr" ; }
        else if (currency == Currency.KYD) { sign = "$" ; }
        else if (currency == Currency.LVL) { sign = "Ls" ; }
        else if (currency == Currency.JOD) { sign = "دينار"; }

        return sign ;
    }

    /**
     *
     *  this method returns the corresponding given currency sign/symbol
     *
     * @param curr the currency you wish to get the symbol
     * @return the corresponding sign/symbol of the given currency
     */
    public static String getCurrencySign(String curr) {
        Currency currency = getCurrency(curr);

        return getCurrencySign(currency) ;
    }

    /**
     *
     *  you provide the position/index and the corresponding currency position is returned
     *  note only integer value is passes and also the position you passes must not exceed
     *  the number of currency supported else an exception is thrown or error is logged
     *  @see Currency
     *  if exception is not thrown then error is logged in console ie Android monitor
     *  and the default index Currency.USD is returned
     *
     * @param position the position/index you wish to get the corresponding currency value
     * @return the currency value of given position
     */
    public static Currency getCurrency(int position) {
        if (position == 0 ) {
            return Currency.USD ;
        } else if (position == 1) {
            return Currency.NGN ; // NGN
        } else if (position == 2) {
            return Currency.EUR ; // EUR
        } else if (position == 3) {
            return Currency.GBP ; // GBP
        } else if (position == 4) {
            return Currency.ZAR ; // ZAR
        } else if (position == 5) {
            return Currency.INR ; // INR
        } else if (position == 6) {
            return Currency.CAD ; // CAD
        } else if (position == 7) {
            return Currency.LYD ; // LYD
        } else if (position == 8) {
            return Currency .BND; // BND
        } else if (position == 9) {
            return Currency.SGD ; // SGD
        } else if (position == 10) {
            return Currency.BRL ; // BRL
        } else if (position == 11) {
            return Currency.ILS ; // ILS
        } else if (position == 12) {
            return Currency.RUB ; // RUB
        } else if (position == 13) {
            return Currency.GHS ; // GHS
        } else if (position == 14) {
            return Currency.TRY ; // TRY
        } else if (position == 15) {
            return Currency.NZD ; // NZD
        } else if (position == 16) {
            return Currency.CHF ; // CHF
        } else if (position == 17) {
            return Currency.KYD ; // KYD
        } else if (position == 18) {
            return Currency.LVL ; // LVL
        } else if (position == 19) {
            return Currency.JOD ; // JOD
        } else {
            Log.e("GIG:OLYMPUS:LR", "Index out of Bound : Only 20 Countries is currently suported 0 - 19 : index "+position+" is INVALID");
            return Currency.USD ;
        }
    }

    /**
     *
     *  you provide the value/shortcode and the corresponding currency position is returned
     *  note only string value is passes and also the value you passes must be among the
     *  current currency supported else an exception is thrown or error is logged
     *  @see Currency
     *  if exception is not thrown then error is logged in console ie Android monitor
     *  and the default index Currency.USD is returned
     *
     * @param value the position/index you wish to get the corresponding currency value
     * @return the currency value of given position
     */
    public static Currency getCurrency(String value) {
        if (value.toUpperCase().equals("USD")) {
            return Currency.USD ; // USD
        } else if (value.toUpperCase().equals("NGN")) {
            return Currency.NGN ; // NGN
        } else if (value.toUpperCase().equals("NGN")) {
            return Currency.EUR ; // EUR
        } else if (value.toUpperCase().equals("GBP")) {
            return Currency.GBP ; // GBP
        } else if (value.toUpperCase().equals("ZAR")) {
            return Currency.ZAR ; // ZAR
        } else if (value.toUpperCase().equals("INR")) {
            return Currency.INR ; // INR
        } else if (value.toUpperCase().equals("CAD")) {
            return Currency.CAD ; // CAD
        } else if (value.toUpperCase().equals("LYD")) {
            return Currency.LYD ; // LYD
        } else if (value.toUpperCase().equals("BND")) {
            return Currency .BND; // BND
        } else if (value.toUpperCase().equals("SGD")) {
            return Currency.SGD ; // SGD
        } else if (value.toUpperCase().equals("BRL")) {
            return Currency.BRL ; // BRL
        } else if (value.toUpperCase().equals("ILS")) {
            return Currency.ILS ; // ILS
        } else if (value.toUpperCase().equals("RUB")) {
            return Currency.RUB ; // RUB
        } else if (value.toUpperCase().equals("GHS")) {
            return Currency.GHS ; // GHS
        } else if (value.toUpperCase().equals("TRY")) {
            return Currency.TRY ; // TRY
        } else if (value.toUpperCase().equals("NZD")) {
            return Currency.NZD ; // NZD
        } else if (value.toUpperCase().equals("CHF")) {
            return Currency.CHF ; // CHF
        } else if (value.toUpperCase().equals("KYD")) {
            return Currency.KYD ; // KYD
        } else if (value.toUpperCase().equals("LVL")) {
            return Currency.LVL ; // LVL
        } else if (value.toUpperCase().equals("JOD")) {
            return Currency.JOD ; // JOD
        } else {
            Log.e("GIG:GOLYMPUS:LR", "Unsorported short code : Only 20 Countries is currently suported : value "+value+" is INVALID");
            return Currency.USD ;
        }
    }

    public static String getSelectedCurrency(int curr) {
        String currency = "USD" ;

        if (curr == 0) { currency = "USD" ; }
        else if (curr == 1) { currency = "NGN" ; }
        else if (curr == 2) { currency = "EUR" ; }
        else if (curr == 3) { currency = "GBP" ; }
        else if (curr == 4) { currency = "ZAR" ; }
        else if (curr == 5) { currency = "INR" ; }
        else if (curr == 6) { currency = "CAD" ; }
        else if (curr == 7) { currency = "LYD" ; }
        else if (curr == 8) { currency = "BND" ; }
        else if (curr == 9) { currency = "SGD" ; }
        else if (curr == 10) { currency = "BRL" ; }
        else if (curr == 11) { currency = "ILS" ; }
        else if (curr == 12) { currency = "RUB" ; }
        else if (curr == 13) { currency = "GHS" ; }
        else if (curr == 14) { currency = "TRY" ; }
        else if (curr == 15) { currency = "NZD" ; }
        else if (curr == 16) { currency = "CHF" ; }
        else if (curr == 17) { currency = "KYD" ; }
        else if (curr == 18) { currency = "LVL" ; }
        else if (curr == 19) { currency = "JOD" ; }

        return currency ;
    }

}
