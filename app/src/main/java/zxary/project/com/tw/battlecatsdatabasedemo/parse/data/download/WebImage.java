package zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.utility.StringRes;

public class WebImage implements IWebData<Bitmap> {
    
    private URL url = null;
    private HttpURLConnection connection = null;
    private InputStream inputStream = null;
    
    public Bitmap get(final URL imageUrl) {
        init(imageUrl);
        try {
            inputStream = connect();
    
            if (checkConnectURL()) {
                return BitmapFactory.decodeStream(inputStream);
            }
        } catch (IOException e) {
            Log.e("WebImage Error", "Can't get from URL : " + (url == null ? "null" : url.toString()));
            e.printStackTrace();
        } finally {
            inputStreamClose();
            connection.disconnect();
        }
        return null;
    }
    
    private void init(final URL imageUrl) {
        url = imageUrl;
        connection = null;
        inputStream = null;
    }
    
    private InputStream connect() throws IOException {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Referer", getReferer());
        connection.connect();
        return connection.getInputStream();
    }
    
    private String getReferer() {
        return StringRes.getDBWebHomeUrl();
    }
    
    private boolean checkConnectURL() {
        return url.toString().equals(connection.getURL().toString());
    }
    
    private void inputStreamClose() {
        
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.w("WebImage close", "InputStream can't close");
                e.printStackTrace();
            }
        }
        
    }
}
