package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Dagger2;

import dagger.Component;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.AbstractStats;

@Component(modules = {DataModule.class})
public interface DataComponent {
    void inject(AbstractStats abstractStats);
}
