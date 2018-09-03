package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BasicValue;

import org.jsoup.select.Elements;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.AbstractInfoValue;

public class NameJp extends AbstractInfoValue<String> {

    @Override
    public void setValue(final StatsData myDoc) {

        Elements data = myDoc.getDoc().select("tr[class=bgc12]>td");
        String name = data.get(2).text();
        set(name);
    }
}
