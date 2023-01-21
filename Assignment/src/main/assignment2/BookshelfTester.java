package main.assignment2;

import java.util.ArrayList;

public class BookshelfTester {

    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        System.out.println("bookshelf[exp:[]]: " + bookshelf);

        bookshelf = new Bookshelf(new ArrayList<Integer>(){{
            add(20);
            add(30);
        }});
        System.out.println("bookshelf[exp:[20 30]]: " + bookshelf);
        System.out.println("getHeight[exp: 20]: " + bookshelf.getHeight(0));
//        System.out.println("isPositive[exp: true]: " + bookshelf.isPositive());
        System.out.println("isSorted[exp: true]: " + bookshelf.isSorted());
        System.out.println("==========");

        bookshelf.addLast(bookshelf.removeFront());
        System.out.println("bookshelf[exp:[30 20]]: " + bookshelf);
//        System.out.println("isPositive[exp: true]: " + bookshelf.isPositive());
        System.out.println("isSorted[exp: false]: " + bookshelf.isSorted());
        System.out.println("==========");

        bookshelf.removeLast();
        bookshelf.addFront(0);
        System.out.println("bookshelf[exp:[0 30]]: " + bookshelf);
//        System.out.println("isPositive[exp: false]: " + bookshelf.isPositive());
        System.out.println("isSorted[exp: true]: " + bookshelf.isSorted());
    }

}
