package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Dagger2;

import dagger.Module;
import dagger.Provides;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.AbstractInfoValue;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.Basic;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.Battle;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleType;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.IValueFactory;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.ValueFactory;

@Module
public class DataModule {

    @Provides
    public IValueFactory<BattleType, AbstractInfoValue<Integer>> provideBattleValueFactory() {
        return new ValueFactory<>();
    }

    @Provides
    public Battle provideBattle(final IValueFactory<BattleType, AbstractInfoValue<Integer>> factory) {
        return new Battle(factory);
    }

    @Provides
    public Basic provideBasic() {
        return new Basic();
    }
}
