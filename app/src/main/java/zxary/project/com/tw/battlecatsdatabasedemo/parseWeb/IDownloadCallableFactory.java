package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb;

import java.util.concurrent.Callable;

public interface IDownloadCallableFactory {
    Callable<DownloadData> create(int id);
}
