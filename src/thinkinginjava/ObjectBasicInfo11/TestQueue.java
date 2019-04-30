package src.thinkinginjava.ObjectBasicInfo11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ryan on 2017/2/7.
 */
public class TestQueue {

    private Queue<Command> queue = new LinkedList<>();

    public Queue<Command> fillCommand() {
        Command command = new Command();
        queue.offer(command);
        return queue;
    }
}
