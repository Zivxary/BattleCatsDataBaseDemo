package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb;

import android.graphics.Bitmap;

import org.jsoup.nodes.Document;

import java.util.List;

public class StatsData {

    private int id;
    private Document doc;
    private Bitmap bitmap;
    private List<String> characteristic;

    public StatsData() {
    }

    public StatsData(final int id, final Document doc, final Bitmap bitmap) {
        this.id = id;
        this.doc = doc;
        this.bitmap = bitmap;
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

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(final Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public List<String> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(final List<String> characteristic) {
        this.characteristic = characteristic;
    }
}
