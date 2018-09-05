package zxary.project.com.tw.battlecatsdatabasedemo.attribute.stats;

import android.content.ContentValues;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

public class CatStatCollection extends AbstractStatCollection {

    public int rarity;
    public int max_level;
    public int max_bonus_level;
    public int custom_level;
    public int custom_bonus_level;
    
    public CatStatCollection(final StatsData data) {
        super(data);
    }
    
    @Override
    public ContentValues toContentValue() {
        //TODO
        return super.toContentValue();
    }
}
