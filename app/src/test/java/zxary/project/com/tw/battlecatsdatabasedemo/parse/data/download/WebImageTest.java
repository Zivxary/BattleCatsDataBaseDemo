package zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download;

import android.graphics.Bitmap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.net.URL;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;

import static org.junit.Assert.assertNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class WebImageTest {

    private Bitmap expected;
    private Bitmap actual;

    @Before
    public void setUp() {
        expected = null;
        actual = null;
    }

    @Test
    public void GetImageTest_u001_1() {
        String fileName = "u001_1.png";
        URL url = TestUtility.getURL("https://battlecats-db.imgs-server.com/u001-1.png");
        expected = TestUtility.getBitmap(fileName);
        actual = new WebImage().get(url);

        TestUtility.assertEquals("ByteCount", expected.getByteCount(), actual.getByteCount());
        TestUtility.assertEquals("Height", expected.getHeight(), actual.getHeight());
        TestUtility.assertEquals("Width", expected.getWidth(), actual.getWidth());
        TestUtility.assertEquals("RowBytes", expected.getRowBytes(), actual.getRowBytes());
    }

    @Test
    public void GetImageTest_null() {
        URL url = TestUtility.getURL("https://battlecats-db.imgs-server.com/u017-3.png");
        actual = new WebImage().get(url);
        assertNull(actual);
    }

}