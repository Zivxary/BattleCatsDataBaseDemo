package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb;

import android.graphics.Bitmap;

import org.jsoup.nodes.Document;

import java.util.List;

public class StatsData {
    
    private Document doc;
    private Bitmap bitmap;
    private List<String> characteristic;
    
    public StatsData() {
    }
    
    public StatsData(final Document doc, final Bitmap bitmap) {
        this.doc = doc;
        this.bitmap = bitmap;
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
