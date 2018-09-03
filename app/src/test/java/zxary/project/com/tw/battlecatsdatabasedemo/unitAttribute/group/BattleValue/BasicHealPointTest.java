package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BattleValue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.AbstractInfoValueTest;

@RunWith(Parameterized.class)
public class BasicHealPointTest extends AbstractInfoValueTest<Integer> {

    public BasicHealPointTest(final String filename, final int expected) {
        super(filename, expected, new BasicHealPoint());
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {"CatData107_1.html", 4300},
                });
    }
}