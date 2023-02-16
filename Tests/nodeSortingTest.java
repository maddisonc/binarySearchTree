import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class nodeSortingTest {
    nodeSorting tree1 = new nodeSorting();
    Node root = null;

    // tests for inserting/adding new nodes (values)
    // when creating a new node, will the correct value be returned?
    @Test
    void insertVal10()
    {
        int expected = 10;
        int actual = tree1.insertVals(root, 10).ogValue;
        assertEquals(expected, actual);
    }

    @Test
    void insertVal8()
    {
        int expected = 8;
        int actual = tree1.insertVals(root, 8).ogValue;
        assertEquals(expected, actual);
    }

    @Test
    void insertVal4()
    {
        int expected = 4;
        int actual = tree1.insertVals(root, 4).ogValue;
        assertEquals(expected, actual);
    }

    // tests for the accuracy of tree node placement
    // when inputting values, will the method return an accurate tree?
    @Test
    void printTreeRoot10 ()
    {
        // starting value: 10
        root = tree1.insertVals(root, 10);

        root = tree1.insertVals(root, 8);
        root = tree1.insertVals(root, 4);
        root = tree1.insertVals(root, 2);
        root = tree1.insertVals(root, 12);
        root = tree1.insertVals(root, 24);
        root = tree1.insertVals(root, 6);
        root = tree1.insertVals(root, 0);

        // expected tree beginning with 10
        String expected = ": 10 | left of previous: 8 | left of previous: 4 | left of previous: 2 | left of previous: 0 | right of previous: 6 | right of previous: 12 | right of previous: 24 | ";
        String actual = tree1.printTree(root, "");
        assertEquals(expected, actual);
    }

    @Test
    void printTreeRoot8 ()
    {
        // starting value: 8
        root = tree1.insertVals(root, 8);

        root = tree1.insertVals(root, 3);
        root = tree1.insertVals(root, 10);
        root = tree1.insertVals(root, 1);
        root = tree1.insertVals(root, 6);
        root = tree1.insertVals(root, 4);
        root = tree1.insertVals(root, 7);

        // expected tree beginning with 8
        String expected = ": 8 | left of previous: 3 | left of previous: 1 | right of previous: 6 | left of previous: 4 | right of previous: 7 | right of previous: 10 | ";
        String actual = tree1.printTree(root, "");
        assertEquals(expected, actual);
    }

    @Test
    void printTreeRoot11 ()
    {
        // starting value: 11
        root = tree1.insertVals(root, 11);

        root = tree1.insertVals(root, 7);
        root = tree1.insertVals(root, 12);
        root = tree1.insertVals(root, 5);
        root = tree1.insertVals(root, 9);

        // expected tree beginning with 11
        String expected = ": 11 | left of previous: 7 | left of previous: 5 | right of previous: 9 | right of previous: 12 | ";
        String actual = tree1.printTree(root, "");
        assertEquals(expected, actual);
    }

    // tests for deleting a node
    // when a node is deleted, will the method output an accurate tree (rearrange the entire tree to delete node)?
    @Test
    void DelNode7 ()
    {
        // starting value: 11
        root = tree1.insertVals(root, 11);

        root = tree1.insertVals(root, 7);
        root = tree1.insertVals(root, 12);
        root = tree1.insertVals(root, 5);
        root = tree1.insertVals(root, 9);

        // deletes node with value of 7
        root = tree1.deleteNode(root, 7);

        // previous tree (with 7 intact)
        //String expected = ": 11 | left of previous: 7 | left of previous: 5 | right of previous: 9 | right of previous: 12 | ";

        // new expected tree beginning with 11, with node of 7 deleted
        String expected = ": 11 | left of previous: 9 | left of previous: 5 | right of previous: 12 | ";
        String actual = tree1.printTree(root, "");
        assertEquals(expected, actual);
    }

    @Test
    void DelRootNode8 ()
    {
        // starting value: 8
        root = tree1.insertVals(root, 8);

        root = tree1.insertVals(root, 3);
        root = tree1.insertVals(root, 10);
        root = tree1.insertVals(root, 1);
        root = tree1.insertVals(root, 6);
        root = tree1.insertVals(root, 4);
        root = tree1.insertVals(root, 7);

        // deletes node with value of 8 (root)
        root = tree1.deleteNode(root, 8);

        // previous tree (with root 8 intact)
        // String expected = ": 8 | left of previous: 3 | left of previous: 1 | right of previous: 6 | left of previous: 4 | right of previous: 7 | right of previous: 10 | ";

        // new expected tree beginning with 10 (root 8 deleted)
        String expected = ": 10 | left of previous: 3 | left of previous: 1 | right of previous: 6 | left of previous: 4 | right of previous: 7 | ";
        String actual = tree1.printTree(root, "");
        assertEquals(expected, actual);
    }

    // test if a value exists in the tree




}