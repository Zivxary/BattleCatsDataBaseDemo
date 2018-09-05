package zxary.project.com.tw.battlecatsdatabasedemo.parse.thread;

public interface IDownloadThreadFactory {
    
    DownloadThread create(IDownloadTask downLoadTask);
}
