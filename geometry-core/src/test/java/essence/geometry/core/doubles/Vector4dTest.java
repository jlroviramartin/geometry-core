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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author joseluis
 */
public class Vector4dTest {

    public Vector4dTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void math() {
        Vector4d v = new Vector4d(1, 2, -3, -4);

        Assert.assertEquals(
                new Vector4d(1. + 5., 2. + -6., -3. + -7., -4. + 8.),
                v.add(new Vector4d(5, -6, -7, 8)));

        Assert.assertEquals(
                new Vector4d(1. - 5., 2. - -6., -3. - -7., -4. - 8.),
                v.sub(new Vector4d(5, -6, -7, 8)));

        Assert.assertEquals(
                new Vector4d(1. * 5., 2. * -6., -3. * -7., -4. * 8.),
                v.simpleMul(new Vector4d(5, -6, -7, 8)));

        Assert.assertEquals(
                new Vector4d(1. / 5., 2. / -6., -3. / -7., -4. / 8.),
                v.simpleDiv(new Vector4d(5, -6, -7, 8)));

        Assert.assertEquals(
                new Vector4d(1. * 5., 2. * 5., -3. * 5., -4. * 5.),
                v.mul(5));

        Assert.assertEquals(
                new Vector4d(1. / 5., 2. / 5., -3. / 5., -4. / 5.),
                v.div(5));

        Assert.assertEquals(
                new Vector4d(-1., -2., 3., 4.),
                v.neg());

        Assert.assertEquals(
                new Vector4d(1., 2., 3., 4.),
                v.abs());

        Assert.assertEquals(
                1. * 5. + 2. * -6. + -3. * -7. + -4. * 8.,
                v.dot(new Vector4d(5, -6, -7, 8)),
                0);
    }

    @Test
    public void others() {
        // toString
        Assert.assertEquals(
                String.format("(%1.3f;%2.3f;%3.3f;%4.3f)", 1., 2., 3., 4.),
                new Vector4d(1, 2, 3, 4).toString());

        // clone
        Assert.assertEquals(
                new Vector4d(1, 2, 3, 4),
                new Vector4d(1, 2, 3, 4).clone());

        Assert.assertEquals(
                new Vector4d(1, 2, 3, 4),
                new Vector4d(1, 2, 3, 4));

        Assert.assertNotEquals(
                new Vector4d(5, 6, 7, 8),
                new Vector4d(1, 2, 3, 4));

        // epsilonEquals
        Assert.assertEquals(
                false,
                new Vector4d(1, 2, 3, 4).epsilonEquals(new Vector4d(2, 3, 4, 5)));

        Assert.assertEquals(
                true,
                new Vector4d(1, 2, 3, 4).epsilonEquals(new Vector4d(1.1, 2.1, 3.1, 4.1), 0.1));
    }
}
