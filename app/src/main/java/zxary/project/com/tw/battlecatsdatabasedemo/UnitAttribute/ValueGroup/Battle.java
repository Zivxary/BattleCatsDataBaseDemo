package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup;

import android.content.ContentValues;

import javax.inject.Inject;

public class Battle extends AbstractStat<BattleType, Integer, AbstractInfoValue<Integer>> {

    @Inject
    public Battle(final IValueFactory<BattleType, AbstractInfoValue<Integer>> valueFactory) {
        super(valueFactory, ".BattleValue");
    }
	
	@Override
	void contentValuesPut(ContentValues cv, BattleType type) {
		cv.put(type.name(), get(type));
	}
}
