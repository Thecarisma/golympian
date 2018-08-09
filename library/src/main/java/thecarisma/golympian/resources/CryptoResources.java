package thecarisma.golympian.resources;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;

import thecarisma.golympian.misc.ZeusMath;

import static thecarisma.golympian.base.Constants.aresconstants;

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
 *  Class : CryptoResources
 *  Filename : CryptoResources.java
 *  Project : Olympus
 *  Package : com.gig.olympus.resources
 *  Computer Name : Thecarisma
 *
 */

public class CryptoResources {

    /**
     *
     * the image fore url that fetches the corresponding crypto currency icon from the
     * andcoincap github repository
     *
     * @TODO to change the repository to gig dedicate server in future
     *
     */
    public static String imageurl = "http://raw.githubusercontent.com/Thecarisma/andcoincap/master/coinworld/coinslogo/" ;

    /**
     *
     *  we are rounding all our float values to 2 decimal placess
     *
     */
    public static DecimalFormat decimalFormat = new DecimalFormat("####0.000000");

    /**
     *
     *  this is the number of crypto currency currently supported if it was to be used in
     *  indexing it ok but actual number is 11 but in JAVA NUMBER INDEXING FORMAT which start
     *  from 0 that makes us arives at 10
     *
     */
    public static int NUMBER_OF_CRYPTO_CURRENCIES = 10 ;

    /**
     *
     *  this method loads the corresponding icon into the image view using the Glide library
     *  you do not need to worry on data usage as glide fetch image by cache that means you just
     *  need to load the image just once over the network and glide fetch it by cache value next time
     *
     * @param crypto the crypto currency value : symbol is advisable
     * @param context  the context that Glide required when load image
     * @param imageView the image we want glide to load the icon into
     */
    public static void loadCryptoIcon(CryptoCurrency crypto, Context context, ImageView imageView) {

        if (crypto == CryptoCurrency.BTC ) {
            /**
             * BITCOIN
             */
            String nimageurl = imageurl+"btc.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.ETH) {
            /**
             * ETHEREUM
             */
            String nimageurl = imageurl+"eth.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.BCH) {
            /**
             * BITCOIN CASH
             */
            String nimageurl = imageurl+"bch.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.XRP) {
            /**
             * RIPPLE
             */
            String nimageurl = imageurl+"xrp.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.DASH) {
            /**
             * DASH
             */
            String nimageurl = imageurl+"dash.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.LTC) {
            /**
             * LITECOIN
             */
            String nimageurl = imageurl+"ltc.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.XMR) {
            /**
             * MONERO
             */
            String nimageurl = imageurl+"xmr.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.NEO) {
            /**
             * NEO
             */
            String nimageurl = imageurl+"neo.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.MIOTA) {
            /**
             * IOTA
             */
            String nimageurl = imageurl+"miota.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.XEM) {
            /**
             * NEM
             */
            String nimageurl = imageurl+"xem.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        } else if (crypto == CryptoCurrency.ETC) {
            /**
             * ETHEREUM CLASSIC
             */
            String nimageurl = imageurl+"etc.png" ;
            Glide.with(context).load(nimageurl).into(imageView);

        }
    }

    /**
     *
     *  send the value of the coin in dollar and get conversion in given currency
     *  this return any coin price value in the corresponding currency value, the price
     *  should be converted to string first the other treatment occurs here. it return the
     *  new value with the currency symbol to (eg. $ 5000) also only currency should be passed
     *  to avoid error. PLEASE BEFORE CALLING THIS METHOD YOU SHOULD CALL THE
     *  GetConversionRates  first to fetch the conversion rates for the supported currencies
     *  TO FETCH THE CONVERSION RATES use new GetConversionRates().execute(context);
     *  if the conversion rates has not been fetch it is been called to get rates
     *  it can also be used to convert any monetary value from dollar to any other base
     *  do not convert from other value from dollar only
     *
     * @param inprice the price in dollar and dollar only else wrong value will be served
     * @param currency the currency you wish to get the value in corresponding crypto coin
     * @param context the context sent to the GetConversionRates class
     * @return the converted price value in given currency
     */
    public static String getAbsolutePrice(String inprice, Currency currency, Context context) {
        float price = Float.parseFloat(inprice) ;
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);

        /**
         * don't ask why it is neccessary to get uptodate price conversion rates
          */
        if (settings.getString(currency+"RATE", "320.32").equals("320.32") ) {
            //new GetConversionRates(context).execute(); //not during the making of coinworld
        }

        if (currency == Currency.USD) {
            /** we leave it as it is since it dollar **/
        } else {
            price = price * Float.parseFloat(settings.getString(currency+"RATE", "6200.32"));
        } decimalFormat.format(price) ;

        return LocaleResources.getCurrencySign(currency)+" "+price ;
    }

    /**
     *
     *  send the value of the coin in dollar and get conversion in given currency
     *  this return any coin price value in the corresponding currency value, the price
     *  should be converted to string first the other treatment occurs here. it return the
     *  new value without the currency symbol to (eg. 5000) also only currency should be passed
     *  to avoid error. PLEASE BEFORE CALLING THIS METHOD YOU SHOULD CALL THE
     *  GetConversionRates  first to fetch the conversion rates for the supported currencies
     *  TO FETCH THE CONVERSION RATES use new GetConversionRates().execute(context);
     *  if the conversion rates has not been fetch it is been called to get rates
     *  it can also be used to convert any monetary value from dollar to any other base
     *  do not convert from other value from dollar only
     *
     * @param inprice the price in dollar and dollar only else wrong value will be served
     * @param currency the currency you wish to get the value in corresponding crypto coin
     * @param context the context sent to the GetConversionRates class
     * @return the converted price value in given currency in float
     */
    public static float getPrice(String inprice, Currency currency, Context context) {
        float price = Float.parseFloat(inprice) ;
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        /**
         * don't ask why it is neccessary to get uptodate price conversion rates
         */
        if (settings.getString(currency+"RATE", "320.32").equals("320.32") ) {
            //new GetConversionRates(context).execute(); //not during the making of coinworld
        }

        if (currency == Currency.USD) {
            /** we leave it as it is since it dollar **/
        } else {
            aresconstants.debugError("PRICE : "+price+", RATE : "+settings.getString(currency+"RATE", "320.32"));
            price = price * Float.parseFloat(settings.getString(currency+"RATE", "320.32"));
        }
        decimalFormat.format(price) ;

        return price ;
    }

    /**
     *
     *  you provide the position/index and the corresponding cryptocurrency position is returned
     *  note only the string value is passes and also the value you passes must be present in the
     *  list of supported cryptocurrencies else an exception is thrown or error is logged
     *  @see CryptoCurrency
     *  if exception is not thrown then error is logged in console ie Android monitor
     *  and the default index CryptoCurrency.BTC is returned
     *
     * @param crypto the crypto string value you wish to get the CryptoCurrency value
     * @return the cryptocurrency value of given position
     */
    public static CryptoCurrency getCryptoCurrency(String crypto) {
        if (crypto.toUpperCase().contains("BTC") || crypto.toUpperCase().contains("BITCOIN")) {
            return CryptoCurrency.BTC ;
        } else if (crypto.toUpperCase().contains("ETH") || crypto.toUpperCase().contains("ETHEREUM")) {
            return CryptoCurrency.ETH ;
        } else if (crypto.toUpperCase().contains("BCH") || crypto.toUpperCase().contains("BITCOIN CASH")) {
            return CryptoCurrency.BCH ;
        } else if (crypto.toUpperCase().contains("XRP") || crypto.toUpperCase().contains("RIPPLE")) {
            return CryptoCurrency.XRP ;
        } else if (crypto.toUpperCase().contains("DASH") || crypto.toUpperCase().contains("DASH")) {
            return CryptoCurrency.DASH ;
        } else if (crypto.toUpperCase().contains("LTC") || crypto.toUpperCase().contains("LITECOIN")) {
            return CryptoCurrency.LTC ;
        } else if (crypto.toUpperCase().contains("XMR") || crypto.toUpperCase().contains("MONERO")) {
            return CryptoCurrency.XMR ;
        } else if (crypto.toUpperCase().contains("NEO") || crypto.toUpperCase().contains("NEO")) {
            return CryptoCurrency.NEO ;
        } else if (crypto.toUpperCase().contains("MIOTA") || crypto.toUpperCase().contains("IOTA")) {
            return CryptoCurrency.MIOTA ;
        } else if (crypto.toUpperCase().contains("XEM") || crypto.toUpperCase().contains("NEM")) {
            return CryptoCurrency.XEM ;
        } else if (crypto.toUpperCase().contains("ETC") || crypto.toUpperCase().contains("ETHEREUM CLASSIC")) {
            return CryptoCurrency.ETC ;
        } else {
            Log.e("GIG:OLYMPUS:CR", "Unknown coin is passed, Check the documentation for supported coins. "+crypto+" is not supported yet.");
            return CryptoCurrency.BTC ;
        }
    }

    /**
     *
     *  you provide the position/index and the corresponding cryptocurrency position is returned
     *  note only the Integer value is passes and also the value you passes must be present in the
     *  list of supported cryptocurrencies else an exception is thrown or error is logged
     *  @see CryptoCurrency
     *  if exception is not thrown then error is logged in console ie Android monitor
     *  and the default index CryptoCurrency.BTC is returned
     *
     * @param position the crypto position/index you wish to get the CryptoCurrency value
     * @return the cryptocurrency value of given position
     */
    public static CryptoCurrency getCryptoCurrency(int position) {
        if (position == 0) {
            return CryptoCurrency.BTC ;
        } else if (position == 1) {
            return CryptoCurrency.ETH ;
        } else if (position == 2) {
            return CryptoCurrency.BCH ;
        } else if (position == 3) {
            return CryptoCurrency.XRP ;
        } else if (position == 4) {
            return CryptoCurrency.DASH ;
        } else if (position == 5) {
            return CryptoCurrency.LTC ;
        } else if (position == 6) {
            return CryptoCurrency.XMR ;
        } else if (position == 7) {
            return CryptoCurrency.NEO ;
        } else if (position == 8) {
            return CryptoCurrency.MIOTA ;
        } else if (position == 9) {
            return CryptoCurrency.XEM ;
        } else if (position == 10) {
            return CryptoCurrency.ETC ;
        } else {
            Log.e("GIG:OLYMPUS:CR", "Index out of Bound : Only 11 Crypto Currency is currently supported 0 - 10 : index "+position+" is INVALID");
            return CryptoCurrency.BTC ;
        }
    }

    /**
     *
     *  this returns you with the value of the currency rate in the provided crypto currency
     *  along with the currency symbol
     *
     * @param currency the currency you wish to get the value
     * @param cryptocurrency the cryptocurrency you want to convert currency value to
     * @param context the base context that contains your shared preference
     * @return the string value with symbol of the currency in the crypto currency conversion
     */
    public static String getAbsoluteRate(Currency currency, CryptoCurrency cryptocurrency, Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        float value = 0.0f ; //stll need like get conversion rate to get btc to other crypto
        String val = (Float.parseFloat(settings.getString("USD_"+cryptocurrency.name()+"_RATE", "446.1")))+"";
        value = getPrice(val, currency, context);

        value = ZeusMath.roundFloat(value, 6) ;

        return LocaleResources.getCurrencySign(currency) + " " + value ;
    }

    /**
     *
     *  this returns you with the value of the currency rate in the provided crypto currency
     *
     * @param currency the currency you wish to get the value
     * @param cryptocurrency the cryptocurrency you want to convert currency value to
     * @param context the base context that contains your shared preference
     * @return the float value with symbol of the currency in the crypto currency conversion
     */
    public static float getRate(Currency currency, CryptoCurrency cryptocurrency, Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        float value = 0.0f ; String val = (Float.parseFloat(settings.getString("USD_"+cryptocurrency.name()+"_RATE", "446.1")))+"";
        value = getPrice(val, currency, context);

        value = ZeusMath.roundFloat(value, 6) ;

        return value ;
    }

    public static CryptoCurrency getNextCryptoCurrency(CryptoCurrency cryptocurrency) {
        int nextCoin = cryptocurrency.ordinal() + 1 ; //Log.e("CRYPTORESOURCES", "CURRENT COIN "+cryptocurrency);
        if (nextCoin > NUMBER_OF_CRYPTO_CURRENCIES ) { nextCoin = 0 ; } /** ensuring we dont overflow number of crypto currency **/
        return getCryptoCurrency(nextCoin) ;
    }

    public static CryptoCurrency getPreviousCryptoCurrency(CryptoCurrency cryptocurrency) {
        int nextCoin = cryptocurrency.ordinal() - 1 ; //Log.e("CRYPTORESOURCES", "PREVIOUS COIN "+cryptocurrency);
        if (nextCoin < 0 ) { nextCoin = NUMBER_OF_CRYPTO_CURRENCIES ; } /** ensuring we dont go below number of crypto currency solving -1, -2, -... **/
        return getCryptoCurrency(nextCoin) ;
    }

    public static float getConversionRate(String amount, Currency currency, CryptoCurrency cryptoCurrency, Context context) {
        float newAmount ; float oldAmount = Float.parseFloat(amount) ;
        newAmount = oldAmount * getRate(currency, cryptoCurrency, context);
        return newAmount ;
    }

    public static String getAbsoluteConversionRate(String amount, Currency currency, CryptoCurrency cryptoCurrency, Context context) {
        float newAmount ; float oldAmount = Float.parseFloat(amount) ;
        newAmount = oldAmount * getRate(currency, cryptoCurrency, context);
        return LocaleResources.getCurrencySign(currency)+" "+newAmount ;
    }

}
