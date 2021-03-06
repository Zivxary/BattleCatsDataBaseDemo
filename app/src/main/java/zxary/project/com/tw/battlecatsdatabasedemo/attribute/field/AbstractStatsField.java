package zxary.project.com.tw.battlecatsdatabasedemo.attribute.field;

import java.util.LinkedList;
import java.util.List;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.BasicType;
import zxary.project.com.tw.battlecatsdatabasedemo.attribute.group.BattleType;

abstract class AbstractStatsField {
    
    public List<FieldData> getFieldList() {
        List<FieldData> list = new LinkedList<>();
        for (BasicType type : BasicType.values()) {
            list.add(new FieldData(type.name(), ValueType.TEXT));
        }
        for (BattleType type : BattleType.values()) {
            list.add(new FieldData(type.name(), ValueType.VALUE));
        }
        return list;
    }
}
