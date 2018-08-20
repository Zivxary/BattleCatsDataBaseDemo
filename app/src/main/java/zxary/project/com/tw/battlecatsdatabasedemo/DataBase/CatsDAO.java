package zxary.project.com.tw.battlecatsdatabasedemo.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CatsDAO {

    private static final String TABLE_NAME = "cats";

    private SQLiteDatabase db;

    public static String getTableName() {
        return TABLE_NAME;
    }

    public CatsDAO(Context context) {
        db = DBHelper.getDatabase(context);
    }

    public void close() {
        db.close();
    }

    public void insert() {

    }


    public static String getCreateTableString() {
        //TODO
        return "";
    }
}
