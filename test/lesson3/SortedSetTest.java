package lesson3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.SortedSet;

public class SortedSetTest {
    private BinaryTree<Integer> tree;
    private BinaryTree<Integer> empty;

    @Before
    public void Test(){
        tree = new BinaryTree<>();
        empty = new BinaryTree<>();
        tree.add(10);
        tree.add(11);
        tree.add(14);
        tree.add(18);
        tree.add(15);
        tree.add(20);
        tree.add(13);
        tree.add(9);
        tree.add(7);
        tree.add(8);
        tree.add(12);
    }

    @Test
    public void headSet(){
        SortedSet<Integer> set = tree.headSet(14);
        assertEquals(true, set.contains(7));
        assertEquals(true, set.contains(8));
        assertEquals(true, set.contains(9));
        assertEquals(true, set.contains(10));
        assertEquals(true, set.contains(11));
        assertEquals(true, set.contains(12));
        assertEquals(true, set.contains(13));
        assertEquals(false, set.contains(14));
        assertEquals(false, set.contains(15));
        assertEquals(false, set.contains(18));
        assertEquals(false, set.contains(20));
        try{
            tree.headSet(null);
        }catch (NullPointerException e){
            assertTrue(true);
        }
        try{
            tree.headSet(25);
            tree.headSet(-25);
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }
        try{
            empty.headSet(10);
        }catch (NoSuchElementException e){
            assertTrue(true);
        }
    }

    @Test
    public void tailSet(){
        SortedSet<Integer> set = tree.tailSet(14);
        assertEquals(false, set.contains(7));
        assertEquals(false, set.contains(8));
        assertEquals(false, set.contains(9));
        assertEquals(false, set.contains(10));
        assertEquals(false, set.contains(11));
        assertEquals(false, set.contains(12));
        assertEquals(false, set.contains(13));
        assertEquals(true, set.contains(14));
        assertEquals(true, set.contains(15));
        assertEquals(true, set.contains(18));
        assertEquals(true, set.contains(20));
        try{
            tree.tailSet(null);
        }catch (NullPointerException e){
            assertTrue(true);
        }
        try{
            tree.tailSet(25);
            tree.tailSet(-25);
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }
        try{
            empty.tailSet(10);
        }catch (NoSuchElementException e){
            assertTrue(true);
        }
    }

    @Test
    public void subSet(){
        SortedSet<Integer> set = tree.subSet(9, 14);
        assertEquals(false, set.contains(7));
        assertEquals(false, set.contains(8));
        assertEquals(true, set.contains(9));
        assertEquals(true, set.contains(10));
        assertEquals(true, set.contains(11));
        assertEquals(true, set.contains(12));
        assertEquals(true, set.contains(13));
        assertEquals(false, set.contains(14));
        assertEquals(false, set.contains(15));
        assertEquals(false, set.contains(18));
        assertEquals(false, set.contains(20));
        try{
            tree.subSet(null, 10);
        }catch (NullPointerException e){
            assertTrue(true);
        }
        try{
            tree.subSet(10, null);
        }catch (NullPointerException e){
            assertTrue(true);
        }
        try{
            tree.subSet(-25, 13);
            tree.subSet(13, 25);
            tree.subSet(-13, 25);
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }
        try{
            empty.subSet(10, 14);
        }catch (NoSuchElementException e){
            assertTrue(true);
        }
    }
}
