package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.battle;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoIntValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class Interval extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "td[class=R]";
        final int index = 10;

        setValue(myDoc, cssQuery, index);
    }
}
