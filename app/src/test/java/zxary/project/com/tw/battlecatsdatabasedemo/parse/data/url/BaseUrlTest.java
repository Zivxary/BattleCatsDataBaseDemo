package zxary.project.com.tw.battlecatsdatabasedemo.parse.data.url;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BaseUrlTest {

    private String url;

    public BaseUrlTest(final String url) {
        super();
        this.url = url;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                "https://battlecats-db.com/unit/000.html",
                "https://battlecats-db.com/unit/999.html",
                ""
        );
    }

    @Test
    public void get() {
        BaseUrl baseUrl = new BaseUrl();
        assertEquals(baseUrl.get(url), TestUtility.getURL(url));
    }
}