public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        //PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
        //     @Override
        //     public int compare(ListNode l1,ListNode l2){
        //         return l1.val>l2.val?1:-1;
        //     }
        // });
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((e1,e2)->(e1.val-e2.val));
        for(int i = 0; i<lists.length;i++){
            if(lists[i]!=null){
                queue.add(lists[i]);
            }
        }
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            curr.next = temp;
            curr = curr.next;
            if(temp.next!=null){
                queue.add(temp.next);
            }
        }
        return dummy.next;
    }
}
