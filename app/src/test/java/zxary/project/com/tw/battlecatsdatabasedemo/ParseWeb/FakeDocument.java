package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import org.jsoup.nodes.Document;

public class FakeDocument extends Document {

    private String outerHtml;

    public FakeDocument(final String html) {
        super("");
        outerHtml = html;
    }

    @Override
    public String outerHtml() {
        return outerHtml;
    }
}
