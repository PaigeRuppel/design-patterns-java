package com.paigeruppel.udemy.designpatterns.creational;

public class FacetedBuilderDemo {
    public static void main(String[] args) {
        HumanBuilder humanBuilder = new HumanBuilder();
        Human human = humanBuilder
                .lives()
                    .at("123 Abc Lane")
                    .in("Malibu")
                    .withPostCode("99999")
                .works()
                    .forCompany("MGM")
                    .as("Director")
                    .makes(100000000)
                .build();
        System.out.println(human);
    }
}


class Human {

    //address
    public String streetAddress;
    public String postcode;
    public String city;
    //employment
    public String companyName, position;
    public int annualIncome;

    public final String space = " ";
    public final String newLine = "\n";
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address Information: ").append(streetAddress).append(space).append(city).append(space).append(postcode).append(newLine);
        sb.append("Employment Information: ").append(companyName).append(space).append(position).append(space).append("Salary: ").append(annualIncome);
        return sb.toString();
    }

}

// builder facade - combination of two design patterns
class HumanBuilder {
    protected Human human = new Human();

    public Human build() {
        return human;
    }

    public HumanAddressBuilder lives() {
        return new HumanAddressBuilder(human);
    }

    public HumanJobBuilder works() {
        return new HumanJobBuilder(human);
    }

}


//subclasses have to inherit from base class because this exposes the works and lives methods and allows you to switch between subbuilders
class HumanAddressBuilder extends HumanBuilder {
    public HumanAddressBuilder(Human human) {
        this.human = human;
    }

    public HumanAddressBuilder at(String streetAddress) {
        human.streetAddress = streetAddress;
        return this;
    }

    public HumanAddressBuilder withPostCode(String postCode) {
        human.postcode = postCode;
        return this;
    }

    public HumanAddressBuilder in(String city) {
        human.city = city;
        return this;
    }
}

class HumanJobBuilder extends HumanBuilder {
    public HumanJobBuilder(Human human) {
        this.human = human;
    }

    public HumanJobBuilder forCompany(String company) {
        human.companyName = company;
        return this;
    }

    public HumanJobBuilder as(String position) {
        human.position = position;
        return this;
    }

    public HumanJobBuilder makes(int annualIncome) {
        human.annualIncome = annualIncome;
        return this;
    }
}