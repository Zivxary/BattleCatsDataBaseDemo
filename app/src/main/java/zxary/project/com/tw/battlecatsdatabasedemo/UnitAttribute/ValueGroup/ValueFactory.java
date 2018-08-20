package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.ValueGroup;

public class ValueFactory<E extends Enum, V extends AbstractInfoValue> implements IValueFactory<E, V> {

    private String classPath;

    @Override
    public void setPath(final String path) {
        classPath = path;
    }

    public V create(final E type) {
        String path = classPath + "." + type.name();
        return createNew(path);
    }

    @SuppressWarnings("unchecked")
    private V createNew(final String className) {
        try {
            return (V) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
