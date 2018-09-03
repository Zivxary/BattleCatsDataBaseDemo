package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb;

import org.jsoup.nodes.Document;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.jsoup.IJsoup;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.jsoup.JsoupCollection;

public class EmptyObj {
    
    private static IJsoup jsoup = new JsoupCollection();

    private static final Document DOCUMENT = jsoup.parse("");

    public static Document getDocument() {
        return DOCUMENT.clone();
    }

    public static boolean isEmpty(final Document value) {
        return value == null || DOCUMENT.outerHtml().equals(value.outerHtml());
    }
}
