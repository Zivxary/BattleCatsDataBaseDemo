package zxary.project.com.tw.battlecatsdatabasedemo.parse;

import android.graphics.Bitmap;

import org.jsoup.nodes.Document;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.dagger2.WebComponentHolder;

public class DownloadData {

    private int id;
    private Document doc;
    private Bitmap[] bitmaps;
    
    private SplitDocument splitDocument;
    
    public DownloadData() {
        WebComponentHolder.inject(this);
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(final Document document) {
        this.doc = document;
    }

    public Bitmap[] getBitmaps() {
        return bitmaps;
    }

    public void setBitmaps(final Bitmap[] bitmaps) {
        this.bitmaps = bitmaps;
    }
    
    public List<StatsData> toStatsData() {
        Document[] docArray = splitDocument.execute(doc);
        List<StatsData> list = new LinkedList<>();
        for (int i = 0; i < docArray.length; i++) {
            list.add(new StatsData(docArray[i], bitmaps[i]));
        }
        return list;
    }

    @Inject
    public void setSplitDocument(final SplitDocument splitDocument) {
        this.splitDocument = splitDocument;
    }
}
