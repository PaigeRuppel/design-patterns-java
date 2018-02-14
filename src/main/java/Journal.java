import java.util.ArrayList;
import java.util.List;

public class Journal {

    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String entryContent) {
        entries.add("" + (++count) + ": " + entryContent);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

class Demo
{
    public static void main(String[] args) {
        Journal j = new Journal();
        j.addEntry("today was a good day");
        j.addEntry("today was the best day");

        System.out.println(j);
    }
}
