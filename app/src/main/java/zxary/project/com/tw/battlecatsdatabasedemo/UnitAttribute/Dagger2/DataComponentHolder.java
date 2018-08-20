package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Dagger2;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.AbstractStats;

public class DataComponentHolder {

    private static DataComponent dataComponent =
            DaggerDataComponent.builder().build();

    public static void inject(final AbstractStats abstractStats){
        dataComponent.inject(abstractStats);
    }
}
