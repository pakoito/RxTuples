
package com.pacoworks.rxtuples;

import org.javatuples.Octet;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Septet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;
import org.junit.Assert;
import org.junit.Test;

import rx.Observable;

public class RxTuplesTest {
    public static final Pair<Integer, Integer> RES_PAIR = Pair.with(1, 2);

    public static final Triplet<Integer, Integer, Integer> RES_TRIPLET = Triplet.with(1, 2, 3);

    public static final Quartet<Integer, Integer, Integer, Integer> RES_QUARTET = Quartet.with(1,
            2, 3, 4);

    public static final Quintet<Integer, Integer, Integer, Integer, Integer> RES_QUINTET = Quintet
            .with(1, 2, 3, 4, 5);

    public static final Sextet<Integer, Integer, Integer, Integer, Integer, Integer> RES_SEXTET = Sextet
            .with(1, 2, 3, 4, 5, 6);

    public static final Septet<Integer, Integer, Integer, Integer, Integer, Integer, Integer> RES_SEPTET = Septet
            .with(1, 2, 3, 4, 5, 6, 7);

    public static final Octet<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> RES_OCTET = Octet
            .with(1, 2, 3, 4, 5, 6, 7, 8);

    private static final Observable<Integer> RANGE = Observable.range(1, 10);

    private static final Observable<Octet<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer>> ZIP_RANGE = RANGE
            .zipWith(RANGE, RxTuples.<Integer, Integer> toPair())
            .zipWith(RANGE, RxTuples.<Integer, Integer, Integer> toTriplet())
            .zipWith(RANGE, RxTuples.<Integer, Integer, Integer, Integer> toQuartet())
            .zipWith(RANGE, RxTuples.<Integer, Integer, Integer, Integer, Integer> toQuintet())
            .zipWith(RANGE,
                    RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextet())
            .zipWith(
                    RANGE,
                    RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptet())
            .zipWith(
                    RANGE,
                    RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctet());

    @Test
    public void testDoThing() throws Exception {
        Assert.assertEquals(true,
                ZIP_RANGE.toBlocking().first().equals(Octet.with(1, 1, 1, 1, 1, 1, 1, 1)));
        Assert.assertEquals(true,
                ZIP_RANGE.toBlocking().last().equals(Octet.with(10, 10, 10, 10, 10, 10, 10, 10)));
    }

    @Test
    public void testToPair() throws Exception {
        Assert.assertEquals(true, RxTuples.toPair().call(1, 2).equals(RES_PAIR));
    }

    @Test
    public void testToTriplet() throws Exception {
        Assert.assertEquals(true, RxTuples.<Integer, Integer, Integer> toTriplet()
                .call(RES_PAIR, 3).equals(RES_TRIPLET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer> toTriplet1().call(1, Pair.with(2, 3))
                        .equals(RES_TRIPLET));
    }

    @Test
    public void testToQuartet() throws Exception {
        Assert.assertEquals(true,
                RxTuples.<Integer, Integer, Integer, Integer> toQuartet().call(RES_TRIPLET, 4)
                        .equals(RES_QUARTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer> toQuartet1()
                        .call(1, Triplet.with(2, 3, 4)).equals(RES_QUARTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer> toQuartet2()
                        .call(Pair.with(1, 2), Pair.with(3, 4)).equals(RES_QUARTET));
    }

    @Test
    public void testToQuintet() throws Exception {
        Assert.assertEquals(true, RxTuples
                .<Integer, Integer, Integer, Integer, Integer> toQuintet().call(RES_QUARTET, 5)
                .equals(RES_QUINTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer> toQuintet1()
                        .call(1, Quartet.with(2, 3, 4, 5)).equals(RES_QUINTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer> toQuintet2()
                        .call(Triplet.with(1, 2, 3), Pair.with(4, 5)).equals(RES_QUINTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer> toQuintet3()
                        .call(Pair.with(1, 2), Triplet.with(3, 4, 5)).equals(RES_QUINTET));
    }

    @Test
    public void testToSextet() throws Exception {
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextet()
                        .call(RES_QUINTET, 6).equals(RES_SEXTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextet1()
                        .call(1, Quintet.with(2, 3, 4, 5, 6)).equals(RES_SEXTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextet2()
                        .call(Quartet.with(1, 2, 3, 4), Pair.with(5, 6)).equals(RES_SEXTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextet3()
                        .call(Pair.with(1, 2), Quartet.with(3, 4, 5, 6)).equals(RES_SEXTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextet4()
                        .call(Triplet.with(1, 2, 3), Triplet.with(4, 5, 6)).equals(RES_SEXTET));
    }

    @Test
    public void testToSeptet() throws Exception {
        Assert.assertEquals(true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptet()
                        .call(RES_SEXTET, 7).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptet1()
                        .call(1, Sextet.with(2, 3, 4, 5, 6, 7)).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptet2()
                        .call(Quintet.with(1, 2, 3, 4, 5), Pair.with(6, 7)).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptet3()
                        .call(Pair.with(1, 2), Quintet.with(3, 4, 5, 6, 7)).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptet4()
                        .call(Quartet.with(1, 2, 3, 4), Triplet.with(5, 6, 7)).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptet5()
                        .call(Triplet.with(1, 2, 3), Quartet.with(4, 5, 6, 7)).equals(RES_SEPTET));
    }

    @Test
    public void testToOctet() throws Exception {
        Assert.assertEquals(true, RxTuples
                .<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctet()
                .call(RES_SEPTET, 8).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctet1()
                        .call(1, Septet.with(2, 3, 4, 5, 6, 7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctet2()
                        .call(Sextet.with(1, 2, 3, 4, 5, 6), Pair.with(7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctet3()
                        .call(Pair.with(1, 2), Sextet.with(3, 4, 5, 6, 7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctet4()
                        .call(Quintet.with(1, 2, 3, 4, 5), Triplet.with(6, 7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctet5()
                        .call(Triplet.with(1, 2, 3), Quintet.with(4, 5, 6, 7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctet6()
                        .call(Quartet.with(1, 2, 3, 4), Quartet.with(5, 6, 7, 8)).equals(RES_OCTET));
    }
}
