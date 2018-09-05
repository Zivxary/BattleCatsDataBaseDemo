package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.battle;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.AbstractInfoValueTest;

@RunWith(Parameterized.class)
public class IntervalTest extends AbstractInfoValueTest<Integer> {

    public IntervalTest(final String filename, final int expected) {
        super(filename, expected, new Interval());
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {"CatData107_1.html", 120},
                });
    }

}