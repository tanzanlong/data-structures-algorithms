package com.tan.datastructure.line.linklist.sampleone;

import lombok.Data;

public class LinkListSample<E> {

    
    /**
     * 首部元素 
     */
    Node<E> head;
    /**
     * 尾部元素
     */
    Node<E> tail;
    
    
    
    public void add(E value){
        /**
         * 局部变量相对实例变量可以有25%
         */
        final Node<E> l=tail;
        
        Node<E> c=new Node<E>(l,value,null);
        tail=c;
        if(l==null){
            head=c;
        }else{
            tail.next=c;
        }
        
        
    }
    
    
    @Data
    static class Node<E>{
        
        public Node(Node<E> pre,E value,Node<E> next){
            this.pre=pre;
            this.value=value;
            this.next=next;
        }
        
      private  Node<E> pre;
        
      private  E value;
        
      private  Node<E> next;
        
    }
    
    @Data
    static class User{
        
        public User(String name){
            this.name=name;
        }
        
        
        String name;
    }
    
    
    public static void main(String[] args) {
       
        User one =new User("one");
        User two =new User("two");
        User copy=one;
        System.out.println(copy.name);
        System.out.println(one.name);
        System.out.println(two.name);
        
        one=two;
        System.out.println(copy.name);
        System.out.println(one.name);
        System.out.println(two.name);
        
    }
}
