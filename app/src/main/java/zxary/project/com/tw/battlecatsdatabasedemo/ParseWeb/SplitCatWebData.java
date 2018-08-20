package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Jsoup.IJsoupString;

public class SplitCatWebData {

    private static final String HEAD_HTML = "<html>\n<head></head>\n<body>\n<table>\n<tbody>\n";
    private static final String TAIL_HTML = "\n</tbody>\n</table>\n</body>\n</html>";
    private static final String SPLIT = "<split>";
    private static final String TAG_GET = "</tr>\n<tr class=\"bgc12\">";
    private static final String REPLACEMENT = "</tr>" + SPLIT + "<tr class=\"bgc12\">";

    private IJsoupString jsoup;

    @Inject
    public SplitCatWebData(final IJsoupString jsoupString) {
        jsoup = jsoupString;
    }

    public Document[] execute(final Document doc) {

        Elements elements = removeUnimportantData(doc);
        String[] datas = splitData(elements);
        return toDocuments(datas);
    }

    private Elements removeUnimportantData(final Document doc) {

        Elements element = doc.body().select("#List>tbody");
        element.select("tr.bgc12").get(0).remove();
        element.select("tr.hideCus").remove();
        element.select("tr.space").remove();
        element.before(HEAD_HTML);
        element.after(TAIL_HTML);

        return element;
    }

    private String[] splitData(final Elements elements) {

        String[] results = elements.html()
                .replace(TAG_GET, REPLACEMENT)
                .split(SPLIT);

        for (int i = 0; i < results.length; i++) {
            results[i] = HEAD_HTML + results[i] + TAIL_HTML;
        }
        return results;
    }

    private Document[] toDocuments(final String[] datas) {

        Document[] docs = new Document[datas.length];
        for (int i = 0; i < datas.length; i++) {
            docs[i] = jsoup.parse(datas[i]);
        }
        return docs;
    }

}
