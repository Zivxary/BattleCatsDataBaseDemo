package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.GetWebData;

import java.net.URL;

public interface IWebData<T> {
    T get(URL url);
}
