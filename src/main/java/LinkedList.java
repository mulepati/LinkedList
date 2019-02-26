import java.util.NoSuchElementException;

public class LinkedList<E> {
    private Node<E> first;

    public LinkedList(E val) {
        this.first = new Node<>(val);
    }

    public void add(Node<E> node) {
        if(first == null) {
            first = node;
        } else{
            Node<E> lastNode = getLastNode();
            lastNode.next = node;
        }
    }

    public void add(Node<E> node, int index) {
        Node<E> current = first;
        int indexNode = 0;
        while(indexNode != index) {
            if(current == null || current.next == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
            indexNode++;
        }
        node.next = current;
        current = node;

    }

    public void remove(Node<E> node) {
        if(first == null) {
            throw new NoSuchElementException();
        } else if(first == node) {
            if(first.next != null) {
                first = first.next;
            } else {
                first = null;
            }
        }
        Node<E> current = first;
        while(current != null) {
            if(current.next.next != null) {
                if(current.next == node) {
                    current.next = current.next.next;

                }
            } else {
                if(current.next == node) {
                    current.next = null;
                }
            }
            current = current.next;
        }
    }

    public boolean exists(Node<E> node) {
        Node<E> current = first;
        while(current != null) {
            if(current.equals(node)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean equals(LinkedList<E> list) {
        Node<E> current = first;
        Node<E> currentList = list.getFirst();
        while(currentList != null && current != null) {
            if(!currentList.equals(current)) {
                return false;
            }
            currentList = currentList.next;
            current = current.next;
        }

        return false;
    }

    public Node getFirst() {
        return first;
    }

    private Node getLastNode(){
        if(first == null){
            return first;
        } else {
            Node<E> current = first;
            while(current.next != null) {
                current = current.next;
            }
            return current;
        }
    }

    public String toString() {
        Node<E> current = first;
        StringBuilder print = new StringBuilder();
        while(current != null) {
            print.append(current.data + " ");
            current = current.next;
        }
        return print.toString();
    }


}
