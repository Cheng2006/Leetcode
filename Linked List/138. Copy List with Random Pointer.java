/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    // public RandomListNode copyRandomList(RandomListNode head) {
    //     if(head==null){
    //         return head;
    //     }
    //     RandomListNode curr = head;
    //     while(curr!=null){
    //         RandomListNode node = new RandomListNode(curr.label);
    //         node.next = curr.next;
    //         curr.next = node;
    //         curr = node.next;
    //     }
    //     curr = head;
    //     while(curr!=null && curr.next!=null){
    //         if(curr.random!=null){
    //             curr.next.random = curr.random.next;
    //         }
    //         curr = curr.next.next;
    //     }
    //     curr = head;
    //     RandomListNode newHead = head.next;
    //     while(curr!=null && curr.next!=null){
    //         RandomListNode next = curr.next;
    //         curr.next = next.next;
    //         curr = next;
    //     }
    //     return newHead;
    // }
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return head;
        }
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode curr = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyCurr = dummy;
        while(curr!=null){
            if(map.containsKey(curr)){
                copyCurr.next = map.get(curr);
            }else{
                RandomListNode node = new RandomListNode(curr.label);
                map.put(curr,node);
                copyCurr.next = node;
            }
            copyCurr = copyCurr.next;
            if(curr.random!=null){
                if(map.containsKey(curr.random)){
                    copyCurr.random = map.get(curr.random);
                }else{
                    RandomListNode node = new RandomListNode(curr.random.label);
                    map.put(curr.random,node);
                    copyCurr.random = node;
                }
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
