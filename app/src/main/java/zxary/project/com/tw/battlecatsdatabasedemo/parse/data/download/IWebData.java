package zxary.project.com.tw.battlecatsdatabasedemo.parse.data.download;

import java.net.URL;

public interface IWebData<T> {
    T get(URL url);
}
