import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void serializeAndDeserializeExample1() {
    TreeNode tree = sol.createBinaryTree(new String[]{
      "1", "2", "3", "null", "null", "4", "5"
    });
    assertTrue(sol.isSameTree(
        tree,
        sol.deserialize(sol.serialize(tree))
    ));
  }

  @Test
  void serializeAndDeserializeExample2() {
    TreeNode tree = sol.createBinaryTree(new String[]{
        "null"
    });
    assertTrue(sol.isSameTree(
        tree,
        sol.deserialize(sol.serialize(tree))
    ));
  }
}