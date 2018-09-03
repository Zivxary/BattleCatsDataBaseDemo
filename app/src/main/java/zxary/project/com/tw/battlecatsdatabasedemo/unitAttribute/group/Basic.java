package zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.group;

import android.content.ContentValues;

import javax.inject.Inject;

public class Basic extends AbstractStat<BasicType, String, AbstractInfoValue<String>> {

    @Inject
    public Basic(final IValueFactory<BasicType, AbstractInfoValue<String>> valueFactory) {
        super(valueFactory, ".BasicValue");
    }
    
    @Override
    public void contentValuesPut(ContentValues cv, BasicType type) {
        cv.put(type.name(), get(type));
    }
}
