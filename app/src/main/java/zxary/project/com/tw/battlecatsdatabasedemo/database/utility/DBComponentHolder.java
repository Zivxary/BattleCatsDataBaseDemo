package zxary.project.com.tw.battlecatsdatabasedemo.database.utility;

import zxary.project.com.tw.battlecatsdatabasedemo.database.DBHelper;

public class DBComponentHolder {
    private static DBComponent component =
            DaggerDBComponent.builder().build();
    
    public static void inject(final DBHelper helper) {
        component.inject(helper);
    }
}
