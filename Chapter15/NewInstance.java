package Chapter15;

/**
 * Created by Ryan on 2017/2/17.
 */
public class NewInstance<T> {
    private T t;
    private Class<T> kind;

    public NewInstance(Class<T> kind) {
        this.kind = kind;

        try {
            newT(kind);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    public void newT(Class<T> kind) throws IllegalAccessException, InstantiationException {
        t = kind.newInstance();
    }
}
