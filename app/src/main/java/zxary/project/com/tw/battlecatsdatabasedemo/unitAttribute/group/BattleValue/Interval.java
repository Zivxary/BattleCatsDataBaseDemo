package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BattleValue;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.AbstractInfoIntValue;

public class Interval extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "td[class=R]";
        final int index = 10;

        setValue(myDoc, cssQuery, index);
    }
}
