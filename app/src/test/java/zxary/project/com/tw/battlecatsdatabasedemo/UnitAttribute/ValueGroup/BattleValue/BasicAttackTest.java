package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleValue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.AbstractInfoValueTest;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleValue.BasicAttack;

@RunWith(Parameterized.class)
public class BasicAttackTest extends AbstractInfoValueTest<Integer> {

    public BasicAttackTest(final String filename, final int expected) {
        super(filename, expected, new BasicAttack());
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {"CatData107_1.html", 3110},
                });
    }

}