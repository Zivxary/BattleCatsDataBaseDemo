package zxary.project.com.tw.battlecatsdatabasedemo.parse;

import java.util.concurrent.Callable;

public interface IDownloadCallableFactory {
    Callable<DownloadData> create(int id);
}
