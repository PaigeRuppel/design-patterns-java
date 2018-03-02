package com.paigeruppel.udemy.designpatterns.structural.bridge;

public class BridgeCodeExercise {
    public static void main(String[] args) {
        Comic newspaperGarfield = new Garfield(new NewspaperRenderer());
        Comic tvGarfield = new Garfield(new TvRenderer());
        Comic newspaperPeanuts = new Peanuts(new NewspaperRenderer());
        Comic tvPeanuts = new Peanuts(new TvRenderer());

        System.out.println(newspaperGarfield);
        System.out.println(tvGarfield);
        System.out.println(newspaperPeanuts);
        System.out.println(tvPeanuts);
    }
}

abstract class Comic {
    private MediaRenderer renderer;
    public String name;

    public Comic(MediaRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public String toString() {
        return String.format("Showing %s in %s form", name, renderer.whatToRenderAs());
    }

}

class Garfield extends Comic {

    public Garfield(MediaRenderer renderer) {
        super(renderer);
        name = "Garfield";
    }
}

class Peanuts extends Comic {

    public Peanuts(MediaRenderer renderer) {
        super(renderer);
        name = "Peanuts";
    }
}

interface MediaRenderer {
    public String whatToRenderAs();
}

class TvRenderer implements MediaRenderer {

    @Override
    public String whatToRenderAs() {
        return "T.V.";
    }
}

class NewspaperRenderer implements MediaRenderer {

    @Override
    public String whatToRenderAs() {
        return "Newspaper";
    }
}

