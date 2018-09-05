package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group;

import android.content.ContentValues;

import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.HashMap;
import java.util.Map;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class BattleTest {
    
    private static final Map<BattleType, Integer> map = new HashMap<>();
    
    static {
        map.put(BattleType.AttackDistance, 175);
        map.put(BattleType.AttackType, 2);
        map.put(BattleType.BasicAttack, 3110);
        map.put(BattleType.BasicHealPoint, 4300);
        map.put(BattleType.Frequency, 315);
        map.put(BattleType.Interval, 120);
        map.put(BattleType.KnockBack, 2);
        map.put(BattleType.Money, 2660);
        map.put(BattleType.MoveSpeed, 8);
        map.put(BattleType.Occur, 76);
    }
    
    private Battle battle;
    
    @Before
    public void Before() {
        battle = new Battle(new ValueFactory<>());
        String filename = "CatData107_1.html";
        StatsData data = new StatsData();
        Document doc = TestUtility.getDocument(filename);
        data.setDoc(doc);
        battle.setAll(data);
    }
    
    @Test
    public void setAll() {
        for (BattleType type : BattleType.values()) {
            assertEquals(map.get(type), battle.get(type));
        }
    }
    
    @Test
    public void toContentValues() {
        ContentValues cv = battle.toContentValues();
        for (BattleType type : BattleType.values()) {
            assertEquals(map.get(type), cv.get(type.name()));
        }
    }
    
    @After
    public void After() {
        battle = null;
    }
}