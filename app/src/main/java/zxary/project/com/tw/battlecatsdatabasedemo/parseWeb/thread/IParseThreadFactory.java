package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread;

import java.util.concurrent.BlockingQueue;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.stats.CatStatCollection;

public interface IParseThreadFactory {
    
    ParseThread create(BlockingQueue<DownloadData> downloadQueue,
                       BlockingQueue<CatStatCollection> saveQueue);
}
