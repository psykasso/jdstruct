package test;

import java.util.Random;

import impl.DoubleLinkedList;

public class TestDLList {
    public static void main(String[] args) {
        // DoubleLinkedList list = new DoubleLinkedList();
        // Random rnd = new Random();
        // for (int i = 0; i < 10; i++) {
        // //list.insertLast((int)(Math.random()*10));
        // list.insertLast(rnd.nextInt(10));
        // }
        //
        // System.out.println(list);
        // System.out.println(DoubleLinkedList.reverseList(list));

//        DoubleLinkedList list = new DoubleLinkedList();
//        int number = 1;
//        for (int i = 0; i < 10; i++) {
//            // list.insertLast((int)(Math.random()*10));
//            list.insertLast((Math.random() > 0.5) ? number : ++number);
//        }
//
//        System.out.println(list);
//        System.out.println(DoubleLinkedList.uniqueList(list));
        
      DoubleLinkedList list = new DoubleLinkedList();
      int number = 1;
      for (int i = 0; i < 10; i++) {
          list.insertLast((int)(Math.random()*10));
          //list.insertLast(number++);
      }

      System.out.println(list);
//      System.out.println(DoubleLinkedList.lastElem(list,2));
//      System.out.println(DoubleLinkedList.lastSum(list,2));
      System.out.println(DoubleLinkedList.removeMin(list));
      System.out.println(list);
    }
}
