package zxary.project.com.tw.battlecatsdatabasedemo.DataBase.Dagger2;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import zxary.project.com.tw.battlecatsdatabasedemo.DataBase.CatsTable;
import zxary.project.com.tw.battlecatsdatabasedemo.DataBase.ITable;

@Module
public class DBModule {
	
	@Provides
	@Named("Cats")
	public ITable provideDBTable() {
		return new CatsTable();
	}
}
