package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Dagger2.DataComponentHolder;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.Basic;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BasicType;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.Battle;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleType;

public abstract class AbstractStats {

    private static final int SIZE = 6;

    public int id = 0;
    private Basic basic;
    private Battle battle;

    private List<String> characteristicJp;
    private List<String> characteristicZh;

    public AbstractStats(final StatsData data) {
        DataComponentHolder.inject(this);
        set(data);
    }

    @Inject
    public void setValueGroup(final Basic basic, final Battle battle) {
        this.basic = basic;
        this.battle = battle;
    }

    public String get(final BasicType type) {
        return basic.get(type);
    }

    public int get(final BattleType type) {
        return battle.get(type);
    }

    public void set(final StatsData data) {
        basic.setAll(data);
        battle.setAll(data);
        characteristicJp = new LinkedList<>(data.getCharacteristic());
    }
}
