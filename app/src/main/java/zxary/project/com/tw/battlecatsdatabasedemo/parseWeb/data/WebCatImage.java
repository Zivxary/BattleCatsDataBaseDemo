package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data;

import android.graphics.Bitmap;

import java.net.URL;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.buildUrl.IBuildUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.getWebData.IWebData;

public class WebCatImage {

    private IBuildUrl buildUrl;
    private IWebData<Bitmap> image;

    @Inject
    public WebCatImage(@Named("catImage") final IBuildUrl buildImageUrl,
                       final IWebData<Bitmap> webImage) {
        this.buildUrl = buildImageUrl;
        this.image = webImage;
    }

    public Bitmap[] get(final int catId) {
        final int size = 3;
        Bitmap[] bitmaps = new Bitmap[size];

        for (int i = 0; i < size; i++) {
            String sid = String.format(Locale.getDefault(), "%d-%d", catId, i);
            URL url = buildUrl.get(sid);
            bitmaps[i] = image.get(url);
        }
        return bitmaps;
    }
}
