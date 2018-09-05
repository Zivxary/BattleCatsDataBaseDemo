package zxary.project.com.tw.battlecatsdatabasedemo.parse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.DownloadThread;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.IDownloadTask;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DownloadThreadTest {
    
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {new Integer[]{1, 2, 3, 4, 5, 7, 8, 9, 12, 13, 14, 18, 19, 20}},
                        {new Integer[]{1, 2, 3, 5, 6, 7, 10, 11, 12, 13, 14, 15, 18, 19, 23, 24, 25, 26, 27, 28, 30}},
                        {new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}},
                        {new Integer[]{1, 2, 3, 4, 5, 6, 10, 11, 12, 13, 18, 19, 20, 21, 22, 23, 27, 28, 29, 30}}
                });
    }

    private Integer[] needDataId;
    
    public DownloadThreadTest(final Integer... ids) {
        this.needDataId = ids;
    }

    @Test
    public void run() {
        FakeDownloadTask downloadTask = new FakeDownloadTask();
        DownloadThread downloadThread = newDownloadThread(downloadTask);
        downloadThread.start();
        downloadTask.start();
        try {
            downloadThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Integer> assertList = downloadTask.getAssertList();
        printList(assertList);
        for (Integer i : needDataId) {
            assertTrue("未包含：" + i, assertList.contains(i));
            assertList.remove(i);
        }
        assertTrue("資料有多", assertList.size() == 0);
        assertTrue("未通知完成", downloadTask.isFinish());
    }
    
    private DownloadThread newDownloadThread(IDownloadTask downloadTask) {
        IDownloadCallableFactory downloadDataFactory = new FakeDownloadCallableFactory(needDataId);
        return new DownloadThread(downloadTask, downloadDataFactory);
    }
    
    private void printList(final List<Integer> assertSet) {
        String s = assertSet.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "));
        System.out.println(s);
    }

}