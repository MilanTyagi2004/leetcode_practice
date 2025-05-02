class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Node head = root;
        while (head != null) {
            Node dummy = new Node(0);
            Node temp = dummy;

            while (head != null) {
                if (head.left != null) {
                    dummy.next = head.left;
                    dummy = dummy.next;
                }
                if (head.right != null) {
                    dummy.next = head.right;
                    dummy = dummy.next;
                }
                head = head.next;
            }
            head = temp.next;
        }
        return root;
    }
}