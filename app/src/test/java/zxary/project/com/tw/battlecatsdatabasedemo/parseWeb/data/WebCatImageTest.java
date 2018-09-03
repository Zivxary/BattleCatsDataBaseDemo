package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data;

import android.graphics.Bitmap;
import android.graphics.Point;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowBitmapFactory;

import java.net.URL;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.buildUrl.IBuildUrl;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.getWebData.IWebData;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class WebCatImageTest {
    
    private int testId;
    private String[] actualSid = new String[3];
    private String[] expectSid = new String[3];
    private String[] actualUrl = new String[3];
    private String[] expectUrl = new String[3];
    private Point[] testSize;
    
    @Before
    public void setUp() {
        testId = 10;
        for (int i = 0; i < 3; ++i) {
            expectSid[i] = testId + "-" + i;
            expectUrl[i] = "http://" + expectSid[i];
        }
        testSize = new Point[]{
                new Point(100, 101),
                new Point(102, 103),
                new Point(104, 105)
        };
    }
    
    @Test
    public void get() {
        
        String testSid = null;
        WebCatImage test = new WebCatImage(new FakeBuildURL(), new FakeWebImage());
        Bitmap[] bitmaps = test.get(testId);
        
        assertArrayEquals("TestSid", expectSid, actualSid);
        assertArrayEquals("TestUrl", expectUrl, actualUrl);
        
        for (int i = 0; i < 3; ++i) {
            assertEquals("TestWidth(" + i + ")", testSize[i].x, bitmaps[i].getWidth());
            assertEquals("TestHeight(" + i + ")", testSize[i].y, bitmaps[i].getHeight());
        }
    }
    
    private class FakeBuildURL implements IBuildUrl {
        
        private int index = 0;
        
        @Override
        public URL get(String id) {
            actualSid[index++] = id;
            return TestUtility.getURL("http://" + id);
        }
    }
    
    private class FakeWebImage implements IWebData<Bitmap> {
        
        private final String name = "testBitmap";
        private int index = 0;
        
        @Override
        public Bitmap get(URL url) {
            actualUrl[index] = url.toExternalForm();
            Bitmap bm = ShadowBitmapFactory.create(name + index, null, testSize[index]);
            ++index;
            return bm;
        }
    }
}