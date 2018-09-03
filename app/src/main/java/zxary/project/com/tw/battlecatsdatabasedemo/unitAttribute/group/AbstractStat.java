package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group;

import android.content.ContentValues;

import java.lang.reflect.ParameterizedType;
import java.util.EnumMap;
import java.util.Map;

import zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.StatsData;

abstract class AbstractStat<K extends Enum<K>, T, V extends AbstractInfoValue<T>> {

    private Map<K, V> map;
    private Class<K> enumClass = getEnumClass();

    AbstractStat(final IValueFactory<K, V> valueFactory, final String path) {
        valueFactory.setPath(getClass().getPackage().getName() + path);
        map = new EnumMap<>(enumClass);
        for (K type : enumClass.getEnumConstants()) {
            map.put(type, valueFactory.create(type));
        }
    }

    @SuppressWarnings("unchecked")
    private Class<K> getEnumClass() {
        return (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public T get(K type) {
        return map.get(type).get();
    }

    public void setAll(final StatsData data) {
        for (K type : map.keySet()) {
            setValue(type, data);
        }
    }

    private void setValue(K type, final StatsData data) {
        if (map.containsKey(type)) {
            map.get(type).setValue(data);
        }
    }
    
    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();
        for (K type : enumClass.getEnumConstants()) {
            contentValuesPut(cv, type);
        }
        return cv;
    }
    
    public abstract void contentValuesPut(ContentValues cv, K type);
}
