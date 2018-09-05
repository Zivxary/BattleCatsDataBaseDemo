package zxary.project.com.tw.battlecatsdatabasedemo.parse;

import org.jsoup.nodes.Document;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.jsoup.IJsoup;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.jsoup.JsoupCollection;

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
