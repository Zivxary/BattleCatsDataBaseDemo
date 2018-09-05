package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group;

import zxary.project.com.tw.battlecatsdatabasedemo.parse.StatsData;

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
