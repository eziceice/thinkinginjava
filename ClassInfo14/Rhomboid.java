package ClassInfo14;

import java.lang.reflect.Field;

/**
 * Created by Ryan on 2017/2/14.
 */
public class Rhomboid extends Shape {
    private String i;
    private int a;

    public static void main(String[] args) {
        Shape[] shapes = {new Rhomboid(), new Circle(), new Rhomboid(), new Circle(), new Circle()};
        /**
        if(shapes[0] instanceof Circle) {
            System.out.println("true");
        }
        if(shapes[0] instanceof Rhomboid) {
            System.out.println("false");
        }
         */

        Field[] f = Rhomboid.class.getDeclaredFields();
        System.out.println(f.length);
        System.out.println(f[0] + " " + f[1]);


        //new Rhomboid().rotate(shapes[0]);

        for (Shape s: shapes
             ) {
            new Rhomboid().mark(s);
        }




    }


    public void mark(Shape s) {
        if(s instanceof Circle) {
            System.out.println("mark");
        }
    }


    public void rotate(Shape s) {
        if(s instanceof Circle) {
            System.out.println("rotate");
        }
        if(s instanceof Rhomboid) {
            System.out.println("stop");
        }
    }
}
