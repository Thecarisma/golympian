package gig.library.golympian.views;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.ArrayList;

import gig.library.golympian.R;

/**
 * Created by thecarisma on 12/22/2017.
 */

public class LightView {

    Activity activity ; View view ;

    public LightView(Activity activity) {
        this.activity = activity ;
    }

    public LightView(View view) {
        this.view = view ;
    }

    /**
     * set the content of string text view into the provided view id and throws error
     * if it is null
     * @param id the view id
     * @param text the string content
     */
    public void setText(int id, String text) {
        if (activity != null) {
            setText(id, text, activity);
        } else if (view != null) {
            setText(id, text, view);
        }
    }

    /**
     * set the content of string text view into the provided editText and throws error
     * if it is null
     * @param editText the textView
     * @param text the string content
     */
    public void setText(EditText editText, String text) {
        editText.setText(text);
    }

    /**
     * set the content of string text view into the provided textView and throws error
     * if it is null
     * @param textView the textView
     * @param text the string content
     */
    public void setText(TextView textView, String text) {
        textView.setText(text);
    }

    /**
     * set the content of string text view into the provided view id and throws error
     * if it is null. The view from provided view
     * @param id the view id
     * @param text the string content
     * @param view  parenting view of id
     */
    public void setText(int id, String text, View view) {
        if (view.findViewById(id) instanceof TextView) {
            ((TextView) view.findViewById(id)).setText(text);
        } else if (view.findViewById(id) instanceof EditText) {
            ((EditText) view.findViewById(id)).setText(text);
        }

    }

    /**
     * set the content of string text view into the provided view id and throws error
     * if it is null. The view from provided activity
     * @param id the view id
     * @param text the string content
     * @param activity  parenting activity of id
     */
    public void setText(int id, String text, Activity activity) {
        if (activity.findViewById(id) instanceof TextView) {
            ((TextView) activity.findViewById(id)).setText(text);
        } else if (activity.findViewById(id) instanceof EditText) {
            ((EditText) activity.findViewById(id)).setText(text);
        }

    }

    public void loadImage(ImageView imgView, String url) {
        Glide.with(activity.getApplicationContext()).load(url).into(imgView);
    }

    public void loadImage(int id, String url) {
        loadImage(((ImageView)activity.findViewById(id)), url);
    }

    public void loadImage(ImageView imgView, URL url) {
        loadImage(imgView, url.getPath());
    }

    public void loadImage(int id, URL url) {
        loadImage(((ImageView)activity.findViewById(id)), url.getPath());
    }

    public void setVisibility(int id, int visibility) {
        if (activity != null) {
            activity.findViewById(id).setVisibility(visibility);
        } else if (view != null) {
            view.findViewById(id).setVisibility(visibility);
        }
    }

    public void inflateSpinner(Spinner spinner, String[] spinnerContent, int position) {
        ArrayList<String> spinnerArray =  new ArrayList<>(); ArrayAdapter<String> spinnerAdapter = null ;
        if (activity != null) {
            spinnerAdapter = new ArrayAdapter<>(activity, R.layout.spinner_item, spinnerArray);
        } else {
            spinnerAdapter = new ArrayAdapter<>(view.getContext(), R.layout.spinner_item, spinnerArray);
        }
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        for (String currency : spinnerContent) {
            spinnerArray.add(currency);
        }
        spinner.setAdapter(spinnerAdapter); spinner.setSelection(position);
    }

    public static void inflateSpinner(Activity activity, Spinner spinner, String[] spinnerContent, int position) {
        ArrayList<String> spinnerArray =  new ArrayList<>();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(activity, R.layout.spinner_item, spinnerArray);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        for (String currency : spinnerContent) {
            spinnerArray.add(currency);
        }
        spinner.setAdapter(spinnerAdapter); spinner.setSelection(position);
    }

    public void inflateSpinner(Spinner spinner, String[] spinnerContent) {
        ArrayList<String> spinnerArray =  new ArrayList<>(); ArrayAdapter<String> spinnerAdapter = null ;
        if (activity != null) {
            spinnerAdapter = new ArrayAdapter<>(activity, R.layout.spinner_item, spinnerArray);
        } else {
            spinnerAdapter = new ArrayAdapter<>(view.getContext(), R.layout.spinner_item, spinnerArray);
        }
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        for (String currency : spinnerContent) {
            spinnerArray.add(currency);
        }
        spinner.setAdapter(spinnerAdapter); spinner.setSelection(0);
    }

    public static void inflateSpinner(Activity activity, Spinner spinner, String[] spinnerContent) {
        ArrayList<String> spinnerArray =  new ArrayList<>();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(activity, R.layout.spinner_item, spinnerArray);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        for (String currency : spinnerContent) {
            spinnerArray.add(currency);
        }
        spinner.setAdapter(spinnerAdapter); spinner.setSelection(0);
    }

}
