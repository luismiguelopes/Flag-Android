package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by luismiguelopes on 04/05/15.
 */
public class MillionaireContract {

    // table name
    public static final String TABLE = "TEMPERATURE";

    // columns names
    public static final String _ID = BaseColumns._ID;
    public static final String VALUE = "value";

    // content URI for subset of provided data from temperature provider.
    public static Uri CONTENT_PROVIDER = Uri.withAppendedPath(MillionaireProvider.CONTENT_URI, TABLE);


}
