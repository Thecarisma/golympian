package gig.library.golympian.resources;

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
    public static String imageLocation = "pathtoimageabsolute" ;

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
            imageLocation = imageLocation.replace("countryname", "usa") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.NGN) {
            /**
             * NGN
             */
            imageLocation = imageLocation.replace("countryname", "ngn") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.EUR) {
            /**
             * EURO
             */
            imageLocation = imageLocation.replace("countryname", "euro") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.GBP) {
            /**
             * BRITAIN
             */
            imageLocation = imageLocation.replace("countryname", "britain") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.ZAR) {
            /**
             * SOUTH AFRICA
             */
            imageLocation = imageLocation.replace("countryname", "south_africa") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.INR) {
            /**
             * INDIA
             */
            imageLocation = imageLocation.replace("countryname", "india") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.CAD) {
            /**
             * CANADA
             */
            imageLocation = imageLocation.replace("countryname", "canada") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.LYD) {
            /**
             * LIBYA
             */
            imageLocation = imageLocation.replace("countryname", "libya") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.BND) {
            /**
             * BRUNEI
             */
            imageLocation = imageLocation.replace("countryname", "brunei") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.SGD) {
            /**
             * SINGAPORE
             */
            imageLocation = imageLocation.replace("countryname", "singapore") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.BRL) {
            /**
             * BRAZIL
             */
            imageLocation = imageLocation.replace("countryname", "brazil") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.ILS) {
            /**
             * ISREAL
             */
            imageLocation = imageLocation.replace("countryname", "isreal") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.RUB) {
            /**
             * RUSSIA
             */
            imageLocation = imageLocation.replace("countryname", "russia") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.GHS) {
            /**
             * GHANA
             */
            imageLocation = imageLocation.replace("countryname", "ghana") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.TRY) {
            /**
             * TURKEY
             */
            imageLocation = imageLocation.replace("countryname", "turkey") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.NZD) {
            /**
             * NEW ZEALAND
             */
            imageLocation = imageLocation.replace("countryname", "new_zealand") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.CHF) {
            /**
             * SWITZERLAND
             */
            imageLocation = imageLocation.replace("countryname", "switzerland") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.KYD) {
            /**
             * CAYMAN
             */
            imageLocation = imageLocation.replace("countryname", "cayman") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.LVL) {
            /**
             * LATVIA
             */
            imageLocation = imageLocation.replace("countryname", "latvia") ;
            Glide.with(context).load(imageLocation).into(imageView);
        } else if (currency == Currency.JOD) {
            /**
             * JORDAN
             */
            imageLocation = imageLocation.replace("countryname", "jordan") ;
            Glide.with(context).load(imageLocation).into(imageView);
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

}
