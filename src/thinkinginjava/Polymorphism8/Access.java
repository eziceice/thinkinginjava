package src.thinkinginjava.Polymorphism8;

import src.thinkinginjava.InnerClass10.AccessInterface;
import src.thinkinginjava.Interface9.Interface1;

/**
 * Created by Ryan on 2017/2/5.
 */
public class Access extends AccessInterface {

    public Interface1 getInsideClass() {
        AccessInterface accessInterface = new AccessInterface();
        return accessInterface.new TestAccess();
    }

}
