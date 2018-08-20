package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Dagger2;

import android.graphics.Bitmap;

import org.jsoup.nodes.Document;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.BuildUrl.CatImageUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.BuildUrl.CatDocUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.BuildUrl.IBuildUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.GetWebData.IWebData;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.WebCatDocument;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.WebCatImage;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.GetWebData.WebDocument;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.GetWebData.WebImage;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Jsoup.IJsoupString;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Jsoup.IJsoupURL;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Jsoup.JsoupCollection;

@Module
public class WebModule {

    @Provides
    public WebCatImage provideWebCatImage(
            @Named("catImage") final IBuildUrl buildImageUrl, final IWebData<Bitmap> webImage) {
        return new WebCatImage(buildImageUrl, webImage);
    }

    @Provides
    public WebCatDocument provideWebCatDocument(
            @Named("catDoc") final IBuildUrl buildUrl, final IWebData<Document> webDocument) {
        return new WebCatDocument(buildUrl, webDocument);
    }

    @Provides
    @Named("catDoc")
    public IBuildUrl provideBuildCatDocURL() {
        return new CatDocUrl();
    }

    @Provides
    @Named("catImage")
    public IBuildUrl provideBuildCatImageURL() {
        return new CatImageUrl();
    }

    @Provides
    public IWebData<Bitmap> provideWebImage() {
        return new WebImage();
    }

    @Provides
    public IWebData<Document> provideWebDocument(final IJsoupURL jsoup) {
        return new WebDocument(jsoup);
    }

    @Provides
    public IJsoupString provideIJsoupString() {
        return new JsoupCollection();
    }

    @Provides
    public IJsoupURL provideIJsoupURL() {
        return new JsoupCollection();
    }
}
