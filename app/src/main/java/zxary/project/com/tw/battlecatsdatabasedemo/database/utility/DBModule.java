package zxary.project.com.tw.battlecatsdatabasedemo.database.utility;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import zxary.project.com.tw.battlecatsdatabasedemo.database.create.CatsTable;
import zxary.project.com.tw.battlecatsdatabasedemo.database.create.ITable;

@Module
public class DBModule {
    
    @Provides
    @Named("Cats")
    public ITable provideDBTable() {
        return new CatsTable();
    }
}
