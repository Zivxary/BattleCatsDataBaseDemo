package zxary.project.com.tw.battlecatsdatabasedemo.parse;

import org.jsoup.nodes.Document;
import org.junit.Test;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.jsoup.JsoupCollection;

import static org.junit.Assert.assertEquals;

public class SplitDocumentTest {

    @Test
    public void start() {
        Document doc = TestUtility.getDocument("CatDoc107.html");
    
        SplitDocument splitDocument = new SplitDocument(new JsoupCollection());
        Document[] actual = splitDocument.execute(doc);

        Document[] expected = new Document[]{
                        TestUtility.getDocument("CatData107_1.html"),
                        TestUtility.getDocument("CatData107_2.html"),
                        TestUtility.getDocument("CatData107_3.html")
                };

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].outerHtml(), actual[i].outerHtml());
        }
    }
}