package misc;

import java.math.BigDecimal;

/**
 *  Created by Azeez Adewale on 11/26/2017.
 *  Copyright Great Innovation Group
 *  Licenced under tri Licence
 *      MIT LICENCE
 *      GNU LICENCE
 *      CDDL LICENCE
 *  on this day 11/26/2017 : 2:22 AM
 *
 *  Class : ZeusMath
 *  Filename : ZeusMath.java
 *  Project : Olympus
 *  Package : com.gig.olympus.basic
 *  Computer Name : Thecarisma
 */

public class ZeusMath {

    /**
     *
     *  forcefully round float into given places
     *
     * @param d the float you wish to round
     * @param decimalPlace the number of places you want it to round to
     * @return return the rounded float
     */
    public static float roundFloat(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}
