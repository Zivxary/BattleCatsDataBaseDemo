package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import org.jsoup.nodes.Document;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Jsoup.IJsoupString;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Jsoup.JsoupCollection;

public class EmptyObj {

    private static IJsoupString jsoup = new JsoupCollection();

    private static final Document DOCUMENT = jsoup.parse("");

    public static Document getDocument() {
        return DOCUMENT.clone();
    }

    public static boolean isEmpty(final Document value) {
        return value == null || DOCUMENT.outerHtml().equals(value.outerHtml());
    }
}
