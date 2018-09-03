package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.dagger2;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.GetCatData;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread.WebCombine;

public class WebComponentHolder {

    private static WebComponent webComponent =
            DaggerWebComponent.builder().build();

    public static void inject(final GetCatData getCatData) {
        webComponent.inject(getCatData);
    }
    
    public static void inject(final DownloadData downloadData) {
        webComponent.inject(downloadData);
    }
    
    public static void inject(WebCombine webCombine) {
        webComponent.inject(webCombine);
    }
}
