package Practical9.client;

/*
 * BinarySearchTreeDriver.java
 * - illustrates the use of BinarySearchTree methods
 */
import Practical9.adt.BinarySearchTree;
import Practical9.adt.BinarySearchTreeInterface;
import java.util.*;

public class BinarySearchTreeDriver {

    public static void display(BinarySearchTreeInterface tree, int type) {
//    Iterator it = tree.getInorderIterator();
//    while (it.hasNext()) {
//      System.out.print(it.next() + " ");
//    }
//    System.out.println("\n");

        Iterator it = null;
        switch (type) {
            case 1:
                System.out.println("\nInorder");
                it = tree.getInorderIterator();
                break;
            case 2:
                System.out.println("\nPreorder");
                it = tree.getPreorderIterator();
                break;
            case 3:
                System.out.println("\nPostorder");
                it = tree.getPostorderIterator();
                break;
        }

        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        BinarySearchTreeInterface<String> bTree = new BinarySearchTree<String>();
        String[] nameArr = {"Meg", "Ben", "Zoe", "Dan", "Cindy", "Peter", "Jane", "Ann", "Walt", "Nate", "Andy"};

        for (int i = 0; i < nameArr.length; ++i) {
//            System.out.println("\nAdding " + nameArr[i] + "...");
            bTree.add(nameArr[i]);
        }

        System.out.println("Tree traversal: ");
        display(bTree, 1);
        display(bTree, 2);
        display(bTree, 3);

        System.out.println("Smallest: " + bTree.getSmallestValue());
        System.out.println("Biggest: " + bTree.getBiggestValue());

//    System.out.println("\nbTree contains: ");
//    display(bTree);
//
//    System.out.println("\nbTree.contains(Candy): " + bTree.contains("Candy"));
//    System.out.println("bTree.getEntry(Candy): " + bTree.getEntry("Candy"));
//    System.out.println("bTree.remove(Candy): " + bTree.remove("Candy"));
//    System.out.println("bTree should contain: Andy Ann Ben Cindy Dan Jane Meg Nate Peter Walt Zoe");
//    System.out.print("bTree contains      : ");
//    display(bTree);
//
//    System.out.println("\nbTree.contains(Cindy): " + bTree.contains("Cindy"));
//    System.out.println("bTree.getEntry(Cindy): " + bTree.getEntry("Cindy"));
//    System.out.println("bTree.remove(Cindy): " + bTree.remove("Cindy"));
//    System.out.println("bTree should contain: Andy Ann Ben Dan Jane Meg Nate Peter Walt Zoe");
//    System.out.print("bTree contains      : ");
//    display(bTree);
//
//    System.out.println("\nbTree.contains(Will): " + bTree.contains("Will"));
//    System.out.println("bTree.getEntry(Will): " + bTree.getEntry("Will"));
//    System.out.println("bTree.remove(Will): " + bTree.remove("Will"));
//    System.out.println("bTree should contain: Andy Ann Ben Dan Jane Meg Nate Peter Walt Zoe");
//    System.out.print("bTree contains      : ");
//    display(bTree);
//
//    System.out.println("\nbTree.contains(Walt): " + bTree.contains("Walt"));
//    System.out.println("bTree.getEntry(Walt): " + bTree.getEntry("Walt"));
//    System.out.println("bTree.remove(Walt): " + bTree.remove("Walt"));
//    System.out.println("bTree should contain: Andy Ann Ben Dan Jane Meg Nate Peter Zoe");
//    System.out.print("bTree contains      : ");
//    display(bTree);
//
//    System.out.println("\nbTree.contains(Ben): " + bTree.contains("Ben"));
//    System.out.println("bTree.getEntry(Ben): " + bTree.getEntry("Ben"));
//    System.out.println("bTree.remove(Ben): " + bTree.remove("Ben"));
//    System.out.println("bTree should contain: Andy Ann Dan Jane Meg Nate Peter Zoe");
//    System.out.print("bTree contains      : ");
//    display(bTree);
//
//    System.out.println("\nbTree.contains(Bean): " + bTree.contains("Bean"));
//    System.out.println("bTree.getEntry(Bean): " + bTree.getEntry("Bean"));
//    System.out.println("bTree.remove(Bean): " + bTree.remove("Bean"));
//    System.out.println("bTree should contain: Andy Ann Dan Jane Meg Nate Peter Zoe");
//    System.out.print("bTree contains      : ");
//    display(bTree);
//
//    System.out.println("\nbTree.contains(Meg): " + bTree.contains("Meg"));
//    System.out.println("bTree.getEntry(Meg): " + bTree.getEntry("Meg"));
//    System.out.println("bTree.remove(Meg): " + bTree.remove("Meg"));
//    System.out.println("bTree should contain: Andy Ann Dan Jane Nate Peter Zoe");
//    System.out.print("bTree contains      : ");
//    display(bTree);
//
//    System.out.println("\nbTree.contains(Mick): " + bTree.contains("Mick"));
//    System.out.println("bTree.getEntry(Mick): " + bTree.getEntry("Mick"));
//    System.out.println("bTree.remove(Mick): " + bTree.remove("Mick"));
//    System.out.println("\nbTree.contains(Zorro): " + bTree.contains("Zorro"));
//    System.out.println("bTree.getEntry(Zorro): " + bTree.getEntry("Zorro"));
//    System.out.println("bTree.remove(Zorro): " + bTree.remove("Zorro"));
//    System.out.println("bTree should contain: Andy Ann Dan Jane Nate Peter Zoe");
//    System.out.print("bTree contains      : ");
//    display(bTree);
//
//    System.out.println("\nbTree.contains(Zoe): " + bTree.contains("Zoe"));
//    System.out.println("bTree.getEntry(Zoe): " + bTree.getEntry("Zoe"));
//    System.out.println("bTree.remove(Zoe): " + bTree.remove("Zoe"));
//    System.out.println("bTree should contain: Andy Ann Dan Jane Nate Peter");
//    System.out.print("bTree contains      : ");
//    display(bTree);
    }
}
