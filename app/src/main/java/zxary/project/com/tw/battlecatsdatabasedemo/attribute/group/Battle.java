package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group;

import android.content.ContentValues;

import javax.inject.Inject;

public class Battle extends AbstractStat<BattleType, Integer, AbstractInfoValue<Integer>> {

    @Inject
    public Battle(final IValueFactory<BattleType, AbstractInfoValue<Integer>> valueFactory) {
        super(valueFactory, ".battle");
    }
    
    @Override
    public void contentValuesPut(ContentValues cv, BattleType type) {
        cv.put(type.name(), get(type));
    }
}
