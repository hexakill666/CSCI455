package main.assignment2;

import java.util.ArrayList;

public class BookshelfKeeperTester {

    public void test1(){
        BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(new Bookshelf(new ArrayList<Integer>(){{
            add(1);
            add(5);
            add(8);
        }}));
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.putHeight(10);
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.putHeight(6);
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.putHeight(4);
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.pickPos(3);
        System.out.println(bookshelfKeeper);
    }

    public void test2(){
        BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(new Bookshelf(new ArrayList<Integer>()));
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.putHeight(1);
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.putHeight(10);
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.putHeight(5);
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.putHeight(8);
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.pickPos(1);
        System.out.println(bookshelfKeeper);
    }

    public void test3(){
        BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(new Bookshelf(new ArrayList<Integer>(){{
            add(1);
            add(9);
            add(11);
            add(13);
            add(17);
            add(19);
        }}));
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.pickPos(1);
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.putHeight(10);
        System.out.println(bookshelfKeeper);
    }

    public void test4(){
        BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(new Bookshelf(new ArrayList<Integer>(){{
            add(3);
            add(7);
            add(7);
            add(7);
            add(12);
            add(12);
            add(12);
            add(12);
            add(15);
            add(18);
        }}));
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.putHeight(12);
        System.out.println(bookshelfKeeper);
    }

    public void test5(){
        BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(new Bookshelf(new ArrayList<Integer>(){{
            add(3);
            add(3);
            add(3);
            add(3);
        }}));
        System.out.println(bookshelfKeeper);
        bookshelfKeeper.pickPos(1);
        System.out.println(bookshelfKeeper);
    }

    public void extra1(){
        BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(new Bookshelf(new ArrayList<Integer>(){{
            add(2);
            add(9);
            add(9);
            add(11);
            add(18);
            add(23);
            add(50);
        }}));
        System.out.println(bookshelfKeeper);
        put(bookshelfKeeper, 9);
        put(bookshelfKeeper,11);
        pick(bookshelfKeeper, 2);
        pick(bookshelfKeeper, 0);
        put(bookshelfKeeper,11);
    }

    public void extra2(){
        BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(new Bookshelf(new ArrayList<Integer>()));
        System.out.println(bookshelfKeeper);
        put(bookshelfKeeper, 2);
        put(bookshelfKeeper,5);
        put(bookshelfKeeper,15);
        put(bookshelfKeeper,21);
        put(bookshelfKeeper,27);
        put(bookshelfKeeper,5);
        put(bookshelfKeeper,15);
        pick(bookshelfKeeper, 0);
        pick(bookshelfKeeper, 0);
        put(bookshelfKeeper, 21);
    }

    public void put(BookshelfKeeper bookshelfKeeper, int argument){
        bookshelfKeeper.putHeight(argument);
        System.out.println(bookshelfKeeper);
    }

    public void pick(BookshelfKeeper bookshelfKeeper, int argument){
        bookshelfKeeper.pickPos(argument);
        System.out.println(bookshelfKeeper);
    }

    public static void main(String[] args){
        BookshelfKeeperTester bookshelfKeeperTester = new BookshelfKeeperTester();
        bookshelfKeeperTester.test1();
        System.out.println("==========");
        bookshelfKeeperTester.test2();
        System.out.println("==========");
        bookshelfKeeperTester.test3();
        System.out.println("==========");
        bookshelfKeeperTester.test4();
        System.out.println("==========");
        bookshelfKeeperTester.test5();
        System.out.println("==========");
        bookshelfKeeperTester.extra1();
        System.out.println("==========");
        bookshelfKeeperTester.extra2();
    }

}
