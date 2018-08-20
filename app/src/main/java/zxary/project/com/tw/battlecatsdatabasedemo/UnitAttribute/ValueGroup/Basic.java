package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup.BasicValue.Uid;

public class Basic extends AbstractStat<BasicType, String, AbstractInfoValue<String>> {

    public Basic() {
        mapPut(BasicType.Uid, new Uid());
    }

    @Override
    public void setAll(final StatsData data) {
        setValue(BasicType.Uid, data);
    }
}
