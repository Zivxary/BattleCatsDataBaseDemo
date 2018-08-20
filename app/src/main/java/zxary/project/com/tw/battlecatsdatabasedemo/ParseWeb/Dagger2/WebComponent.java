package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Dagger2;

import dagger.Component;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.GetCatData;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.DownloadData;

@Component(modules = {WebModule.class})
public interface WebComponent {
     void inject(GetCatData getCatData);
     void inject(DownloadData downloadData);
}
