package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BasicValue;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.AbstractInfoValue;

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
                    "ID:" + data.getId() + ",No Image to build base64 String");
        }
    }
}
