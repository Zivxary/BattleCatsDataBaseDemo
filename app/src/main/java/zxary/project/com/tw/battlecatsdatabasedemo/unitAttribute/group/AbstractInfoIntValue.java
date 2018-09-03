package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.StatsData;

public abstract class AbstractInfoIntValue extends AbstractInfoValue<Integer> {

    protected void setValue(final StatsData data, final String cssQuery, final int index) {

        String text = data.getDoc().select(cssQuery).get(index).text();
        int value = Integer.parseInt(text);
        set(value);
    }
}
