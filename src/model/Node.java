package model;

import java.util.List;

/**
 * @author fengxxc
 * Definition for a Node.
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public String toJSONString(String prefix) {
        StringBuffer childStr = new StringBuffer();
        children.forEach(c -> childStr.append(c.toJSONString(prefix + "    ")));
        return  prefix + "{\n" +
                prefix + "  val: " + val + ", \n" +
                prefix + "  children: [\n" +
                                 childStr.toString() +
                prefix + "  ]\n" +
                prefix + "},\n";
    }

    @Override
    public String toString() {
        return toJSONString("");
    }
}
