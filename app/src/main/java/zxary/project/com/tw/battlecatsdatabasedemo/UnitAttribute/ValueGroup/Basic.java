package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup;

import javax.inject.Inject;

public class Basic extends AbstractStat<BasicType, String, AbstractInfoValue<String>> {

    @Inject
    public Basic(final IValueFactory<BasicType, AbstractInfoValue<String>> valueFactory) {
        super(valueFactory, ".BasicValue");
    }
}
