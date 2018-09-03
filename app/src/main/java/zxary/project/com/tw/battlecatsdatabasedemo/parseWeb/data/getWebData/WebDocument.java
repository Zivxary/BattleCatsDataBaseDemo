package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.getWebData;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.EmptyObj;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.jsoup.IJsoup;

public class WebDocument implements IWebData<Document> {
    
    private IJsoup jsoup;
    private URL url;
    private Document document;

    @Inject
    public WebDocument(final IJsoup jsoupUrl) {
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
