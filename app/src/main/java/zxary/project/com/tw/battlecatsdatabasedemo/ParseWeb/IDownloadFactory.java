package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import java.util.concurrent.Callable;

public interface IDownloadFactory {
    Callable<DownloadData> create(int id);
}
