package InnerClass10;

import Interface9.Interface1;

/**
 * Created by Ryan on 2017/2/5.
 */
public class AccessInterface {

    public class TestAccess implements Interface1 {

        @Override
        public void swim() {

        }

        @Override
        public void jump() {

        }

        public void test() {
            TestClass.see(new TestAccess());
        }

    }
}
