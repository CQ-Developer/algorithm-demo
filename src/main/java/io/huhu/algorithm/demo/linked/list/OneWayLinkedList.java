package io.huhu.algorithm.demo.linked.list;

/**
 * 单向链表
 *
 * <ol>
 *     <li>单链表反转</li>
 *     <li>链表中环的检测</li>
 *     <li>两个有序的链表合并</li>
 *     <li>删除链表倒数第K个节点</li>
 *     <li>需要链表的中间节点</li>
 * </ol>
 */
public class OneWayLinkedList<T> {

    /**
     * 链表的头节点
     */
    private final Node<T> head = new Node<>(null);

    public void addFirst(T data) {

    }

    private void addLast(T data) {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> current = this.head;
        while (current.next != null) {
            stringBuilder.append(current.next.data.toString());
            stringBuilder.append(", ");
            current = current.next;
        }
        stringBuilder.delete(stringBuilder.lastIndexOf(","), stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static class Node<T> {

        private final T data;

        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public Node<T> getNext() {
            return this.next;
        }

    }

}
