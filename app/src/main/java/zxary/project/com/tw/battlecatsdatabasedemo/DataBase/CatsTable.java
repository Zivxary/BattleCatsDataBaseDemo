package zxary.project.com.tw.battlecatsdatabasedemo.DataBase;

import java.util.List;

import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.StatsField.CatStatsField;
import zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.StatsField.FieldData;

public class CatsTable extends AbstractTable {
	
	public CatsTable() {
		tableName = CatTableDAO.getTableName();
	}
	
	@Override
	protected List<FieldData> getFieldList() {
		return new CatStatsField().getFieldList();
	}
}
