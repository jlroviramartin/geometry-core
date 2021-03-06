// <auto-generated>
//     This code was generated by a tool.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//
// Copyright (C) 2018 joseluis.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
// MA 02110-1301  USA


namespace essence.geometry.core
{
/**
 * A {@code Point4} is a 4 dimensional collection of values
 * that represents a point.
 */
public interface Point4 : Tuple
{

    /**
     * This method gets the quadrant/octant of {@code this} point.
     *
     * @return Quadrant of this point.
     */
    int GetQuadrant();

    /**
     * This method gets the distance of {@code this} point to {@code other} point.
     *
     * @param other Other point.
     * @return Distance.
     */
    double GetDistance(Point4 other);

    /**
     * This method gets the squared distance of {@code this} point to {@code other} point.
     *
     * @param other Other point.
     * @return Squared distance.
     */
    double GetDistanceCuad(Point4 other);

    /**
     * This method gets the L1 (Manhattan) distance of {@code this} point to {@code other} point.
     *
     * @param other Other point.
     * @return L1 (Manhattan) distance.
     */
    double GetDistanceL1(Point4 other);

    /**
     * This method adds {@code this} point to {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code result = this + other}
     */
    Point4 Add(Vector4 other);

    /**
     * This method subs {@code this} point to {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code result = this - other}
     */
    Point4 Sub(Vector4 other);

    /**
     * This method gets the vector from {@code this} to {@code other} point.
     *
     * @param other Other point.
     * @return {@code result = other - this}
     */
    Vector4 VectorTo(Point4 other);

    /**
     * This method evaluates the linear interpolation of {@code this} point and {@code other} point at {@code alpha}.
     *
     * @param other Other point.
     * @param alpha Interpolation.
     * @return {@code this * alpha + other * (1 - alpha)}
     */
    Point4 Lerp(Point4 other, double alpha);

    /**
     * This method evaluates the inverse of the linear interpolation of {@code this} point and {@code other} point at {@code pLerp}.
     *
     * @param other Other point.
     * @param pLerp Interpolated point.
     * @return {@code pLerp = this * result + other * (1 - result)}
     */
    double InvLerp(Point4 other, Point4 pLerp);

    /**
     * This method evaluates the linear combination of {@code this} point and {@code other} point at {@code alpha} and {@code beta}.
     *
     * @param other Other point.
     * @param alpha Interpolation for {@code this}.
     * @param beta Interpolation for {@code other}.
     * @return {@code this * alpha + other * beta}
     */
    Point4 Lineal(Point4 other, double alpha, double beta);

    /**
     * This method evaluates the scalar projection of {@code this} point over {@code where} vector.
     * https://en.wikipedia.org/wiki/Vector_projection
     *
     * @param where Where to project.
     * @return {@code this . where.getUnit()}
     */
    double ScalarProjection(Vector4 where);

    /**
     * This method evaluates the vector projection of {@code this} point over {@code where} vector.
     * https://en.wikipedia.org/wiki/Vector_projection
     *
     * @param where Where to project.
     * @return {@code this.scalarProjection(where) . where.getUnit()}
     */
    Point4 VectorProjection(Vector4 where);
}
}
