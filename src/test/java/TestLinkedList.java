public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(1);
        LinkedList<Integer> list2 = new LinkedList<>(2);

        //merge test
        for (int i = 0; i < 10; i += 2) {
            Node<Integer> newNode = new Node<>(i);
            list2.add(newNode);

        }

        for (int i = 0; i < 10; i++) {
            Node<Integer> newNode = new Node<>(i);
            list.add(newNode);

        }

        LinkedList<Integer> newList = mergeLists(list, list2);

        System.out.println(list);
        System.out.println(list2);
        System.out.println("new List that adds the previous two lists >" +newList);

        //truncatelist test
        newList.truncateList(6);

        System.out.println("Truncates everything after node 6 in new list > " + newList);

        //getParent test
        Node<Integer> newNode = new Node<>(6);
        Node<Integer> parent = list.getParent(newNode);
        newList.add(parent);
        System.out.println("Gets parent of node 6 and adds it ot the end of newList > " +newList);

    }

    public static <E> LinkedList<E> mergeLists(LinkedList<E> list1, LinkedList<E> list2) {
        Node<E> nodeList1 = list1.getFirst();
        Node<E> nodeList2 = list2.getFirst();
        LinkedList<E> newList = new LinkedList<>();
        while(nodeList1 != null || nodeList2 != null) {
            if(nodeList1 == null) {
                Node<E> temp2 = new Node<>(nodeList2.data);
                newList.add(temp2);
                nodeList2 = nodeList2.next;
            } else if(nodeList2 == null) {
                Node<E> temp1 = new Node<>(nodeList1.data);
                newList.add(temp1);
                nodeList1 = nodeList1.next;
            } else {
                Node temp1 = new Node<>(nodeList1.data);
                Node temp2 = new Node<>(nodeList2.data);
                newList.add(temp1);
                newList.add(temp2);
                nodeList1 = nodeList1.next;
                nodeList2 = nodeList2.next;

            }
        }

        return newList;
    }


}
