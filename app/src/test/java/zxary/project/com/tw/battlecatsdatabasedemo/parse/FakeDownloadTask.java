package zxary.project.com.tw.battlecatsdatabasedemo.parse;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.IDownloadTask;

public class FakeDownloadTask extends Thread implements IDownloadTask {
    
    private BlockingQueue<DownloadData> queue = new ArrayBlockingQueue<>(5);
    private List<Integer> assertList = new LinkedList<>();
    private boolean finish = false;
    
    @Override
    public void putDownloadData(DownloadData data) throws InterruptedException {
        queue.put(data);
    }
    
    @Override
    public void notifyDownloadFinish() {
        finish = true;
    }
    
    @Override
    public void start() {
        while (true) {
            if (!queue.isEmpty()) {
                try {
                    DownloadData data = queue.take();
                    assertList.add(data.getId());
                    sleep((int) (Math.random() * 5) + 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (finish && queue.size() == 0) {
                break;
            }
        }
    }
    
    public List<Integer> getAssertList() {
        return assertList;
    }
    
    public boolean isFinish() {
        return finish;
    }
}
