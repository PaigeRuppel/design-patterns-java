import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
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

    // as we add additional methods regarding persistence, we are adding concerns/responsibilities
    public void save(String filename) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }

    public void load(String filename) {}

    public void load(URL url) {}
}

class Persistence {

}

class Demo
{
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("today was a good day");
        j.addEntry("today was the best day");

        System.out.println(j);
    }
}
