package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.dagger2;

import android.graphics.Bitmap;

import org.jsoup.nodes.Document;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.IDownloadCallableFactory;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.GetCatData;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.WebCatDocument;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.WebCatImage;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.buildUrl.CatDocUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.buildUrl.CatImageUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.buildUrl.IBuildUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.getWebData.IWebData;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.getWebData.WebDocument;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.getWebData.WebImage;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.jsoup.IJsoup;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.jsoup.JsoupCollection;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread.DownloadThread;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread.IDownloadThreadFactory;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread.IParseThreadFactory;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread.ParseThread;

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
    public IWebData<Document> provideWebDocument(final IJsoup jsoup) {
        return new WebDocument(jsoup);
    }

    @Provides
    public IJsoup provideIJsoup() {
        return new JsoupCollection();
    }
    
    @Provides
    public IDownloadCallableFactory provideDownloadFactory() {
        return GetCatData::new;
    }
    
    @Provides
    public IDownloadThreadFactory provideDownloadThreadFactory(IDownloadCallableFactory downloadFactory) {
        return (queue) -> new DownloadThread(queue, downloadFactory);
    }
    
    @Provides
    public IParseThreadFactory provideIParseThreadFactory() {
        return ParseThread::new;
    }
}
