package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.stats;

import android.content.ContentValues;

public interface IStats {
    ContentValues toContentValue();
    
    String getUid();
    
    String getUidName();
}
