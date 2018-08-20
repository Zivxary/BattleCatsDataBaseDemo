package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup;

import org.jsoup.nodes.Document;
import org.junit.Test;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.AbstractInfoValue;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.Battle;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleType;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.ValueFactory;

import static org.junit.Assert.assertEquals;

public class BattleTest {

    private Battle battle;

    @Test
    public void setAll() {
        battle = new Battle(new ValueFactory<>());
        String filename = "CatData107_1.html";
        StatsData data = new StatsData();
        Document doc = TestUtility.getDocument(filename);
        data.setDoc(doc);
        battle.setAll(data);

        assertValue(175, BattleType.AttackDistance);
        assertValue(2, BattleType.AttackType);
        assertValue(3110, BattleType.BasicAttack);
        assertValue(4300, BattleType.BasicHealPoint);
        assertValue(315, BattleType.Frequency);
        assertValue(120, BattleType.Interval);
        assertValue(2, BattleType.KnockBack);
        assertValue(2660, BattleType.Money);
        assertValue(8, BattleType.MoveSpeed);
        assertValue(76, BattleType.Occur);

    }

    private void assertValue(final Integer expected, final BattleType type) {
        assertEquals(expected, battle.get(type));
    }
}