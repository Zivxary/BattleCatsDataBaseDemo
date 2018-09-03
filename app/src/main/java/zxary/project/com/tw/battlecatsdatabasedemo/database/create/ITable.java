package zxary.project.com.tw.battlecatsdatabasedemo.database.create;

public interface ITable {
    String name = "default";
    
    String getTableName();
    
    String getCreateTableSQL();
}
