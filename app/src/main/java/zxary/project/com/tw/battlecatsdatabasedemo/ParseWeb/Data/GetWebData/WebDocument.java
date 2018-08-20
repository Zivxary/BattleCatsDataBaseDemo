package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.GetWebData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.EmptyObj;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Jsoup.IJsoupURL;

public class WebDocument implements IWebData<Document> {

    private IJsoupURL jsoup;
    private URL url;
    private Document document;

    @Inject
    public WebDocument(final IJsoupURL jsoupUrl) {
        jsoup = jsoupUrl;
    }


    public Document get(final URL docUrl) {
        document = null;
        url = docUrl;

        if (url == null) {
            return emptyDocument();
        }
        tryConnectUrlAndSetDocument();

        if (document == null) {
            return emptyDocument();
        }
        return document;
    }

    private void tryConnectUrlAndSetDocument() {
        final int testConnectMaxTimes = 3;
        for (int connectTimes = 0; connectTimes < testConnectMaxTimes; connectTimes++) {
            connectUrlAndSetDocument();
        }
    }

    private void connectUrlAndSetDocument() {
        try {
            final int timeoutMillis = 3000;
            document = jsoup.parse(url, timeoutMillis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Document emptyDocument() {
        return EmptyObj.getDocument();
    }
}
