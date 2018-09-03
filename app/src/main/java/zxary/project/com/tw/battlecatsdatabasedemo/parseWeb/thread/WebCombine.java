package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.dagger2.WebComponentHolder;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.stats.CatStatCollection;

public class WebCombine extends Thread {
    
    private static final int DOWNLOAD_SIZE = 5;
    private static final int SAVE_SIZE = 9;
    
    private BlockingQueue<DownloadData> downloadQueue = new ArrayBlockingQueue<>(DOWNLOAD_SIZE);
    private BlockingQueue<CatStatCollection> saveQueue = new ArrayBlockingQueue<>(SAVE_SIZE);
    
    private DownloadThread downloadThread;
    private ParseThread parseThread;
    
    private IDownloadThreadFactory downloadThreadFactory;
    private IParseThreadFactory parseThreadFactory;
    
    public WebCombine() {
        super();
        WebComponentHolder.inject(this);
        downloadThread = downloadThreadFactory.create(downloadQueue);
        parseThread = parseThreadFactory.create(downloadQueue, saveQueue);
    }
    
    @Inject
    public void setDownloadThreadFactory(IDownloadThreadFactory factory) {
        downloadThreadFactory = factory;
    }
    
    @Inject
    public void setParseThreadFactory(IParseThreadFactory factory) {
        parseThreadFactory = factory;
    }
    
    @Override
    public void run() {
        downloadThread.start();
        parseThread.start();
        try {
            downloadThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            parseThread.end();
            try {
                parseThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
