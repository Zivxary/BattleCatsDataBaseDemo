package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup;

import java.lang.reflect.ParameterizedType;
import java.util.EnumMap;
import java.util.Map;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;

public abstract class AbstractStat<K extends Enum<K>, T, V extends AbstractInfoValue<T>> {

    private Map<K, V> map;

    @SuppressWarnings("unchecked")
    public AbstractStat() {
        Class<K> enumClass =
                (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        map = new EnumMap<>(enumClass);
    }

    protected void mapPut(K type, V infoValue) {
        map.put(type, infoValue);
    }

    public T get(K type) {
        return map.get(type).get();
    }

    protected void setValue(K type, final StatsData data) {
        if (map.containsKey(type)) {
            map.get(type).setValue(data);
        }
    }

    public abstract void setAll(StatsData data);

}
