/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// XerialJ
//
// RedBlackTree.java
// Since: Dec 5, 2008 5:12:11 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

/**
 * Red-Black tree implementation using Left-Leaning Red-Black Tree (LLRB)
 * 
 * @author leo
 * 
 * @param <Key>
 * @param <Value>
 */
public class RedBlackTree<Key extends Comparable<Key>, Value>
{

    private final static boolean RED = true;
    private final static boolean BLACK = false;

    private class Node
    {
        Key key;
        Value value;
        Node left;
        Node right;
        boolean color;

        public Node(Key key, Value value)
        {
            this.key = key;
            this.value = value;
            this.color = RED; // default is RED
        }

        public Node(Key key, Value value, boolean color)
        {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private Node root = null;

    public RedBlackTree()
    {}

    public Value get(Key key)
    {
        return get(root, key);
    }

    public Value get(Node current, Key key)
    {
        if (current == null)
            return null;

        int cmp = key.compareTo(current.key);
        if (cmp == 0)
            return current.value;
        else if (cmp < 0)
            return get(current.left, key);
        else
            return get(current.right, key);
    }

    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    public void put(Key key, Value value)
    {
        root = insert(root, key, value);
        root.color = BLACK;
    }

    private Node insert(Node current, Key key, Value value)
    {
        // insert at the bottom
        if (current == null)
            return new Node(key, value);

        // split 4-nodes (both of left and right edges are red) on the way down
        if (isRed(current.left) && isRed(current.right))
            flipColor(current);

        int cmp = key.compareTo(current.key);
        if (cmp == 0)
            current.value = value; // previous value is overwritten because no duplicate keys are allowed
        else if (cmp < 0)
            current.left = insert(current.left, key, value);
        else
            current.right = insert(current.right, key, value);

        // enforce the left-leaning condition
        if (isRed(current.right))
            current = rotateLeft(current);

        // balance 4-node (two reds in the left)
        if (isRed(current.left) && isRed(current.left.left))
            current = rotateRight(current);

        return current;
    }

    private boolean isRed(Node node)
    {
        return node == null ? false : node.color == RED;
    }

    private void flipColor(Node node)
    {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    /**
     * before:
     * 
     * <pre>
     *          |
     *          | c.color
     *          c
     *         / \
     *        /   \  x.color
     * c.left    c.right (x)
     *            /    \
     *         x.left   x.right
     * 
     * </pre>
     * 
     * after:
     * 
     * <pre>
     *             | 
     *             x
     *  x.color   / \ 
     *           c   x.right
     *          / \
     *         /   \     
     *    c.left  x.left
     * </pre>
     * 
     * 
     * @param c
     * @return
     */
    private Node rotateLeft(Node c)
    {
        Node x = c.right;
        c.right = x.left;
        x.left = c;
        x.color = x.left.color;
        c.color = RED;
        return x;
    }

    /**
     * before:
     * 
     * <pre>
     *      c.color| 
     *             c
     *  x.color   / \ 
     *   c.left (x)  c.right
     *          / \
     *         /   \     
     *    x.left  x.right
     * </pre>
     * 
     * after:
     * 
     * <pre>
     *          |
     *          | x.color
     *          x (c.left)
     *         / \
     *        /   \  c.color 
     * x.left      c
     *            /  \
     *       x.right  c.right
     * 
     * </pre>
     * 
     * @param c
     * @return
     */
    private Node rotateRight(Node c)
    {
        Node x = c.left;
        c.left = x.right;
        x.right = c;
        x.color = c.color;
        c.color = RED;
        return x;
    }

    private Node fixUp(Node c)
    {
        if (isRed(c.right))
            c = rotateLeft(c);
        if (isRed(c.left) && isRed(c.left.left))
            c = rotateRight(c);

        // eliminate 4-nodes on the way up
        if (isRed(c.left) && isRed(c.right))
            flipColor(c);

        return c;
    }
}
