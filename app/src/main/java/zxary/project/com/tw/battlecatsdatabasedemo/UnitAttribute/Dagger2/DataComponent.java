package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Dagger2;

import dagger.Component;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Stats.AbstractStatCollection;

@Component(modules = {DataModule.class})
public interface DataComponent {
	void inject(AbstractStatCollection abstractStatCollection);
}
