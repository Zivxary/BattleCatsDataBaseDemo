package zxary.project.com.tw.battlecatsdatabasedemo.parse.data;

import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import zxary.project.com.tw.battlecatsdatabasedemo.TestUtility;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.FutureDocument;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FutureDocumentTest {

    public abstract class FutureDownloadData implements Future<DownloadData> { }

    private Future<DownloadData> mock;

    @Before
    public void setup() {
        mock = mock(FutureDownloadData.class);
    }

    @Test
    public void isDoneByFalse() {
        FutureDocument futureDocument = new FutureDocument(mock);
        when(mock.isDone()).thenReturn(Boolean.FALSE);

        assertFalse(futureDocument.isDone());
        verify(mock).isDone();
    }

    @Test
    public void isDoneByTrue() {
        FutureDocument futureDocument = new FutureDocument(mock);
        when(mock.isDone()).thenReturn(Boolean.TRUE);

        assertTrue(futureDocument.isDone());
        verify(mock).isDone();
    }

    @Test
    public void getIdAndVal() throws ExecutionException, InterruptedException {

        final int id = 99;
        final Document document = TestUtility.getFakeDoc();
        when(mock.isDone()).thenReturn(Boolean.TRUE);
        DownloadData myDoc = new DownloadData();
        myDoc.setId(id);
        myDoc.setDoc(document.clone());
        when(mock.get()).thenReturn(myDoc);

        FutureDocument futureDocument = new FutureDocument(mock);

        assertEquals(id, futureDocument.getId());
        assertEquals(document.outerHtml(), futureDocument.getMyDoc().getDoc().outerHtml());

        final int times = 2;
        verify(mock, times(times)).isDone();
        verify(mock, times(times)).get();
    }
}