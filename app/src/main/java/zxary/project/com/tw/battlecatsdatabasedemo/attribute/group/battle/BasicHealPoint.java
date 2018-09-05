package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.battle;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoIntValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class BasicHealPoint extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "font[class=c07 hide]";
        final int index = 0;

        setValue(myDoc, cssQuery, index);
    }
}
