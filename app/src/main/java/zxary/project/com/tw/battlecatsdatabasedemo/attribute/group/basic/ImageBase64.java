package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.basic;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class ImageBase64 extends AbstractInfoValue<String> {

    private static final int QUALITY = 100;

    @Override
    public void setValue(final StatsData data) {
        Bitmap bitmap = data.getBitmap();
        if (bitmap != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, QUALITY, stream);
            byte[] bytes = stream.toByteArray();
            set(Base64.encodeToString(bytes, Base64.DEFAULT));
        } else {
            Log.w(getClass().getName(),
                    "No Image to build base64 String");
        }
    }
}
