package zxary.project.com.tw.battlecatsdatabasedemo.DataBase;

import java.util.LinkedList;
import java.util.List;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.StatsField.FieldData;

abstract class AbstractTable implements ITable {
	
	protected static final String TEXT = "TEXT DEFAULT ''";
	protected static final String VALUE = "INTEGER DEFAULT 0";
	
	String tableName = "Default";
	protected String keyId = "_id";
	
	protected List<FieldData> getFieldList() {
		return new LinkedList<>();
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public String getCreateTableSQL() {
		final int capacity = 1024;
		StringBuilder sb = new StringBuilder(capacity);
		sb.append("CREATE TABLE IF NOT EXISTS ")
				.append(tableName).append(" ")
				.append("(").append(keyId).append(" ")
				.append("INTEGER PRIMARY KEY AUTOINCREMENT");
		for (FieldData data : getFieldList()) {
			sb.append(",").append(" ");
			appendFieldData(sb, data);
		}
		sb.append(" ").append(")");
		return sb.toString();
	}
	
	private void appendFieldData(StringBuilder sb, FieldData data) {
		sb.append(data.getName());
		switch (data.getType()) {
			case TEXT:
				sb.append(TEXT);
				break;
			case VALUE:
				sb.append(VALUE);
				break;
			default:
				break;
		}
	}
}
