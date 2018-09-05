package zxary.project.com.tw.battlecatsdatabasedemo.parse.thread;

import java.util.LinkedList;
import java.util.List;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class ParseThread extends Thread {
    
    private List<StatsData> emptyList = new LinkedList<>();
    
    private IParseTask parseTask;
    
    public ParseThread(IParseTask parseTask) {
        this.parseTask = parseTask;
    }

    @Override
    public void run() {
        List<StatsData> statsDataList = new LinkedList<>();
        while (true) {
            statsDataList.addAll(getDataList());
            for (StatsData data : statsDataList) {
                try {
                    parseTask.putSaveData(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (parseTask.isDownloadFinish()) {
                parseTask.notifyParseFinish();
                break;
            }
        }
    }
    
    private List<StatsData> getDataList() {
        DownloadData data = parseTask.getDownloadData();
        if (data != null) {
            return data.toStatsData();
        }
        return emptyList;
    }
}
