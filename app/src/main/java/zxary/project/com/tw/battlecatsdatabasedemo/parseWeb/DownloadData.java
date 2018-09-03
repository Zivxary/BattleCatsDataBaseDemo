package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb;

import android.graphics.Bitmap;

import org.jsoup.nodes.Document;

import java.util.List;

import javax.inject.Inject;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.dagger2.WebComponentHolder;

public class DownloadData {

    private int id;
    private Document doc;
    private Bitmap[] bitmaps;

    private SplitCatWebData splitCatWebData;
    
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

    public void toStatsData(final List<StatsData> statsDataList) {
        Document[] docArray = splitCatWebData.execute(doc);
        for (int i = 0; i < docArray.length; i++) {
            statsDataList.add(new StatsData(docArray[i], bitmaps[i]));
        }
    }

    @Inject
    public void setSplitCatWebData(final SplitCatWebData splitCatWebData) {
        this.splitCatWebData = splitCatWebData;
    }
}
