package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.battle;

import org.jsoup.nodes.Document;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class AttackDistance extends AbstractInfoValue<Integer> {

    @Override
    public void setValue(final StatsData myDoc) {
        Document doc = myDoc.getDoc();
        String cssQuery = "td[class=R]";
        final int index = 9;

        String text = doc.select(cssQuery).get(index).text().replace(",", "");
        int value = Integer.parseInt(text);
        set(value);
    }
}
