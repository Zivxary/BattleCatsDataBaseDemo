package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.CatStats;

public class WebParseThread extends Thread {

    private BlockingQueue<DownloadData> toDoQueue;
    private BlockingQueue<CatStats> doneQueue;

    private Boolean stopFlag = false;

    public WebParseThread(final BlockingQueue<DownloadData> dataQueue,
                          final BlockingQueue<CatStats> saveQueue) {
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
                doneQueue.add(new CatStats(data));
            }
            if (stopFlag && toDoQueue.size() == 0) {
                break;
            }
        }
    }
}
