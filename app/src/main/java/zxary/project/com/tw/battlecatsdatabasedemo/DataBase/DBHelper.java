package zxary.project.com.tw.battlecatsdatabasedemo.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "BattleCatsData.db";

    public static final int VERSION = 13;

    private static SQLiteDatabase database;

    public DBHelper(Context context,
                    String name,
                    SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }

    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new DBHelper(context, DB_NAME, null, VERSION)
                    .getWritableDatabase();
        }
        return database;
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        //db.execSQL(CatsDAO.CREATE_TABLE);
        db.execSQL(CatsDAO.getCreateTableString());

    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CatsDAO.getTableName());
        onCreate(db);
    }
}

