package zxary.project.com.tw.battlecatsdatabasedemo.attribute.field;

import org.junit.Test;

import java.util.List;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;

import static org.junit.Assert.assertEquals;

public class AbstractStatsFieldTest {
    
    @Test
    public void getFieldList() {
        List<FieldData> actual = new StatsFieldTest().getFieldList();
        StringBuilder sb = new StringBuilder(256);
        for (FieldData data : actual) {
            sb.append(data);
        }
        String expected = TestUtility.getString("StatsFieldListTest.txt");
        assertEquals(expected, sb.toString());
    }
    
    class StatsFieldTest extends AbstractStatsField {
    }
}