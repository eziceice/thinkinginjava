package Polymorphism8;

import InnerClass10.AccessInterface;
import Interface9.Interface1;

/**
 * Created by Ryan on 2017/2/5.
 */
public class Access extends AccessInterface {

    public Interface1 getInsideClass() {
        AccessInterface accessInterface = new AccessInterface();
        return accessInterface.new TestAccess();
    }

}
