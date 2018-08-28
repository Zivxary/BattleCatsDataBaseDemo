package zxary.project.com.tw.battlecatsdatabasedemo.DataBase;

import org.junit.Test;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;

import static org.junit.Assert.assertEquals;

public class AbstractTableTest {
	
	@Test
	public void getCreateTableString() {
		TestTable table = new TestTable();
		String actual = table.getCreateTableSQL();
		String expected = TestUtility.getString("CreateDefaultTable.txt");
		assertEquals(expected, actual);
	}
	
	private class TestTable extends AbstractTable {
	}
}