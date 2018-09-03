package zxary.project.com.tw.battlecatsdatabasedemo.database.create;

import java.util.List;

import zxary.project.com.tw.battlecatsdatabasedemo.database.utility.StringRes;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.field.FieldData;

abstract class AbstractTable implements ITable {
    
    private static final String TEXT = "TEXT DEFAULT ''";
    private static final String VALUE = "INTEGER DEFAULT 0";
    private static final String KEY_ID = StringRes.getKeyId();
    
    public abstract String getTableName();
    
    protected abstract List<FieldData> getFieldList();
    
    public String getCreateTableSQL() {
        final int capacity = 1024;
        StringBuilder sb = new StringBuilder(capacity);
        sb.append("CREATE TABLE IF NOT EXISTS ")
                .append(getTableName()).append(" ")
                .append("(").append(KEY_ID).append(' ')
                .append("INTEGER PRIMARY KEY AUTOINCREMENT");
        for (FieldData data : getFieldList()) {
            sb.append(",").append(' ');
            appendFieldData(sb, data);
        }
        sb.append(' ').append(")");
        return sb.toString();
    }
    
    private void appendFieldData(StringBuilder sb, FieldData data) {
        sb.append(data.getName()).append(' ');
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
