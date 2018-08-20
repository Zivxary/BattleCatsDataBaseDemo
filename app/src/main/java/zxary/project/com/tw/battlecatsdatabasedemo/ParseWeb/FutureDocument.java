package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureDocument {

    private Future<DownloadData> future;

    public FutureDocument(final Future<DownloadData> futureMyDoc) {
        this.future = futureMyDoc;
    }

    public boolean isDone() {
        return future.isDone();
    }

    public int getId() {
        return getFuture().getId();
    }

    public DownloadData getMyDoc() {
        return getFuture();
    }

    public boolean checkDocNotNull() {
        return getFuture().getDoc() != null;
    }

    private DownloadData getFuture() {
        if (future.isDone()) {
            try {
                return future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return new DownloadData();
    }
}
