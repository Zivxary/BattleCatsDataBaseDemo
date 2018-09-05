package zxary.project.com.tw.battlecatsdatabasedemo.attribute.utility;

import dagger.Module;
import dagger.Provides;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoValue;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.Basic;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.BasicType;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.Battle;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.BattleType;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.IValueFactory;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.ValueFactory;

@Module
public class DataModule {

    @Provides
    public IValueFactory<BattleType, AbstractInfoValue<Integer>> provideBattleValueFactory() {
        return new ValueFactory<>();
    }

    @Provides
    public IValueFactory<BasicType, AbstractInfoValue<String>> provideBasicValueFactory() {
        return new ValueFactory<>();
    }

    @Provides
    public Battle provideBattle(
            final IValueFactory<BattleType, AbstractInfoValue<Integer>> factory) {
        return new Battle(factory);
    }

    @Provides
    public Basic provideBasic(
            final IValueFactory<BasicType, AbstractInfoValue<String>> factory) {
        return new Basic(factory);
    }
}
