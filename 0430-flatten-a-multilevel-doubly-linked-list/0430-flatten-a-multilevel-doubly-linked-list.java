
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node current = head;

        while (current != null || !stack.isEmpty()) {
            if (current.child != null) {
                if (current.next != null) {
                    stack.push(current.next);
                }
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }

            if (current.next == null && !stack.isEmpty()) {
                Node nextNode = stack.pop();
                current.next = nextNode;
                nextNode.prev = current;
            }

            current = current.next;
        }

        return head;
    }
}
