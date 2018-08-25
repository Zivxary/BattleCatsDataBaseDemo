package zxary.project.com.tw.battlecatsdatabasedemo.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public final class CatsDAO {
	
	private static final String KEY_ID = "_id";
	private static final String TABLE_NAME = "Cats";
	
	private SQLiteDatabase db;
	
	public CatsDAO(final Context context) {
		db = DBHelper.getDatabase(context);
	}
	
	public static String getTableName() {
		return TABLE_NAME;
	}
	
	public void close() {
		db.close();
	}
	
	public void insert() {
	
	}
}
