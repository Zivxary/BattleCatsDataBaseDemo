package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Dagger2;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Stats.AbstractStatCollection;

public class DataComponentHolder {

    private static DataComponent dataComponent =
            DaggerDataComponent.builder().build();
	
	public static void inject(final AbstractStatCollection abstractStatCollection) {
		dataComponent.inject(abstractStatCollection);
    }
}
