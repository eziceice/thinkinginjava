package Chapter15;

/**
 * Created by Ryan on 2017/2/16.
 */
public class LinkedStack<T> {

    private class Node<T> {
        T item;
        Node<T> next;
        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }


        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item){
        top = new Node(item, top);
    }

    public T pop(){
        T result = top.item;
        if(!top.end())
            top = top.next;
        return result;
    }


    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("this");
        linkedStack.push("is");
        linkedStack.push("a test");
        String s;
        while ((s = linkedStack.pop()) != null)
            System.out.println(s);
    }
}
