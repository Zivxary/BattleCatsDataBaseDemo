package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group;

import org.jsoup.nodes.Document;
import org.junit.Test;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

import static org.junit.Assert.assertEquals;

public abstract class AbstractInfoValueTest<T> {

    private String filename;
    private AbstractInfoValue<Integer> infoValue;
    private Integer expectedValue;

    public AbstractInfoValueTest(final String fileName, final int expected, final AbstractInfoValue<Integer> infoValue) {
        filename = fileName;
        expectedValue = expected;
        this.infoValue = infoValue;
    }

    @Test
    public void assertInfoValue() {
        StatsData data = new StatsData();
        Document doc = TestUtility.getDocument(filename);
        data.setDoc(doc);
        infoValue.setValue(data);
        assertEquals(expectedValue, infoValue.get());
    }
}