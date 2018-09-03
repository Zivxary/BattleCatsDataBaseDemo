package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.utility;

import java.util.Locale;

public class StringRes {

    private static final String WEB_CAT_HOME_URL
            = "https://battlecats-db.com/";
    private static final String WEB_CAT_FORMAT_URL
            = "https://battlecats-db.com/unit/%s.html";
    private static final String WEB_CAT_IMAGE_FORMAT_URL
            = "https://battlecats-db.imgs-server.com/u%s.png";
    
    private static String format(final String format, final Object... args) {
        return String.format(Locale.getDefault(), format, args);
    }

    public static String getDBWebHomeUrl() {
        return WEB_CAT_HOME_URL;
    }

    public static String getWebCatImageFormatUrl(final String uid) {
        return format(WEB_CAT_IMAGE_FORMAT_URL, uid);
    }

    public static String getWebCatFormatUrl(final String uid) {
        return format(WEB_CAT_FORMAT_URL, uid);
    }
}
