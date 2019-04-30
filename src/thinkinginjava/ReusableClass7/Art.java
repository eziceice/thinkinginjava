package src.thinkinginjava.ReusableClass7;

public class Art extends Cartoon{


    @Override
    public void right(int s) {
        System.out.println(s);
        if(s == 0.25) {

        }
    }


    public static void main(String[] args) {
        Art art = new Art();
        art.right("s");
        art.right('S');
        art.right(25);
        art.right(1);
    }
}


