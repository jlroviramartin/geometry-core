/*
 * Copyright (C) 2018 joseluis.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package essence.geometry.core.doubles;

import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author joseluis
 */
public class Tuple4dListTest {

    @Test
    public void addTest() {
        Tuple4dList list = new Tuple4dList();
        for (int i = 0; i < 100; i++) {
            list.add(new Tuple4d(1, 2, 3, 4));
            list.add(new Tuple4d(5, 6, 7, 8));
            list.add(new Tuple4d(9, 10, 11, 12));
        }
        Assert.assertEquals(
                100 * 3,
                list.size());

        Tuple4d aux = new Tuple4d();
        for (int i = 0; i < 100;) {
            list.getInto(i++, aux);
            Assert.assertEquals(
                    new Tuple4d(1, 2, 3, 4),
                    aux);

            list.getInto(i++, aux);
            Assert.assertEquals(
                    new Tuple4d(5, 6, 7, 8),
                    aux);

            list.getInto(i++, aux);
            Assert.assertEquals(
                    new Tuple4d(9, 10, 11, 12),
                    aux);
        }
    }

    @Test
    public void insertTest() {
        Tuple4dList list = new Tuple4dList((x, y, z, w) -> new Tuple4d(x, y, z, w));

        list.add(0, new Tuple4d(1, 2, 3, 4));
        Assert.assertEquals(new Tuple4d(1, 2, 3, 4), list.get(0));

        list.add(0, new Tuple4d(5, 6, 7, 8));
        Assert.assertEquals(new Tuple4d(5, 6, 7, 8), list.get(0));
        Assert.assertEquals(new Tuple4d(1, 2, 3, 4), list.get(1));

        list.add(1, new Tuple4d(9, 10, 11, 12));
        Assert.assertEquals(new Tuple4d(5, 6, 7, 8), list.get(0));
        Assert.assertEquals(new Tuple4d(9, 10, 11, 12), list.get(1));
        Assert.assertEquals(new Tuple4d(1, 2, 3, 4), list.get(2));
    }

    @Test
    public void addAllTest() {
        Tuple4dList list = new Tuple4dList((x, y, z, w) -> new Tuple4d(x, y, z, w));

        list.addAll(0, Arrays.asList(new Tuple4d(1, 2, 3, 4), new Tuple4d(5, 6, 7, 8), new Tuple4d(9, 10, 11, 12)));
        list.addAll(1, Arrays.asList(new Tuple4d(1, 2, 3, 4), new Tuple4d(5, 6, 7, 8), new Tuple4d(9, 10, 11, 12)));
        list.addAll(6, Arrays.asList(new Tuple4d(1, 2, 3, 4), new Tuple4d(5, 6, 7, 8), new Tuple4d(9, 10, 11, 12)));
        list.addAll(0, Arrays.asList(new Tuple4d(1, 2, 3, 4), new Tuple4d(5, 6, 7, 8), new Tuple4d(9, 10, 11, 12)));

        Assert.assertArrayEquals(
                new Tuple4d[]{
                    new Tuple4d(1, 2, 3, 4), new Tuple4d(5, 6, 7, 8), new Tuple4d(9, 10, 11, 12),
                    new Tuple4d(1, 2, 3, 4), new Tuple4d(1, 2, 3, 4), new Tuple4d(5, 6, 7, 8),
                    new Tuple4d(9, 10, 11, 12), new Tuple4d(5, 6, 7, 8), new Tuple4d(9, 10, 11, 12),
                    new Tuple4d(1, 2, 3, 4), new Tuple4d(5, 6, 7, 8), new Tuple4d(9, 10, 11, 12)
                },
                list.toArray());
    }

    @Test
    public void removeTest() {
        Tuple4dList list = new Tuple4dList((x, y, z, w) -> new Tuple4d(x, y, z, w));
        list.add(new Tuple4d(1, 2, 3, 4));

        Assert.assertEquals(1, list.size());

        list.removeLast();

        Assert.assertEquals(0, list.size());

        list.add(new Tuple4d(1, 2, 3, 4));
        list.add(new Tuple4d(5, 6, 7, 8));
        list.add(new Tuple4d(9, 10, 11, 12));
        Assert.assertEquals(3, list.size());

        list.remove(1);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(new Tuple4d(1, 2, 3, 4), list.get(0));
        Assert.assertEquals(new Tuple4d(9, 10, 11, 12), list.get(1));

        list.remove(0);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(new Tuple4d(9, 10, 11, 12), list.get(0));

        list.remove(0);
        Assert.assertEquals(0, list.size());
    }

    private static Predicate<Object> equalsPredicate(Object tuple) {
        return x -> x.equals(tuple);
    }

    @Test
    public void indexOfTest() {
        Tuple4dList list = new Tuple4dList((x, y, z, w) -> new Tuple4d(x, y, z, w));
        list.add(new Tuple4d(1, 2, 3, 4));
        list.add(new Tuple4d(5, 6, 7, 8));
        list.add(new Tuple4d(9, 10, 11, 12));

        Assert.assertEquals(0, list.find(equalsPredicate(new Tuple4d(1, 2, 3, 4)), 0));
        Assert.assertEquals(1, list.find(equalsPredicate(new Tuple4d(5, 6, 7, 8)), 0));
        Assert.assertEquals(2, list.find(equalsPredicate(new Tuple4d(9, 10, 11, 12)), 0));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(13, 14, 15, 16)), 0));

        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(1, 2, 3, 4)), 1));
        Assert.assertEquals(1, list.find(equalsPredicate(new Tuple4d(5, 6, 7, 8)), 1));
        Assert.assertEquals(2, list.find(equalsPredicate(new Tuple4d(9, 10, 11, 12)), 1));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(13, 14, 15, 16)), 1));

        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(1, 2, 3, 4)), 2));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(5, 6, 7, 8)), 2));
        Assert.assertEquals(2, list.find(equalsPredicate(new Tuple4d(9, 10, 11, 12)), 2));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(13, 14, 15, 16)), 2));

        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(1, 2, 3, 4)), 3));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(5, 6, 7, 8)), 3));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(9, 10, 11, 12)), 3));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(13, 14, 15, 16)), 3));

        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(1, 2, 3, 4)), 4));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(5, 6, 7, 8)), 4));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(9, 10, 11, 12)), 4));
        Assert.assertEquals(-1, list.find(equalsPredicate(new Tuple4d(13, 14, 15, 16)), 4));
    }

    @Test
    public void lastIndexOfTest() {
        Tuple4dList list = new Tuple4dList((x, y, z, w) -> new Tuple4d(x, y, z, w));
        list.add(new Tuple4d(1, 2, 3, 4));
        list.add(new Tuple4d(5, 6, 7, 8));
        list.add(new Tuple4d(9, 10, 11, 12));

        Assert.assertEquals(0, list.findLast(equalsPredicate(new Tuple4d(1, 2, 3, 4)), list.size() - 1));
        Assert.assertEquals(1, list.findLast(equalsPredicate(new Tuple4d(5, 6, 7, 8)), list.size() - 1));
        Assert.assertEquals(2, list.findLast(equalsPredicate(new Tuple4d(9, 10, 11, 12)), list.size() - 1));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(13, 14, 15, 16)), list.size() - 1));

        Assert.assertEquals(0, list.findLast(equalsPredicate(new Tuple4d(1, 2, 3, 4)), list.size() - 2));
        Assert.assertEquals(1, list.findLast(equalsPredicate(new Tuple4d(5, 6, 7, 8)), list.size() - 2));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(9, 10, 11, 12)), list.size() - 2));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(13, 14, 15, 16)), list.size() - 2));

        Assert.assertEquals(0, list.findLast(equalsPredicate(new Tuple4d(1, 2, 3, 4)), list.size() - 3));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(5, 6, 7, 8)), list.size() - 3));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(9, 10, 11, 12)), list.size() - 3));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(13, 14, 15, 16)), list.size() - 3));

        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(1, 2, 3, 4)), list.size() - 4));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(5, 6, 7, 8)), list.size() - 4));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(9, 10, 11, 12)), list.size() - 4));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(13, 14, 15, 16)), list.size() - 4));

        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(1, 2, 3, 4)), list.size() - 5));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(5, 6, 7, 8)), list.size() - 5));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(9, 10, 11, 12)), list.size() - 5));
        Assert.assertEquals(-1, list.findLast(equalsPredicate(new Tuple4d(13, 14, 15, 16)), list.size() - 5));
    }

    @Test
    public void forEachTest() {
        Tuple4dList list = new Tuple4dList((x, y, z, w) -> new Tuple4d(x, y, z, w));
        list.add(new Tuple4d(1, 2, 3, 4));
        list.add(new Tuple4d(5, 6, 7, 8));
        list.add(new Tuple4d(9, 10, 11, 12));

        list.forEach(x -> ((Tuple4d) x).set(13, 14, 15, 16));
        Assert.assertArrayEquals(
                new Tuple4d[]{
                    new Tuple4d(13, 14, 15, 16), new Tuple4d(13, 14, 15, 16), new Tuple4d(13, 14, 15, 16),
                },
                list.toArray());
    }
}
