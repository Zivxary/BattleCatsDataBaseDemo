package zxary.project.com.tw.battlecatsdatabasedemo.DataBase.Dagger2;

import zxary.project.com.tw.battlecatsdatabasedemo.DataBase.DBHelper;

public class DBComponentHolder {
	private static DBComponent component =
			DaggerDBComponent.builder().build();
	
	public static void inject(final DBHelper helper) {
		component.inject(helper);
	}
}
