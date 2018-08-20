package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;

public class Battle extends AbstractStat<BattleType, Integer, AbstractInfoValue<Integer>> {

    @Inject
    public Battle(final IValueFactory<BattleType, AbstractInfoValue<Integer>> valueFactory) {
        super();
        valueFactory.setPath(getClass().getPackage().getName() + ".BattleValue");
        for (BattleType type : BattleType.values()) {
            mapPut(type, valueFactory.create(type));
        }
    }

    @Override
    public void setAll(final StatsData myDoc) {

        for (BattleType type : BattleType.values()) {
            setValue(type, myDoc);
        }
    }
}
