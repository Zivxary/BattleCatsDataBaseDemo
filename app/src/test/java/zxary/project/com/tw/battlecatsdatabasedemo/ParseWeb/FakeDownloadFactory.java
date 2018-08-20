package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class FakeDownloadFactory implements IDownloadFactory {

    private Set<Integer> idSet;

    public FakeDownloadFactory(final Integer[] ids) {
        this.idSet = new HashSet<>(ids.length);
        Collections.addAll(idSet,  ids);
    }

    @Override
    public Callable<DownloadData> create(final int id) {
        return new FakeDownloadData(id, idSet.contains(id));
    }

    private class FakeDownloadData implements Callable<DownloadData> {

        private int id;
        private boolean needDoc;

        FakeDownloadData(final int id, final boolean needDoc) {
            this.id = id;
            this.needDoc = needDoc;
        }

        @Override
        public DownloadData call() throws Exception {
            Thread.sleep((int) (Math.random() * 5 + 3));
            return buildMyDoc();
        }

        private DownloadData buildMyDoc() {
            DownloadData downloadData = new DownloadData();
            downloadData.setId(id);
            if (needDoc) {
                downloadData.setDoc(new FakeDocument(""));
            }
            return downloadData;
        }
    }
}
