package zxary.project.com.tw.battlecatsdatabasedemo.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Stats.IStats;

public final class CatTableDAO {
	
	private static final String KEY_ID = "_id";
	private static final String TABLE_NAME = "Cats";
	
	private SQLiteDatabase db;
	
	public CatTableDAO(final Context context) {
		db = DBHelper.getDatabase(context);
	}
	
	public static String getTableName() {
		return TABLE_NAME;
	}
	
	public void close() {
		db.close();
	}
	
	public boolean update() {
		//TODO
		return false;
	}
	
	public boolean insert(IStats stats) {
		//TODO
		return false;
	}
}
