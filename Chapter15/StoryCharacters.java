package Chapter15;

/**
 * Created by Ryan on 2017/2/16.
 */
public class StoryCharacters {
    private static int count = 0;
    private final int id = count++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

}
