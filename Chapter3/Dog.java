package Chapter3;

/**
 * Created by Ryan on 2017/1/17.
 */
public class Dog {

    private String name;
    private String says;


    public Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }


    //@Override
    public boolean equals(Dog dog) {
        if(dog.name.equals(this.name) && dog.says.equals(this.says)) {
            return true;
        } else {
            return false;
        }
    }




    public static void main(String[] args) {

        Dog d1 = new Dog("spot", "Ruff!");
        Dog d2 = new Dog("scruffy", "Wurf!");
        Dog d3 = new Dog("spot", "Ruff!");

        System.out.println(d1 == d3);
        System.out.println(d1.equals(d3));


        if(d1.equals(d3)) {
            return;
        } else {
            System.out.print("test");
        }

    }
}
