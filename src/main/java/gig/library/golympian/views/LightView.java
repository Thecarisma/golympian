package gig.library.golympian.views;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    public void setTextView(int id, String text) {
        if (activity != null) {
            setText(id, text, activity);
        } else if (view != null) {
            setText(id, text, view);
        }
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
        if (view.findViewById(id) instanceof TextView) {
            ((TextView) activity.findViewById(id)).setText(text);
        } else if (view.findViewById(id) instanceof EditText) {
            ((EditText) activity.findViewById(id)).setText(text);
        }

    }

}
