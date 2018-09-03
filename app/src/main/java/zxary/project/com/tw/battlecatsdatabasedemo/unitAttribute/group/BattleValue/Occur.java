package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BattleValue;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.AbstractInfoIntValue;

public class Occur extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "td[class=R]";
        final int index = 6;

        setValue(myDoc, cssQuery, index);
    }
}
