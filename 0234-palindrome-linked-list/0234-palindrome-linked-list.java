import java.util.*;
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
        Deque<Integer> deque = new LinkedList<>();

        //연결 리스트를 데크에 삽입
        ListNode node = head;
        while(node!=null)
        {
            deque.add(node.val);
            node = node.next;
        }

        //데크가 모두 비거나(짝수 개일때) 1개 이하(홀수 개일때) 될 때까지 비교
        while(!deque.isEmpty() && deque.size()>1) {
            //데크의 양 끝을 추출해 팰린드롬 여부 확인
            if(deque.pollFirst()!=deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}