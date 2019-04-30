package src.thinkinginjava.Generics15;

/**
 * Created by Ryan on 2017/2/20.
 */
public class Coffee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        Coffee coffee = new Suger(new Milk(new Coffee()));
        Suger suger = new Suger(new Milk(new Coffee()));
    }
}

class Decorator extends Coffee {
    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getCoffee() {
        return coffee.getName();
    }

    public void setCoffee(String name) {
        coffee.setName(name);
    }
}

class Milk extends Decorator {
    private String milkName;

    public Milk(Coffee coffee) {
        super(coffee);
    }

    public void addMilk(){
        System.out.println("Add Milk");
    }
}

class Suger extends Decorator {

    public Suger(Coffee coffee) {
        super(coffee);
    }

    public void addSuger() {
        System.out.println("Add Suger");
    }
}
