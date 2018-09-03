package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BattleValue;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.AbstractInfoIntValue;

public class BasicAttack extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "font[class=c11 hide]";
        final int index = 0;

        setValue(myDoc, cssQuery, index);
    }
}
