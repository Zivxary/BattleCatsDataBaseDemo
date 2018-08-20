package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleValue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.AbstractInfoValueTest;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BattleValue.MoveSpeed;

@RunWith(Parameterized.class)
public class MoveSpeedTest extends AbstractInfoValueTest<Integer> {

    public MoveSpeedTest(final String filename, final int expected) {
        super(filename, expected, new MoveSpeed());
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {"CatData107_1.html", 8},
                });
    }

}