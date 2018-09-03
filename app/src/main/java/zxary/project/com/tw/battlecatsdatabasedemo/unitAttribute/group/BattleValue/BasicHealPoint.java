package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BattleValue;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.AbstractInfoIntValue;

public class BasicHealPoint extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "font[class=c07 hide]";
        final int index = 0;

        setValue(myDoc, cssQuery, index);
    }
}
