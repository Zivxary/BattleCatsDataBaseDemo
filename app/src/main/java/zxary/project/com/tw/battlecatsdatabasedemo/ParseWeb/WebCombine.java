package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Stats.CatStatCollection;

public class WebCombine extends Thread {

    private static final int DOWNLOAD_SIZE = 5;
    private static final int SAVE_SIZE = 9;

    private BlockingQueue<DownloadData> downloadQueue = new ArrayBlockingQueue<>(DOWNLOAD_SIZE);
	private BlockingQueue<CatStatCollection> saveQueue = new ArrayBlockingQueue<>(SAVE_SIZE);

    private WebDownloadThread webDownloadThread;
    private WebParseThread webParseThread;

    public WebCombine() {
        super();
        webDownloadThread = new WebDownloadThread(downloadQueue, new DownloadFactory());
        webParseThread = new WebParseThread(downloadQueue, saveQueue);
    }

    @Override
    public void run() {
        webDownloadThread.start();
        webParseThread.start();
        try {
            webDownloadThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            webParseThread.end();
            try {
                webParseThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
