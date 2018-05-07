package essence.geometry.core.doubles;

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
public class Vector2dTest {

    public Vector2dTest() {
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
    public void mathTest() {
        Assert.assertEquals(
                11. / 5.,
                new Vector2d(1, 2).scalarProjection(new Vector2d(3, 4)),
                0);

        Assert.assertEquals(
                0,
                new Vector2d(1, 2).scalarProjection(new Vector2d(2, -1)),
                0);

        Assert.assertEquals(
                new Vector2d(1.32, 1.76),
                new Vector2d(1, 2).vectorProjection(new Vector2d(3, 4)));
    }
}
