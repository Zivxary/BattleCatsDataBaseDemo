package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data;

import android.graphics.Bitmap;

import org.junit.Test;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetCatDataTest {

    private final int size = 3;
    private final int id = 1;

    @Test
    public void call() {

        WebCatDocument mockWebDoc = getMockWebDoc();
        WebCatImage mockWebImage = getMockWebImage();

        GetCatData test = new GetCatData(id);
        test.set(mockWebDoc, mockWebImage);
        DownloadData actual = test.call();

        assertEquals(id, actual.getId());
        assertEquals(TestUtility.getTestHtml(), actual.getDoc().outerHtml());
        assertEquals(size, actual.getBitmaps().length);

        verify(mockWebDoc).get(anyInt());
        verify(mockWebImage).get(anyInt());
    }

    private WebCatDocument getMockWebDoc() {
        WebCatDocument mockWebDoc = mock(WebCatDocument.class);
        when(mockWebDoc.get(anyInt())).thenReturn(TestUtility.getDocument());
        return mockWebDoc;
    }

    private WebCatImage getMockWebImage(){
        WebCatImage mockWebImage = mock(WebCatImage.class);
        when(mockWebImage.get(anyInt())).thenReturn(new Bitmap[size]);
        return mockWebImage;
    }
}