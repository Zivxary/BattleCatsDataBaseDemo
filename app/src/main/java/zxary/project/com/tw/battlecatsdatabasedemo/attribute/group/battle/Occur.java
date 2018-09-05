package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.battle;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoIntValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class Occur extends AbstractInfoIntValue {
    
    @Override
    public void setValue(final StatsData myDoc) {
        
        String cssQuery = "td[class=R]";
        final int index = 6;
        
        setValue(myDoc, cssQuery, index);
    }
}
