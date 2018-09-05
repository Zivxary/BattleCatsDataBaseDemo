package zxary.project.com.tw.battlecatsdatabasedemo.parse.dagger2;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.GetCatData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.CrawlingData;

public class WebComponentHolder {

    private static WebComponent webComponent =
            DaggerWebComponent.builder().build();

    public static void inject(final GetCatData getCatData) {
        webComponent.inject(getCatData);
    }
    
    public static void inject(final DownloadData downloadData) {
        webComponent.inject(downloadData);
    }
    
    public static void inject(CrawlingData crawlingData) {
        webComponent.inject(crawlingData);
    }
}
