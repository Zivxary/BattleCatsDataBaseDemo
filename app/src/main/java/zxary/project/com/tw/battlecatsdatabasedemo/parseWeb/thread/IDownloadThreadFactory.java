package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread;

import java.util.concurrent.BlockingQueue;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.DownloadData;

public interface IDownloadThreadFactory {
    
    DownloadThread create(BlockingQueue<DownloadData> downloadQueue);
}
