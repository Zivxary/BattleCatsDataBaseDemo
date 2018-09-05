package zxary.project.com.tw.battlecatsdatabasedemo.attribute.utility;

import dagger.Component;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.stats.AbstractStatCollection;

@Component(modules = {DataModule.class})
public interface DataComponent {
    void inject(AbstractStatCollection abstractStatCollection);
}
