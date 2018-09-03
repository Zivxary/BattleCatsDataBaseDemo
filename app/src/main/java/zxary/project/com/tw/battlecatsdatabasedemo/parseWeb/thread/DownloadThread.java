package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.FutureDocument;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.IDownloadCallableFactory;

public class DownloadThread extends Thread {
    
    private static final int MAX_CORE = 3;
    private static final int MAX_NULL_DATA = 5;
    
    private BlockingQueue<DownloadData> queue;
    private IDownloadCallableFactory factory;
    private int finishId = 0;
    private int doneId = 0;
    private int assignId = 0;
    
    private ExecutorService executorService = Executors.newFixedThreadPool(MAX_CORE);
    private List<FutureDocument> checkList = new LinkedList<>();
    
    public DownloadThread(final BlockingQueue<DownloadData> downloadData,
                          final IDownloadCallableFactory downloadDataFactory) {
        super();
        queue = downloadData;
        factory = downloadDataFactory;
    }
    
    @Override
    public void run() {
        try {
            work();
        } finally {
            executorService.shutdown();
        }
    }
    
    private void work() {
        while (doneId - finishId < MAX_NULL_DATA) {
            assigningWork();
            checkAndPutCallback();
        }
    }
    
    private void assigningWork() {
        while (checkList.size() < MAX_CORE) {
            checkList.add(new FutureDocument(executorService.submit(factory.create(++assignId))));
        }
    }
    
    private void checkAndPutCallback() {
        for (FutureDocument future : checkList) {
            if (future.isDone()) {
                putProduct(future);
                return;
            }
        }
    }
    
    private void putProduct(final FutureDocument future) {
        doneId = Math.max(future.getId(), doneId);
        if (future.checkDocNotNull()) {
            finishId = doneId;
            try {
                queue.put(future.getMyDoc());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        checkList.remove(future);
    }
    
}

