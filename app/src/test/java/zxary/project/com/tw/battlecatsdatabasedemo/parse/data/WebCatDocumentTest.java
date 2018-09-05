package zxary.project.com.tw.battlecatsdatabasedemo.parse.data;

import org.jsoup.nodes.Document;
import org.junit.Test;

import java.net.URL;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download.IWebData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download.WebDocument;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.url.IBuildUrl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WebCatDocumentTest {

    @Test
    public void get() {

        IBuildUrl mockBuildUrl = getMockBuildUrl();
        IWebData<Document> mockWebDoc = getMockWebDoc();

        WebCatDocument actual = new WebCatDocument(mockBuildUrl, mockWebDoc);

        assertEquals(TestUtility.getTestHtml(), actual.get(1).outerHtml());
        verify(mockBuildUrl).get(anyString());
        verify(mockWebDoc).get(any(URL.class));
    }

    private IBuildUrl getMockBuildUrl() {
        IBuildUrl mockBuildUrl = mock(IBuildUrl.class);
        when(mockBuildUrl.get(anyString())).thenReturn(TestUtility.getURL());
        return mockBuildUrl;
    }

    private IWebData<Document> getMockWebDoc() {
        IWebData<Document> mockWebDoc = mock(WebDocument.class);
        when(mockWebDoc.get(any(URL.class))).thenReturn(getFakeDoc());
        return mockWebDoc;
    }

    private Document getFakeDoc() {
        return TestUtility.getFakeDoc();
    }
}