package com.example.lanspinner;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int LITTLE_MARGIN = 1;
    public final static int MEDIUM_MARGIN = 2;
    public final static int LARGE_MARGIN = 3;


    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_DEFAULT:
            case LITTLE_MARGIN:
                activity.setTheme(R.style.LittleMargin);
                break;
            case MEDIUM_MARGIN:
                activity.setTheme(R.style.MediumMargin);
                break;
            case LARGE_MARGIN:
                activity.setTheme(R.style.LargeMargin);
        }
    }
}
