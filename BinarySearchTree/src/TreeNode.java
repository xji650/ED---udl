public class TreeNode <T> {
    T element;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
