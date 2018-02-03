public class TestObj {
    private int ID;
    private String name;
    private int mark;

    public TestObj(int ID, String name, int mark) {
        this.ID = ID;
        this.name = name;
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObj testObj = (TestObj) o;

        if (mark != testObj.mark) return false;
        return name != null ? name.equals(testObj.name) : testObj.name == null;
    }

    @Override
    public int hashCode() {
        int result = mark;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
