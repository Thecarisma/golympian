package thecarisma.golympian.monetary;

import android.app.Activity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class HerculeanAd {

    private ArrayList<AdView> adViews = new ArrayList<>(); //the ad view to load the ad
    private ArrayList<AdRequest> adRequests = new ArrayList<>();

    public static String TEST_BANNER_AD_UNIT = "ca-app-pub-3940256099942544/6300978111" ;

    public HerculeanAd() { }

    public HerculeanAd(AdView mAdView) {
        adViews.add(mAdView) ; adRequests.add(new AdRequest.Builder().build());
    }

    public HerculeanAd(View mAdView) {
        adViews.add((AdView)mAdView) ; adRequests.add(new AdRequest.Builder().build());
    }

    public HerculeanAd(ArrayList<AdView> mAdViews) {
        adViews = mAdViews ; adRequests.add(new AdRequest.Builder().build());
    }

    public HerculeanAd(Activity activity, int mAdView) {
        adViews.add(((AdView) activity.findViewById(mAdView))) ;
        adRequests.add(new AdRequest.Builder().build());
    }

    public HerculeanAd(Activity activity, ArrayList<Integer> mAdView) {
        for (int a = 0 ; a < mAdView.size(); a++) {
            adViews.add(((AdView) activity.findViewById(mAdView.get(a)))) ;
            adRequests.add(new AdRequest.Builder().build());
        }
    }

    public void add(AdView mAdView) {
        adViews.add(mAdView) ; adRequests.add(new AdRequest.Builder().build());
    }

    public void add(View mAdView) {
        adViews.add((AdView)mAdView) ; adRequests.add(new AdRequest.Builder().build());
    }

    public void add(ArrayList<AdView> mAdViews) {
        adViews = mAdViews ; adRequests.add(new AdRequest.Builder().build());
    }

    public void add(Activity activity, int mAdView) {
        adViews.add(((AdView) activity.findViewById(mAdView))) ;
        adRequests.add(new AdRequest.Builder().build());
    }

    public void add(Activity activity, ArrayList<Integer> mAdView) {
        for (int a = 0 ; a < mAdView.size(); a++) {
            adViews.add(((AdView) activity.findViewById(mAdView.get(a)))) ;
            adRequests.add(new AdRequest.Builder().build());
        }
    }

    public void serve() {
        for (int a = 0 ; a < adViews.size(); a++) {
            adViews.get(a).loadAd(adRequests.get(a));
        }
    }

    public void serve(int value){
        for (int a = 0 ; a < adViews.size(); a++) {
            adViews.get(a).loadAd(adRequests.get(a)); final int ia = a ;
            if (value == 0) {
                adViews.get(a).setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        adViews.get(ia).setVisibility(View.GONE);
                    }
                });
            } else {
                adViews.get(a).setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        adViews.get(ia).setVisibility(View.VISIBLE);
                    }
                });
            }
        }
    }

    public AdView getAd(int index) {
        return adViews.get(index);
    }

    public AdRequest getAdRequest(int index) {
        return adRequests.get(index);
    }

}
