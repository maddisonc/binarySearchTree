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

    // method to delete a node
    public Node deleteNode (Node node, int delVal)
    {
        if (node == null)
        {
            return node;
        } // end if null

        // goes through the entire tree to find the value for deletion
        // if we are deleting the node that is less than the previous one, it is on the left
        // calls itself, finds the node on the left, and deletes it
        if (delVal < node.ogValue)
        {
            node.left = deleteNode(node.left, delVal);
        } // end if less
        // else if greater, delete right node
        else if (delVal > node.ogValue)
        {
            node.right = deleteNode(node.right, delVal);
        } // end else if greater
        else
        {
            // if either node (or both) are null
            if (node.left == null || node.right == null)
            {
                // is the left node null?
                // if yes, then the temp is set to the right node
                // if no, (the left node is not null) the temp is set to the left node
                Node temp = node.left == null ? node.right : node.left;

                // if temp is null, there are no more nodes attached, and we can delete this node
                if (temp == null)
                {
                    return null;
                } // end if null
                // if not null then there is another node attached
                else
                {
                    return temp;
                } // end else
            } // end outer if

            // when we have identified the node to be deleted
            else
            {
                Node successor = getSuccessor(node);
                node.ogValue = successor.ogValue;
                // deletes the value and sets the last node to the previous (successor value)
                node.right = deleteNode(node.right, successor.ogValue);
                return node;
            } // end inner else
        } // end outer else
        return node;
    } // end deleteNode method

    // method to get node before the node (successor) we want to delete
    public Node getSuccessor (Node node)
    {
        if (node == null)
        {
            return null;
        } // end if null
        // temp gets the node to the right
        Node temp = node.right;
        // when there is a successor
        while (temp.left != null)
        {
            temp = temp.left;
        } // end while there are nodes on the left
        return temp;
    } // end getSuccessor method

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
    } // end createNode method

    // printing method
    public String printTree(Node node, String leftOrRight)
    {
        String result = "";
        if (node == null)
        {
            return "";
        } // end if null

        // prints value with placement (left or right of previous)
        result += (leftOrRight + ": " + node.ogValue + " | ");

        // calls self, if left states this
        result += printTree(node.left, "left of previous");
        // calls self, if right states this
        result += printTree(node.right, "right of previous");
        return result;
    } // end printTree method

} // end sorting nodes method