package Chapter11;

import java.util.Queue;

/**
 * Created by Ryan on 2017/2/7.
 */
public class TestQueueResult {
    public static void main(String[] args) {
        TestQueue testQueue = new TestQueue();
        Queue<Command> commands = testQueue.fillCommand();
        commands.remove().operation();
        System.out.println(commands.size());
    }
}
