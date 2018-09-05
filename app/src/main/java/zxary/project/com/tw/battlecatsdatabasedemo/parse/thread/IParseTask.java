package zxary.project.com.tw.battlecatsdatabasedemo.parse.thread;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public interface IParseTask {
    
    DownloadData getDownloadData();
    
    boolean isDownloadFinish();
    
    void putSaveData(StatsData data) throws InterruptedException;
    
    void notifyParseFinish();
}
