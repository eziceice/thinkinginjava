package Generics15;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Ryan on 2017/2/16.
 */
public class StoryCharactersGenerator implements Generator<StoryCharacters>, Iterable<StoryCharacters> {
    private static Class[] storyCharacters = {A.class,B.class,Batman.class,IronMan.class};
    private Random random = new Random(47);
    private int size = 0;

    public StoryCharactersGenerator(int size) {
        this.size = size;
    }

    @Override
    public StoryCharacters next() {
        try {
            return (StoryCharacters) storyCharacters[random.nextInt(storyCharacters.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterator<StoryCharacters> iterator() {
        return new Iterator<StoryCharacters>() {
            int count = size;
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public StoryCharacters next() {
                count--;
                return StoryCharactersGenerator.this.next();
            }
        };
    }


    public static void main(String[] args) {
        StoryCharactersGenerator sc = new StoryCharactersGenerator(20);
        for (StoryCharacters s: sc) {
            System.out.println(s);
        }
    }
}
