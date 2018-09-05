package zxary.project.com.tw.battlecatsdatabasedemo.parse.thread;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.DownloadData;

public interface IDownloadTask {
    
    void putDownloadData(DownloadData data) throws InterruptedException;
    
    void notifyDownloadFinish();
}
