package zxary.project.com.tw.battlecatsdatabasedemo.DataBase.Dagger2;

import dagger.Component;
import zxary.project.com.tw.battlecatsdatabasedemo.DataBase.DBHelper;

@Component(modules = {DBModule.class})
public interface DBComponent {
	void inject(DBHelper helper);
}
