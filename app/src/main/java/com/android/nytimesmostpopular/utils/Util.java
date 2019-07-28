package com.android.nytimesmostpopular.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by sharma4frnds on 26/07/19.
 */

public class Util {

    public static boolean isInternetConnected(Activity activity) {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}

