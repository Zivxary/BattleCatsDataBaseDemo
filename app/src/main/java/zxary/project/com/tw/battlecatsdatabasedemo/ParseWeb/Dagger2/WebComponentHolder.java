package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Dagger2;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Dagger2.DaggerWebComponent;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Dagger2.WebComponent;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Dagger2.WebModule;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.GetCatData;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.DownloadData;

public class WebComponentHolder {

    private static WebComponent webComponent =
            DaggerWebComponent.builder().build();

    public static void inject(final GetCatData getCatData) {
        webComponent.inject(getCatData);
    }

    public static void inject(final DownloadData downloadData){
        webComponent.inject(downloadData);
    }
}
