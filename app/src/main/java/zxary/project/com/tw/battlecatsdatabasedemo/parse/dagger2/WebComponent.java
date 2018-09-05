package zxary.project.com.tw.battlecatsdatabasedemo.parse.dagger2;

import dagger.Component;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.DownloadData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.data.GetCatData;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.CrawlingData;

@Component(modules = {WebModule.class})
public interface WebComponent {
    void inject(GetCatData getCatData);
    
    void inject(DownloadData downloadData);
    
    void inject(CrawlingData crawlingData);
}
