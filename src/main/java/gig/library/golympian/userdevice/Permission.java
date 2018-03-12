package gig.library.golympian.userdevice;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import static gig.library.golympian.base.Constants.aresconstants;

/**
 * Created by thecarisma on 12/23/2017.
 */

public class Permission {

    Activity activity ;
    public static int REQUEST_PERMISSION = 1000 ;
    public static int DECLINE_PERMISSION = 1001 ;
    public static int CHECK_PERMISSION   = 1002 ;

    /**
     * permission constructor with activity
     * @param activity the initializer activity
     */
    public Permission(Activity activity) {
        this.activity = activity ;
    }

    /**
     * check if a permission has been granted to the application
     * @param permission the permission to check if granted
     */
    public boolean isPermissionGranted(String permission) {
        return ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED ;
    }

    /**
     * check if a permission has been granted to the application from a static context with a custom activity without
     * the default initializer
     * @param permission the permission to check if granted
     * @param activity the activity that request the permmision
     */
    public static boolean isPermissionGranted(String permission, Activity activity) {
        return ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED ;
    }

    /**
     * check if a permission has been granted to the application. if granted debug it to developer in console else request
     * the permission from the user
     * @param permission the permission to request for
     * @param requestCode the code to check for in the onRequestPermissionsResult() method
     */
    public void requestPermission(String permission, Integer requestCode) {
        if (isPermissionGranted(permission)) {
            aresconstants.treatDebug(aresconstants.USERDEVICETAG, permission+" is already granted");
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                //This is called if user has denied the permission before
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
            }
        }
    }

    /**
     * check if a permission has been granted to the application. if granted debug it to developer in console else request
     * the permission from the user in a static context with a custom activity
     * @param activity the activity that request the permmision
     * @param permission the permission to request for
     * @param requestCode the code to check for in the onRequestPermissionsResult() method
     */
    public static void requestPermission(Activity activity, String permission, Integer requestCode) {
        if (isPermissionGranted(permission, activity)) {
            aresconstants.treatDebug(aresconstants.USERDEVICETAG, permission+" is already granted");
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                //This is called if user has denied the permission before
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
            }
        }
    }


}
