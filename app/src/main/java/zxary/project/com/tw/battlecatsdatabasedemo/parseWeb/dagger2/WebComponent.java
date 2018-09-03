package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.dagger2;

import dagger.Component;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.GetCatData;
import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.thread.WebCombine;

@Component(modules = {WebModule.class})
public interface WebComponent {
    void inject(GetCatData getCatData);
    
    void inject(DownloadData downloadData);
    
    void inject(WebCombine webCombine);
}
