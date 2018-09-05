package zxary.project.com.tw.battlecatsdatabasedemo.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Closeable;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.stats.IStats;
import zxary.project.com.tw.battlecatsdatabasedemo.database.utility.StringRes;

public final class CatTableDAO implements Closeable {
    
    private static final int NO_DATA = -1;
    private static final String KEY_ID = "_id";
    private static final String TABLE_NAME = StringRes.getCatTableName();
    
    private SQLiteDatabase db;
    
    public CatTableDAO(final Context context) {
        db = getDataBase(context);
    }
    
    protected SQLiteDatabase getDataBase(Context context) {
        return DBHelper.getDatabase(context);
    }
    
    public void close() {
        db.close();
    }
    
    public boolean modify(IStats stats) {
        //TODO
        int keyId = getKeyId(stats.getUid());
        if (keyId == NO_DATA) {
            return insert(stats);
        } else {
            return update(stats);
        }
    }
    
    private int getKeyId(String uid) {
        try (Cursor cursor = db.rawQuery(StringRes.whereSQL(TABLE_NAME), new String[]{uid})) {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(KEY_ID);
            if (index == NO_DATA) {
                return NO_DATA;
            }
            return cursor.getInt(index);
        }
    }
    
    public boolean insert(IStats stats) {
        db.insert(TABLE_NAME, null, stats.toContentValue());
        return false;
    }
    
    public boolean update(IStats stats) {
        //TODO
        String where = KEY_ID + "=" + getKeyId(stats.getUid());
        return db.update(TABLE_NAME, stats.toContentValue(), where, null) > 0;
    }
}
