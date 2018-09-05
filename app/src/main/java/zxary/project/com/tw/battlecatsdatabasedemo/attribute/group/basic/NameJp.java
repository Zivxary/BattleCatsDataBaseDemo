package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.basic;

import org.jsoup.select.Elements;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class NameJp extends AbstractInfoValue<String> {

    @Override
    public void setValue(final StatsData myDoc) {

        Elements data = myDoc.getDoc().select("tr[class=bgc12]>td");
        String name = data.get(2).text();
        set(name);
    }
}
