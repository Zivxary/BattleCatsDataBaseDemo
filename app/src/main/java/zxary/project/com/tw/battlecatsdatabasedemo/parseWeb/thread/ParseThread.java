package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.stats.CatStatCollection;

public class ParseThread extends Thread {

    private BlockingQueue<DownloadData> toDoQueue;
    private BlockingQueue<CatStatCollection> doneQueue;

    private Boolean stopFlag = false;
    
    public ParseThread(final BlockingQueue<DownloadData> dataQueue,
                       final BlockingQueue<CatStatCollection> saveQueue) {
        toDoQueue = dataQueue;
        doneQueue = saveQueue;
    }

    public void end() {
        stopFlag = true;
    }

    @Override
    public void run() {
        List<StatsData> statsDataList = new LinkedList<>();
        while (true) {
            if (toDoQueue.size() > 0) {
                toDoQueue.remove().toStatsData(statsDataList);
            }
            for (StatsData data : statsDataList) {
                doneQueue.add(new CatStatCollection(data));
            }
            if (stopFlag && toDoQueue.size() == 0) {
                break;
            }
        }
    }
}
