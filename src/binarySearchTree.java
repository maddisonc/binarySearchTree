// tree is made of nodes, left and right nodes connect to original one
// value of left node is less than the parent, right value is greater than the parent
class Node
{
    int ogValue;
    Node left;
    Node right;
} // end node class

// method that will sort the new nodes based on value (place left or right below parent)
class nodeSorting
{
    public Node insertVals (Node node, int newVal)
    {
        if (node == null)
        {
            // write method that creates a new node with value passed in
            return createNewNode(newVal);
        }
    } // end insertion method
} // end sorting nodes method


// acts as driver class
public class binarySearchTree
{
    public static void main(String[] args)
    {
        nodeSorting tree1 = new nodeSorting();
        Node root = null;

        // creates new root with value of 10
        tree1.insertVals(root, 10);
    } // end main
} // end driver method