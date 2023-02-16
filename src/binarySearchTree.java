// tree is made of nodes, left and right nodes connect to original one
// value of left node is less than the parent, right value is greater than the parent
class Node
{
    int ogValue; // parent value
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

        // if the incoming value is less than the parent, then is belongs on the left
        if (newVal < node.ogValue)
        {
            node.left = insertVals(node.left, newVal); // recursion, calls itself to sort
        }
        // else if the incoming value is greater than the parent - moves the new node to the right
        else if (newVal > node.ogValue)
        {
            node.right = insertVals(node.right, newVal); // recursion, calls itself to sort
        }
        return node;
    } // end insertion method

    // create a new node with int value i
    public Node createNewNode (int i)
    {
        Node newNode = new Node ();
        // sets value to int that is passed in
        int ogValue = i;
        // left and right will be null because this is the first node
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

} // end sorting nodes method


// acts as driver class
public class binarySearchTree
{
    public static void main(String[] args)
    {
        nodeSorting tree1 = new nodeSorting();
        Node root = null;

        // creates new root with value of 10
        root = tree1.insertVals(root, 10);

        root = tree1.insertVals(root, 8);
        root = tree1.insertVals(root, 4);
        root = tree1.insertVals(root, 2);
        root = tree1.insertVals(root, 12);
    } // end main
} // end driver method