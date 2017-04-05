package Enum19;

import Generics15.Generator;

import java.util.Random;

/**
 * Created by Ryan on 2017/3/23.
 */
public enum EnumCartoon implements Generator<EnumCartoon> {
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
    private Random random = new Random(47);
    public EnumCartoon next() {
        return values()[random.nextInt(values().length)];
    }


    public static void main(String[] args) {
        EnumCartoon enumCartoon = SILLY;
        Enum e = EnumCartoon.BOB;
        System.out.println(e.getClass().getEnumConstants().length);
        for (int i = 0; i < 10; i++) {
            System.out.println(enumCartoon.next());
        }
    }
}
