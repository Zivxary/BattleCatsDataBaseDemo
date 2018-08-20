package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;

public abstract class AbstractInfoIntValue extends AbstractInfoValue<Integer> {

    protected void setValue(final StatsData data, final String cssQuery, final int index) {

        String text = data.getDoc().select(cssQuery).get(index).text();
        int value = Integer.parseInt(text);
        set(value);
    }
}
