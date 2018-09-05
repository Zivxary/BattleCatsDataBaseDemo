package zxary.project.com.tw.battlecatsdatabasedemo.parse.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.FutureDocument;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.IDownloadCallableFactory;

public class DownloadThread extends Thread {
    
    private static final int MAX_CORE = 3;
    private static final int MAX_NULL_DATA = 5;
    
    private IDownloadTask down1oadTask;
    private IDownloadCallableFactory factory;
    private int finishId = 0;
    private int doneId = 0;
    private int assignId = 0;
    
    private ExecutorService executorService = Executors.newFixedThreadPool(MAX_CORE);
    private List<FutureDocument> checkList = new LinkedList<>();
    
    public DownloadThread(final IDownloadTask downloadTask,
                          final IDownloadCallableFactory downloadDataFactory) {
        super();
        this.down1oadTask = downloadTask;
        factory = downloadDataFactory;
    }
    
    @Override
    public void run() {
        try {
            work();
        } finally {
            executorService.shutdown();
            down1oadTask.notifyDownloadFinish();
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
                down1oadTask.putDownloadData(future.getMyDoc());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        checkList.remove(future);
    }
    
}

