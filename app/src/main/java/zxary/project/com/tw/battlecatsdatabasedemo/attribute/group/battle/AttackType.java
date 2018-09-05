package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.battle;

import org.jsoup.nodes.Document;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoValue;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class AttackType extends AbstractInfoValue<Integer> {

    private static final String SINGLE = "単体";
    private static final String MULT = "範囲";

    @Override
    public void setValue(final StatsData myDoc) {
        Document doc = myDoc.getDoc();
        String cssQuery = "td[class=R]";
        final int index = 12;

        String text = doc.select(cssQuery).get(index).text();
        int value = attackTypeStr(text);
        set(value);
    }

    private int attackTypeStr(final String type) {
        switch (type) {
            case SINGLE:
                return 1;
            case MULT:
                return 2;
            default:
                return 0;
        }
    }
}
