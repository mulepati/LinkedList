public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(1);
        LinkedList<Integer> list2 = new LinkedList<>(2);
        Node<Integer> stuff = new Node<>(1);

        list.add(stuff);
        System.out.println(list.exists(stuff));
        System.out.println(list.equals(list2));

        System.out.println(list);
    }
}
