package Chapter9;

/**
 * Created by Ryan on 2017/2/4.
 */
public class TestStringAdapter implements Processor{
    TestString testString;
    public TestStringAdapter(TestString testString) {
        this.testString = testString;
    }

    @Override
    public String name() {
        return testString.name();
    }

    @Override
    public Object process(Object input) {
        return testString.process(input);
    }



    public void main(String[] args) {

    }
}
