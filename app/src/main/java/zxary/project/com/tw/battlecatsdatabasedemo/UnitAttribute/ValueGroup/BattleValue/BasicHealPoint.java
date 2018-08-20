package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleValue;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.AbstractInfoIntValue;

public class BasicHealPoint extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "font[class=c07 hide]";
        final int index = 0;

        setValue(myDoc, cssQuery, index);
    }
}
