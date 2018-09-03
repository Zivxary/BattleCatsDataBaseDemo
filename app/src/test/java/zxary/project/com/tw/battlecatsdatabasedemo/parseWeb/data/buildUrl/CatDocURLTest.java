package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.buildUrl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CatDocURLTest {

    private CatDocUrl catDocURL;
    private String catId;
    private String expected;

    public CatDocURLTest(final String id, final String expected) {
        catId = id;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {"0", "https://battlecats-db.com/unit/000.html"},
                        {"999", "https://battlecats-db.com/unit/999.html"}
                });
    }

    @Before
    public void setup() {
        catDocURL = new CatDocUrl();
    }

    @Test
    public void get() {
        URL url = catDocURL.get(catId);
        assertEquals(expected, url.toString());
    }
}
