package gig.library.golympian.userdevice;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Patterns;

import java.util.ArrayList;
import java.util.regex.Pattern;

import gig.library.golympian.misc.Filter;

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

    /**
     * this method fetch the device owner display name as stored on the device NOTE : this can throw error
     * on some devices to try and catch it in your program.
     * on some modified android device this method tends to fall therefore the initial of the email address
     * is return instead of noting
     * @return owner of device name
     */
    public String getDeviceUserName() {
        String name = "" ;
        try {
            Cursor c = context.getApplicationContext().getContentResolver()
                    .query(ContactsContract.Profile.CONTENT_URI, null, null, null, null);
            c.moveToFirst();
            name = c.getString(c.getColumnIndex(
                    ContactsContract.Profile.DISPLAY_NAME
            ));
            c.close();
        } catch (Exception ex) {
            aresconstants.treatException(aresconstants.USERDEVICETAG, ex);
            name = getPrimaryEmail().split("@")[0];
        }
        return Filter.removeNumbers(name);
    }

}
