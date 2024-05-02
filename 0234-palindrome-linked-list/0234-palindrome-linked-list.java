/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        //연결리스트에 스택을 삽입
        ListNode node = head;
        while(node!=null)
        {
            stack.add(node.val);
            node = node.next;
        }

        //연결 리스트가 모두 빌 때까지 비교 
        while(head!=null)
        {
            //연결 리스트와 스택에서 추출한 값을 비교해 팰린드롬 판별
            if(head.val != stack.pop())
            {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}