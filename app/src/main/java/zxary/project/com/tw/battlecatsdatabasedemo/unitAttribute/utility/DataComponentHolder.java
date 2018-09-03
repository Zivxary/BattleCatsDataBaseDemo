package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.utility;

import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.stats.AbstractStatCollection;

public class DataComponentHolder {

    private static DataComponent dataComponent =
            DaggerDataComponent.builder().build();
    
    public static void inject(final AbstractStatCollection abstractStatCollection) {
        dataComponent.inject(abstractStatCollection);
    }
}
