package zxary.project.com.tw.battlecatsdatabasedemo.DataBase;

import java.util.LinkedList;
import java.util.List;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BasicType;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleType;

abstract class AbstractTable implements ITable {
	
	protected static final String TEXT = "TEXT DEFAULT ''";
	protected static final String VALUE = "INTEGER DEFAULT 0";
	
	protected String tableName = "Default";
	protected String keyId = "_id";
	
	protected List<String> getTableList() {
		List<String> list = new LinkedList<>();
		for (BasicType type : BasicType.values()) {
			list.add(type.name() + " " + TEXT);
		}
		for (BattleType type : BattleType.values()) {
			list.add(type.name() + " " + VALUE);
		}
		return list;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public String getCreateTableString() {
		final int capacity = 1024;
		StringBuilder stringBuilder = new StringBuilder(capacity);
		stringBuilder.append("CREATE TABLE IF NOT EXISTS ")
				.append(tableName).append(" ")
				.append("(").append(keyId).append(" ")
				.append("INTEGER PRIMARY KEY AUTOINCREMENT");
		for (String s : getTableList()) {
			stringBuilder.append(",").append(" ").append(s);
		}
		stringBuilder.append(" ").append(")");
		return stringBuilder.toString();
	}
}
