package gig.library.golympian.userdevice;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Patterns;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static gig.library.golympian.base.Constants.aresconstants;

/**
 * Created by thecarisma on 12/22/2017.
 */

public class DeviceUser {

    private Context context ;
    private ArrayList<String> emailList = new ArrayList<>() ;

    /**
     * initializing the class with a context
     * @param context the base context
     */
    public DeviceUser(Context context) {
        this.context = context ;
    }

    /**
     * get the device primary email address
     */
    public String getPrimaryEmail() {
        try {
            return getEmails().get(0);
        } catch (Exception ex) {
            aresconstants.treatException(aresconstants.USERDEVICETAG, ex);
            return "" ;
        }
    }

    /**
     * this method load all the signed in emails on the device into an array list
     * @return emailList
     */
    public ArrayList<String> getEmails() {
        try {
            Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
            Account[] accounts = AccountManager.get(context).getAccounts();
            for (Account account : accounts) {
                if (emailPattern.matcher(account.name).matches()) {
                    String possibleEmail = account.name;
                    emailList.add(possibleEmail);
                }
            }
        } catch (Exception ex) {
            aresconstants.treatException(aresconstants.USERDEVICETAG, ex);
        }
        if (emailList.isEmpty()) {
            aresconstants.debugError(aresconstants.USERDEVICETAG, "No email found on this device");
        }
        return emailList ;
    }

}
