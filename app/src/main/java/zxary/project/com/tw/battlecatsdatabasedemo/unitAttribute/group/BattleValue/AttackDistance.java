package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BattleValue;

import org.jsoup.nodes.Document;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.AbstractInfoValue;

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
