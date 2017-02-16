package Chapter8;

import Chapter10.AccessInterface;
import Chapter9.Interface1;

/**
 * Created by Ryan on 2017/2/5.
 */
public class Access extends AccessInterface {

    public Interface1 getInsideClass() {
        AccessInterface accessInterface = new AccessInterface();
        return accessInterface.new TestAccess();
    }

}
