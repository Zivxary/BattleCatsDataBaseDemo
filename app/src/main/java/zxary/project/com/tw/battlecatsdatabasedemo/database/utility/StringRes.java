package zxary.project.com.tw.battlecatsdatabasedemo.database.utility;

import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BasicType;

public class StringRes {
    private static final String CAT_TABLE_NAME = "Cats";
    private static final String KEY_ID = "_id";
    private static final String UID = BasicType.Uid.name();
    
    public static String getCatTableName() {
        return CAT_TABLE_NAME;
    }
    
    public static String getKeyId() {
        return KEY_ID;
    }
    
    public static String whereSQL(String tableName) {
        return "SELECT " + KEY_ID + " FROM " + tableName + "WHERE" + UID + " = ?";
    }
    
    
}
