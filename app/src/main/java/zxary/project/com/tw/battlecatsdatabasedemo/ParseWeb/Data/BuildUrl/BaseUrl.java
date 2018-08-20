package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.BuildUrl;

import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseUrl implements IBuildUrl {

    public URL get(final String url) {
        return create(url);
    }

    protected URL create(final String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            Log.e(getClass().getName(), "URL生成失敗");
            e.printStackTrace();
        }
        return null;
    }
}
