import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Medicine {
    private String name;
    private String pharm;
    private String group;
    private List<String> analogs;
    private List<String> versions;

    public Medicine() {
        analogs = new ArrayList<>();
        versions = new ArrayList<>();
    }

    // Геттеры и сеттеры для полей класса

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getAnalogs() {
        return analogs;
    }

    public void addAnalog(String analog) {
        analogs.add(analog);
    }

    public List<String> getVersions() {
        return versions;
    }

    public void addVersion(String version) {
        versions.add(version);
    }

    // Реализация интерфейса Comparator для сортировки объектов Medicine по имени

    public static class NameComparator implements Comparator<Medicine> {
        @Override
        public int compare(Medicine m1, Medicine m2) {
            return m1.getName().compareTo(m2.getName());
        }
    }
}
