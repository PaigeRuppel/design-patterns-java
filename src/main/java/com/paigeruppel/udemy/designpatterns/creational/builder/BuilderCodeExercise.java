package com.paigeruppel.udemy.designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class BuilderCodeExercise {
    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person").addField("name", "String").addField("age","int");
        System.out.println(codeBuilder);
    }
}


class Field {
    protected String name;
    protected String type;

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("public %s %s", type, name);
    }

}

class Class {
    protected String name;
    protected List<Field> fieldList = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        sb.append("public class " + name).append(newLine);
        sb.append("{").append(newLine);
        for (Field field: fieldList) {
            sb.append("  " + field).append(newLine);
        }
        sb.append("}");
        return sb.toString();
    }
}


class CodeBuilder {
    private Class theClass = new Class();

    public CodeBuilder(String className) {
        theClass.name = className;
    }

    public CodeBuilder addField(String name, String type) {
        theClass.fieldList.add(new Field(name, type));
        return this;
    }

    @Override
    public String toString() {
        return theClass.toString();
    }
}
