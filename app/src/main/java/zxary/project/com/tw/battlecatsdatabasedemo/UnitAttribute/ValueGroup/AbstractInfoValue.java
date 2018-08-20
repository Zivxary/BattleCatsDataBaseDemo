package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;

public abstract class AbstractInfoValue<T> {

    private T infoValue;

    public void set(T value) {
        infoValue = value;
    }

    public T get() {
        return infoValue;
    }

    public abstract void setValue(StatsData data);
}
