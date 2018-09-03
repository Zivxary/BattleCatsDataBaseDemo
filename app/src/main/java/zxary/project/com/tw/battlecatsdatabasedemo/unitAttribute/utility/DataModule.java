package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.utility;

import dagger.Module;
import dagger.Provides;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.AbstractInfoValue;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.Basic;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BasicType;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.Battle;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BattleType;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.IValueFactory;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.ValueFactory;

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
