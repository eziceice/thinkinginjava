package Enum19;

import java.util.EnumSet;
import java.util.Random;

/**
 * Created by Ryan on 2017/3/23.
 */
public enum EnumsAndArrays {
    A(TestEnum.E.class),
    B(TestEnum.F.class),
    C(TestEnum.G.class);
    private TestEnum[] testEnums;
    private Random random = new Random(47);
    interface TestEnum {
        enum E implements TestEnum {}
        enum F implements TestEnum {}
        enum G implements TestEnum {}
    }

    private EnumsAndArrays(Class<? extends TestEnum> t) {
       testEnums = t.getEnumConstants();
    }

    public TestEnum randomSelection() {
        return Enums.random(testEnums);
    }


    public static void main(String[] args) {
        EnumSet<EnumsAndArrays> enumsAndArrayss = EnumSet.allOf(EnumsAndArrays.class);
    }
}
