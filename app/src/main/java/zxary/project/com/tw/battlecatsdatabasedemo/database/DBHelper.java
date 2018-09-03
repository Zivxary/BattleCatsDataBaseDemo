package zxary.project.com.tw.battlecatsdatabasedemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;
import javax.inject.Named;

import zxary.project.com.tw.battlecatsdatabasedemo.database.create.ITable;
import zxary.project.com.tw.battlecatsdatabasedemo.database.utility.DBComponentHolder;

public class DBHelper extends SQLiteOpenHelper {
    
    private static final String DB_NAME = "BattleCatsData.db";
    
    private static final int VERSION = 1;

    private static SQLiteDatabase database;
    
    private ITable catsTable;
    
    public DBHelper(final Context context,
                    final String name,
                    final SQLiteDatabase.CursorFactory factory,
                    final int version) {
        super(context, name, factory, version);
        DBComponentHolder.inject(this);
    }
    
    public static SQLiteDatabase getDatabase(final Context context) {
        if (database == null || !database.isOpen()) {
            database = new DBHelper(context, DB_NAME, null, VERSION)
                    .getWritableDatabase();
        }
        return database;
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        db.execSQL(catsTable.getCreateTableSQL());
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + catsTable.getTableName());
        onCreate(db);
    }
    
    @Inject
    public void setCatsTable(@Named("Cats") ITable iTable) {
        catsTable = iTable;
    }
    
}

