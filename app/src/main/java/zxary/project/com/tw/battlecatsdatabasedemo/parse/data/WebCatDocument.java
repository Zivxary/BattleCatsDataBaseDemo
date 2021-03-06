package zxary.project.com.tw.battlecatsdatabasedemo.parse.data;

import org.jsoup.nodes.Document;

import java.net.URL;

import javax.inject.Inject;
import javax.inject.Named;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download.IWebData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.url.IBuildUrl;

public class WebCatDocument {

    private IBuildUrl buildUrl;
    private IWebData<Document> webDoc;


    @Inject
    public WebCatDocument(@Named("catDoc") final IBuildUrl buildDocUrl,
                          final IWebData<Document> webDocument) {
        webDoc = webDocument;
        buildUrl = buildDocUrl;
    }

    public Document get(final int catId) {
        URL url = buildUrl.get(Integer.toString(catId));
        return webDoc.get(url);
    }
}
