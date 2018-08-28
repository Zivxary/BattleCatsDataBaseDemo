package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.StatsField;

public class FieldData {
	
	private String name;
	private ValueType type;
	
	public FieldData(String name, ValueType type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public ValueType getType() {
		return type;
	}
}