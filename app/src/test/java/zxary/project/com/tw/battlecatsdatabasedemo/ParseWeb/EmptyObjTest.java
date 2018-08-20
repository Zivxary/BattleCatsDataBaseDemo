package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import org.jsoup.nodes.Document;
import org.junit.Test;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;

import static org.junit.Assert.assertEquals;

public class EmptyObjTest {

    @Test
    public void getDocument() {
        Document actual = EmptyObj.getDocument();
        Document expected = TestUtility.getFakeDocNull();

        assertEquals(expected.outerHtml(), actual.outerHtml());
    }

    @Test
    public void isEmpty_noText_true() {
        Document test = TestUtility.getFakeDocNull();
        boolean actual = EmptyObj.isEmpty(test);

        assertEquals(Boolean.TRUE, actual);
    }

    @Test
    public void isEmpty_anyText_false() {
        Document test = TestUtility.getFakeDoc("<body>123</body>");
        boolean actual = EmptyObj.isEmpty(test);

        assertEquals(Boolean.FALSE, actual);
    }

    @Test
    public void isEmpty_null_true() {
        Document test = null;
        boolean actual = EmptyObj.isEmpty(test);

        assertEquals(Boolean.TRUE, actual);
    }
}