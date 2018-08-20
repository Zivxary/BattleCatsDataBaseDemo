package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleValue;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.AbstractInfoIntValue;

public class Frequency extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "td[class=R]";
        final int index = 2;

        setValue(myDoc, cssQuery, index);
    }
}
