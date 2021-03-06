package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.basic;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class Uid extends AbstractInfoValue<String> {

    @Override
    public void setValue(final StatsData myDoc) {

        Document doc = myDoc.getDoc();
        Elements data = doc.select("tr[class=bgc12]>td");
        String text = data.get(1).text();
        String uid = text.replace("No.", "u").replace('-', '_');
        set(uid);
    }
}
