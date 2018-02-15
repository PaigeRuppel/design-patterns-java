package com.paigeruppel.udemy.solid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SingleResponsibilityExample {

    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("today was a good day");
        j.addEntry("today was the best day");

        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "c:\\temp\\journal.txt";
        p.saveToFile(j, filename, true);

        Runtime.getRuntime().exec("notepad.exe " + filename);
    }

}

class Journal {
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

class Persistence {

    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }
    public Journal load(String filename) {
        return new Journal();
    }

    public Journal load(URL url) {
        return new Journal();
    }
}

