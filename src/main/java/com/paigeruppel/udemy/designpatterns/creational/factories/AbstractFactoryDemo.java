package com.paigeruppel.udemy.designpatterns.creational.factories;

public class AbstractFactoryDemo {
    public static void main(String[] args) {

        HotDrinkMachine mach1 = new HotDrinkMachine("coffee");
        HotDrinkMachine mach2 = new HotDrinkMachine("tea");

        System.out.println(mach1.makeDrink(8));
        System.out.println(mach2.makeDrink(10));
    }
}

// makes a correspondence between the hierarchy of objects and the hierarchy of factories you have to construct those objects

interface HotDrink {
    void consume();
}

class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This tea is delicious");
    }
}


class Coffee implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This coffee is delicious");
    }
}

interface HotDrinkFactory {
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put in tea bag, boil water, pour " + amount + " mL, add lemon, enjoy!");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Add ground beans to press, boil water, pour " + amount + " mL over grounds, steep, press, enjoy!");
        return new Coffee();
    }
}


// My abstract factory differs significantly from the solution provided in the tutorial - i did not use the Reflections API
// This solution is less sophisticated - see the tutorial for the full implementation with Reflections
class HotDrinkMachine {
    private HotDrinkFactory drinkFactory = null;
    public HotDrinkMachine(String drink) {
        if(drink.equalsIgnoreCase("COFFEE")){
            drinkFactory  = new CoffeeFactory();
        } else {
            drinkFactory = new TeaFactory();
        }
    }

    public HotDrink makeDrink(int amount) {
        return drinkFactory.prepare(amount);
    }

}