package gig.library.golympian.monetary;

import android.app.Activity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class HerculeanAd {

    private ArrayList<AdView> adViews = new ArrayList<AdView>(); //the ad view to load the ad

    public static String TEST_BANNER_AD_UNIT = "ca-app-pub-3940256099942544/6300978111" ;

    public HerculeanAd(AdView mAdView) {
        adViews.add(mAdView) ;
    }

    public HerculeanAd(View mAdView) {
        adViews.add((AdView)mAdView) ;
    }

    public HerculeanAd(ArrayList<AdView> mAdViews) {
        adViews = mAdViews ;
    }

    public HerculeanAd(Activity activity, int mAdView) {
        adViews.add(((AdView) activity.findViewById(mAdView))) ;
    }

    public HerculeanAd(Activity activity, ArrayList<Integer> mAdView) {
        for (int a = 0 ; a < mAdView.size(); a++) {
            adViews.add(((AdView) activity.findViewById(mAdView.get(a)))) ;
        }
    }

    public void serve() {
        for (int a = 0 ; a < adViews.size(); a++) {
            AdRequest adRequest = new AdRequest.Builder().build();
            adViews.get(a).loadAd(adRequest);
        }
    }

    public AdView getAd(int index) {
        return adViews.get(index);
    }

}
