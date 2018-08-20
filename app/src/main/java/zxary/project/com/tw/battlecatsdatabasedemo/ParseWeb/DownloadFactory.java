package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import java.util.concurrent.Callable;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.GetCatData;

public class DownloadFactory implements IDownloadFactory {

    @Override
    public Callable<DownloadData> create(final int id) {
        return new GetCatData(id);
    }
}
