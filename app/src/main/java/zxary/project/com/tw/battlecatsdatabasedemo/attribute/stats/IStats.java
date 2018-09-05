package zxary.project.com.tw.battlecatsdatabasedemo.attribute.stats;

import android.content.ContentValues;

public interface IStats {
    ContentValues toContentValue();
    
    String getUid();
    
    String getUidName();
}
