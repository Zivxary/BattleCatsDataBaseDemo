package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BasicValue;

import org.jsoup.select.Elements;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.AbstractInfoValue;

public class NameJp extends AbstractInfoValue<String> {

    @Override
    public void setValue(final StatsData myDoc) {

        Elements data = myDoc.getDoc().select("tr[class=bgc12]>td");
        String name = data.get(2).text();
        set(name);
    }
}
