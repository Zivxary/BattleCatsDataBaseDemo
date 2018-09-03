package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.utility;

import dagger.Component;
import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.stats.AbstractStatCollection;

@Component(modules = {DataModule.class})
public interface DataComponent {
    void inject(AbstractStatCollection abstractStatCollection);
}
