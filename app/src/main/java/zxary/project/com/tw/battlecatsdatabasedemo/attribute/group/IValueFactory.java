package zxary.project.com.tw.battlecatsdatabasedemo.attribute.group;

public interface IValueFactory<E extends Enum, V extends AbstractInfoValue> {

    void setPath(String path);

    V create(E type);
}
