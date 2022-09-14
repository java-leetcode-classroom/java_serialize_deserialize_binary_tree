import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
  public TreeNode createBinaryTree(String[] inputs) {
    TreeNode result = null, cur;
    HashMap<Integer, TreeNode> hash = new HashMap<>();
    int size = inputs.length;
    for (int idx = 0; idx < size; idx++) {
      int num = 0;
      String val = inputs[idx];
      if (!val.equals("null")) {
        num = Integer.parseInt(val);
      }
      if (idx == 0) {
        result = new TreeNode(num);
        hash.put(num, result);
      }
      if (hash.containsKey(num)) {
        cur = hash.get(num);
      } else {
        cur = new TreeNode(num);
        hash.put(num, cur);
      }
      if (2*idx+1 < size) {
        if (!inputs[2*idx+1].equals("null")) {
          int leftVal = Integer.parseInt(inputs[2*idx+1]);
          if (hash.containsKey(leftVal)) {
            cur.left = hash.get(leftVal);
          } else {
            cur.left = new TreeNode(leftVal);
            hash.put(leftVal, cur.left);
          }
        }
      }
      if (2*idx+2 < size) {
        if (!inputs[2*idx+2].equals("null")) {
          int rightVal = Integer.parseInt(inputs[2*idx+2]);
          if (hash.containsKey(rightVal)) {
            cur.right = hash.get(rightVal);
          } else {
            cur.right = new TreeNode(rightVal);
            hash.put(rightVal, cur.right);
          }
        }
      }
    }
    return result;
  }
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    List<String> list = new ArrayList<>();
    DFS(root, list);
    return String.join(",", list);
  }
  public void DFS(TreeNode root, List<String> list) {
    if (root == null) {
      list.add("N");
      return;
    }
    list.add(String.valueOf(root.val));
    DFS(root.left, list);
    DFS(root.right, list);
  }
  // Decodes your encoded data to tree.
  int count;
  public TreeNode deserialize(String data) {
     String[] list = data.split(",");
     count = 0;
     return DE_DFS(list);
  }
  public TreeNode DE_DFS(String[] list) {
    if (list[count].equals("N")){
      count++;
      return null;
    }
    int rootValue = Integer.parseInt(list[count]);
    count++;
    TreeNode root = new TreeNode(rootValue);
    root.left = DE_DFS(list);
    root.right = DE_DFS(list);
    return root;
  }
  public boolean isSameTree(TreeNode root1, TreeNode root2) {
    if (root1 == null) {
      return root2 == null;
    }
    if (root2 != null) {
      if (root1.val != root2.val) {
        return false;
      }
      return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    return false;
  }
}
