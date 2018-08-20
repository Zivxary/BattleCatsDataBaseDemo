package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleValue;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.AbstractInfoIntValue;

public class MoveSpeed extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "td[class=R]";
        final int index = 5;

        setValue(myDoc, cssQuery, index);
    }
}
