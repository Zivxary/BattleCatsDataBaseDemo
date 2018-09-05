package zxary.project.com.tw.battlecatsdatabasedemo.database.create;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.field.FieldData;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.field.ValueType;

import static org.junit.Assert.assertEquals;

public class AbstractTableTest {
    
    @Test
    public void getCreateTableString() {
        TestTable table = new TestTable();
        String actual = table.getCreateTableSQL();
        String expected = TestUtility.getString("CreateDefaultTable.sql");
        assertEquals(expected, actual);
    }
    
    private class TestTable extends AbstractTable {
        
        @Override
        public String getTableName() {
            return "Default";
        }
        
        @Override
        protected List<FieldData> getFieldList() {
            List<FieldData> list = new LinkedList<>();
            list.add(new FieldData("TestString", ValueType.TEXT));
            list.add(new FieldData("TestInteger", ValueType.VALUE));
            return list;
        }
    }
}