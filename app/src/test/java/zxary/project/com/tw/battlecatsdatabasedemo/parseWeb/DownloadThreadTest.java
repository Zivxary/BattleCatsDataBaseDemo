package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread.DownloadThread;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DownloadThreadTest {

    private Integer[] needDataId;
    
    public DownloadThreadTest(final Integer... ids) {
        this.needDataId = ids;
    }

    @Test
    public void run() {
        BlockingQueue<DownloadData> queue = new LinkedBlockingQueue<>();
        IDownloadCallableFactory downloadDataFactory = new FakeDownloadCallableFactory(needDataId);
        DownloadThread downloadThread = new DownloadThread(queue, downloadDataFactory);
        downloadThread.start();
        try {
            downloadThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<Integer> assertSet = toSet(queue);
        printList(assertSet);
        for (Integer i : needDataId) {
            assertTrue(assertSet.contains(i));
            assertSet.remove(i);
        }
        assertTrue(assertSet.size() == 0);
    }

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

    private Set<Integer> toSet(final BlockingQueue<DownloadData> queue) {
        Set<Integer> set = new HashSet<>();
        for (DownloadData doc : queue) {
            set.add(doc.getId());
        }
        return set;
    }

    private void printList(final Set<Integer> assertSet) {
        String s = assertSet.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "));
        System.out.println(s);
    }

}