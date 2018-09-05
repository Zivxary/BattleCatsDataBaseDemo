package zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.jsoup.JsoupCollection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WebDocumentTest {

    private URL testURL;
    private String expected;

    public WebDocumentTest(final String url, final String expected) {
        testURL = TestUtility.getURL(url);
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {"https://battlecats-db.com/unit/001.html", "にゃんこ大戦争DB 味方詳細 No.001 ネコ ネコビルダー ネコモヒカン"},
                        {"https://battlecats-db.com/unit/999.html", "にゃんこ大戦争データベース"},
                        {"https://battlecats-db.com/unit/99999.html", "にゃんこ大戦争データベース"},
                        {"", ""}
                });
    }

    @Test
    public void getDocumentTest() {
        Document document = new WebDocument(new JsoupCollection()).get(testURL);
        assertEquals(expected, document.title());
    }
}
