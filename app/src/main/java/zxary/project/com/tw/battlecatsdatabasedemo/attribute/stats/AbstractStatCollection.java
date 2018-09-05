package zxary.project.com.tw.battlecatsdatabasedemo.attribute.stats;

import android.content.ContentValues;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.Basic;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.BasicType;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.Battle;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.BattleType;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.utility.DataComponentHolder;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public abstract class AbstractStatCollection implements IStats {

    private Basic basic;
    private Battle battle;
    private List<String> characteristicJp;
    private List<String> characteristicZh = new LinkedList<>();
    
    AbstractStatCollection(final StatsData data) {
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
    
    protected void addCharacteristicZh(final String characteristic) {
        characteristicZh.add(characteristic);
    }
    
    @Override
    public ContentValues toContentValue() {
        ContentValues cv = new ContentValues();
        cv.putAll(basic.toContentValues());
        cv.putAll(battle.toContentValues());
        return cv;
    }
    
    @Override
    public String getUid() {
        return get(BasicType.Uid);
    }
    
    @Override
    public String getUidName() {
        return BasicType.Uid.name();
    }
}
