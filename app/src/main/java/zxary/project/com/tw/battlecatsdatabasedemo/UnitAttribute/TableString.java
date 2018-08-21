package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute;

public class TableString {

    private String name;
    private Type type;

    TableString(final String name, final Type type) {
        this.name = name;
        this.type = type;
    }

    public String get() {
        return name + type.getSet();
    }

    enum Type {
        Text(" TEXT DEFAULT ''"),
        Value(" INTEGER DEFAULT 0");

        private String set;

        Type(String str) {
            set = str;
        }

        public String getSet() {
            return set;
        }
    }
}
