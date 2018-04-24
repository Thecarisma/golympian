package gig.library.golympian.userdevice;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.database.Cursor;
import android.os.Build;
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

    private Activity activity ;
    private ArrayList<String> emailList = new ArrayList<>() ;

    /**
     * initializing the class with a activity
     * @param activity the base activity
     */
    public DeviceUser(Activity activity) {
        this.activity = activity ;
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
        requestContactAndProfilePermission();
        try {
            Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
            Account[] accounts = AccountManager.get(activity).getAccounts();
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
        requestContactAndProfilePermission();
        String name = "" ;
        try {
            Cursor c = activity.getContentResolver()
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

    private void requestContactAndProfilePermission() {
        Permission.requestPermission(activity, Manifest.permission.READ_CONTACTS, Permission.REQUEST_PERMISSION);
        Permission.requestPermission(activity, Manifest.permission.GET_ACCOUNTS, Permission.REQUEST_PERMISSION);
    }

    public int getBuildVersion() {
        return Build.VERSION.SDK_INT ;
    }

    public Build getBuild() {
        return new Build() ;
    }

    public String getBuildName() {
        return Build.VERSION.CODENAME ;
    }

}
