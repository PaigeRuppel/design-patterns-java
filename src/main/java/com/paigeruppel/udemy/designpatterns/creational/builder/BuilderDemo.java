package com.paigeruppel.udemy.designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuilderDemo {

    public static void main(String[] args) {
        String hello = "hello";
        System.out.println("<p>" + hello + "</p>");

        List<String> words = Arrays.asList("hello", "world");
        // what if you want to print out a list as a ul in html? It quickly becomes complicated
//        System.out.println(
//                "<ul>\n" + "<li>" + "</li>"+ "</ul>"
//        );

        // StringBuilder is a built in example of the builder pattern
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ul>\n");
        for  (String word : words) {
            stringBuilder.append(String.format("  <li>%s</li>\n", word));
        }
        stringBuilder.append("</ul>");
        System.out.println(stringBuilder);


        // Using HTML Builder

        HtmlBuilder htmlBuilder = new HtmlBuilder("ul");
        htmlBuilder.addChild("li", "hello").addChild("li", "world");
        System.out.println(htmlBuilder);

        // Fluent Interface
        StringBuilder sb = new StringBuilder();
        // sb.append() returns a reference to an instance of String Builder
        // this allows you to chain methods - i.e. a fluent interface
        sb.append("foo").append("bar"); // and so on
        // this is in direct contrast to our htmlBuilder - see above - addChild methods must be executed on separate lines
    }

}
class HtmlElement {
    private String name;
    private String text;
    protected ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {

    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        stringBuilder.append(String.format("%s<%s>%s", i, name, newLine));
        if (text != null && !text.isEmpty()) {
            stringBuilder.append(String.join("", Collections.nCopies(indentSize*(indent+1), " ")))
                    .append(text)
                    .append(newLine);
        }

        for (HtmlElement e : elements) {
            stringBuilder.append(e.toStringImpl(indent + 1));
        }

        stringBuilder.append(String.format("%s</%s>%s", i, name, newLine));

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.setName(rootName);
    }

    // this is the non-fluent implementation of addChild
    /*public void addChild(String childName, String childText) {
        HtmlElement htmlElement = new HtmlElement(childName, childText);
        root.elements.add(htmlElement);
    }*/

    //By returning HtmlBuilder and returning this, it converts this to a fluent interface
    public HtmlBuilder addChild(String childName, String childText) {
        HtmlElement htmlElement = new HtmlElement(childName, childText);
        root.elements.add(htmlElement);
        return this;
    }

    public void clear() {
        root = new HtmlElement();
        root.setName(rootName);
    }

    //Builder must have a method that returns the final object
    @Override
    public String toString() {
        return root.toString();
    }
}
