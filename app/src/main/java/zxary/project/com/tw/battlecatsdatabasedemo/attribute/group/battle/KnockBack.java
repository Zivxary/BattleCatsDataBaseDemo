package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.battle;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoIntValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class KnockBack extends AbstractInfoIntValue {
    
    @Override
    public void setValue(final StatsData myDoc) {
        
        String cssQuery = "td[class=R]";
        final int index = 1;
        
        setValue(myDoc, cssQuery, index);
    }
}
