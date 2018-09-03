package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.getWebData;

import java.net.URL;

public interface IWebData<T> {
    T get(URL url);
}
