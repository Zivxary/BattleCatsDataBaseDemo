package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Dagger2.WebComponentHolder;
import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.DownloadData;

public class GetCatData implements Callable<DownloadData> {

    private int catId;
    private WebCatDocument doc;
    private WebCatImage image;

    public GetCatData(final int id) {
        catId = id;
        WebComponentHolder.inject(this);
    }

    @Inject
    public void set(final WebCatDocument webCatDocument, final WebCatImage webCatImage) {
        doc = webCatDocument;
        image = webCatImage;
    }

    @Override
    public DownloadData call() {
        DownloadData myDoc = new DownloadData();
        myDoc.setId(catId);
        myDoc.setDoc(doc.get(catId));
        myDoc.setBitmaps(image.get(catId));
        return myDoc;
    }
}
