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
        newNode.ogValue = i;
        // left and right will be null because this is the first node
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    // printing method
    public void printTree(Node node, String leftOrRight)
    {
        if (node == null)
        {
            return;
        }

        // prints value with placement (left or right of previous)
        System.out.println(leftOrRight + ": " + node.ogValue);

        // calls self, if left states this
        printTree(node.left, "left of previous");
        // calls self, if right states this
        printTree(node.right, "right of previous");
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
        System.out.println("Root value: " + 10);

        // left of 10
        root = tree1.insertVals(root, 8);
        System.out.println("Added: " + 8);
        // left of 8
        root = tree1.insertVals(root, 4);
        System.out.println("Added: " + 4);
        // left of 4
        root = tree1.insertVals(root, 2);
        System.out.println("Added: " + 2);
        // right of 6
        root = tree1.insertVals(root, 12);
        System.out.println("Added: " + 12);
        // right of 12
        root = tree1.insertVals(root, 24);
        System.out.println("Added: " + 24);
        // right of 0
        root = tree1.insertVals(root, 6);
        System.out.println("Added: " + 6);
        // left of 2
        root = tree1.insertVals(root, 0);
        System.out.println("Added: " + 0);

        System.out.println("\nBinary Search Tree:\n");

        // calls method to print tree
        System.out.print("Beginning value (root)");
        tree1.printTree(root, "");

        // Note: order of adding values does not matter, the  smallest value will go to the second least node and position itself to the left
    } // end main
} // end driver method