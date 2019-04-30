package src.thinkinginjava.Enum19;
import static src.thinkinginjava.Enum19.Signal.*;

/**
 * Created by Ryan on 2017/3/23.
 */
public class TrafficLight {
    Signal signal = RED;
    public void change() {
        switch (signal) {
            case GREEN:
                signal = RED;
                break;
            case RED:
                signal = YELLOW;
                break;
            case YELLOW:
                signal = GREEN;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + signal;
    }

    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight();
        for (int i = 0; i < 7 ; i++) {
            System.out.println(tl);
            tl.change();
        }
    }
}
