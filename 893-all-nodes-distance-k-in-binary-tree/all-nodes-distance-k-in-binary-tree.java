import java.util.*;

class Solution {
    Map<TreeNode, TreeNode> parent;
    
    private void preorder(TreeNode curr, TreeNode par) {
        if (curr == null) return;
        
        parent.put(curr, par);
        preorder(curr.left, curr);
        preorder(curr.right, curr);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        preorder(root, null);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        
        Set<TreeNode> visited = new HashSet<>();
        
        while (!queue.isEmpty() && k > 0) {
            k--;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                visited.add(curr);
                
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                }
                
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                }
                
                if (parent.get(curr) != null && !visited.contains(parent.get(curr))) {
                    queue.offer(parent.get(curr));
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        
        return result;
    }
}
