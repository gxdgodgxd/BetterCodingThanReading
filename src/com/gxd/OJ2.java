package com.gxd;

/**
 *@Auther gxd4297
 *@Date:  2016年1月29日下午4:08:02
 */

public class OJ2
{
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
        
        void print(){
            ListNode l = this;
            while(l!=null){
                System.out.print(l.val);
                if(l.next!=null) System.out.print("->");
                l = l.next;
            }
            System.out.print("\n");
        }
    }
    
    //节省空间的做法
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int flg = 0;
        ListNode rtn = l1;
        while(l1!=null && l2!=null && l1!=l2){
            flg = l1.val + l2.val + flg;
            l1.val = flg%10;
            flg = flg-10<0?0:1;
            if(l1.next!=null && l2.next!=null){
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1.next==null && l2.next==null){
                l2 = l1;
                l1 = null;
            }
            else if(l1.next==null){
                l1.next = l2.next;
                l2 = l2.next;
                l1 = l2;
            }
            else{
                l1 = l1.next;
                l2 = l1;
            }
        }
        while(l1!=null){
            l2 = l1;
            flg = l1.val + flg;
            l1.val = flg%10;
            flg = flg-10<0?0:1;
            l1=l1.next;
        }
        if(flg==1) l2.next = new ListNode(1);
        return rtn;
    }
    
    public static ListNode addTwoNumbersS(ListNode l1,ListNode l2){
        if(l1==null && l2 ==null){
            return null;
        }
        ListNode rtn = new ListNode(0),pointer = rtn;
        int carry = 0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(carry%10);
            pointer.next = newNode;
            pointer = newNode;
            carry = carry / 10;
        }
        if(carry==1){
            ListNode newNode = new ListNode(1);
            pointer.next = newNode;
            pointer = newNode;
        }
        return rtn.next;
    }
    
    public static void main(String[] args)
    {
        ListNode l1,l2,l3,l4,l5,l6,l7;
        l1 = new ListNode(2);
        l2 = new ListNode(4);
        l1.next=l2;
//        l3 = new ListNode(3);
//        l2.next=l3;
        l1.print();
        
        l4 = new ListNode(5);
        l5 = new ListNode(6);
        l4.next=l5;
        l6 = new ListNode(4);
        l5.next=l6;
        l4.print();
        
        l7 = OJ2.addTwoNumbersS(l1, l4); 
        l7.print();
    }
}
