package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.battle;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoIntValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class BasicAttack extends AbstractInfoIntValue {

    @Override
    public void setValue(final StatsData myDoc) {

        String cssQuery = "font[class=c11 hide]";
        final int index = 0;

        setValue(myDoc, cssQuery, index);
    }
}
