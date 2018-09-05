package zxary.project.com.tw.battlecatsdatabasedemo.parse.dagger2;

import android.graphics.Bitmap;

import org.jsoup.nodes.Document;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.IDownloadCallableFactory;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.GetCatData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.WebCatDocument;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.WebCatImage;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download.IWebData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download.WebDocument;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download.WebImage;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.url.CatDocUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.url.CatImageUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.url.IBuildUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.jsoup.IJsoup;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.jsoup.JsoupCollection;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.DownloadThread;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.IDownloadThreadFactory;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.IParseThreadFactory;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.ParseThread;

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
        return (task) -> new DownloadThread(task, downloadFactory);
    }
    
    @Provides
    public IParseThreadFactory provideIParseThreadFactory() {
        return ParseThread::new;
    }
}
