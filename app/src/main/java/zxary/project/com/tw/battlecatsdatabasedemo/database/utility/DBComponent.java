package zxary.project.com.tw.battlecatsdatabasedemo.database.utility;

import dagger.Component;
import zxary.project.com.tw.battlecatsdatabasedemo.database.DBHelper;

@Component(modules = {DBModule.class})
public interface DBComponent {
    void inject(DBHelper helper);
}
