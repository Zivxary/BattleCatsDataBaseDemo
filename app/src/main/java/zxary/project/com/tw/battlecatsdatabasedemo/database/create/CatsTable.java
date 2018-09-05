package zxary.project.com.tw.battlecatsdatabasedemo.database.create;

import java.util.List;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.field.CatStatsField;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.field.FieldData;
import zxary.project.com.tw.battlecatsdatabasedemo.database.utility.StringRes;

public class CatsTable extends AbstractTable {
    
    @Override
    public String getTableName() {
        return StringRes.getCatTableName();
    }
    
    @Override
    protected List<FieldData> getFieldList() {
        return new CatStatsField().getFieldList();
    }
}
