package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.BattleValue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group.AbstractInfoValueTest;

@RunWith(Parameterized.class)
public class MoneyTest extends AbstractInfoValueTest<Integer> {

    public MoneyTest(final String filename, final int expected) {
        super(filename, expected, new Money());
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {"CatData107_1.html", 2660},
                });
    }
}