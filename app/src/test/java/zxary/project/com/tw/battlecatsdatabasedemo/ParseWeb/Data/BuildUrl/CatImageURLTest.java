package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.BuildUrl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CatImageURLTest {

    private CatImageUrl catImageURL;
    private String id;
    private String expected;

    public CatImageURLTest(final String id, final String expected) {
        super();
        this.id = id;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {"003-1", "https://battlecats-db.imgs-server.com/u003-1.png"},
                        {"999-1", "https://battlecats-db.imgs-server.com/u999-1.png"}
                });
    }

    @Before
    public void setup() {
        catImageURL = new CatImageUrl();
    }

    @Test
    public void get() {
        URL url = catImageURL.get(id);
        assertEquals(expected, url.toString());
    }



}