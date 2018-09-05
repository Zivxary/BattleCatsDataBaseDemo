package zxary.project.com.tw.battlecatsdatabasedemo.parse.data.url;

import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL生成基類
 */
public class BaseUrl implements IBuildUrl {
    
    /**
     * 對輸入字串 做前置處理
     * @param url 網址或路徑之字串
     * @return URL實例
     */
    public URL get(final String url) {
        return create(url);
    }
    
    /**
     * 生成 URL實例
     * @param url 網址或路徑之字串
     * @return URL實例
     */
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
