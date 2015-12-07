/*
 * Copyright (c) pakoito 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxtuples;

import org.javatuples.Octet;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Septet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;

public final class RxTuples {
    private RxTuples() {
    }

    /* Pair */
    public static <T, U> rx.functions.Func2<T, U, Pair<T, U>> toPair() {
        return new Func2<T, U, Pair<T, U>>() {
            @Override
            public Pair<T, U> call(T t, U t2) {
                return Pair.with(t, t2);
            }
        };
    }

    /* Triplet */
    public static <A, B, C> Func3<A, B, C, Triplet<A, B, C>> toTriplet() {
        return new Func3<A, B, C, Triplet<A, B, C>>() {
            @Override
            public Triplet<A, B, C> call(A a, B b, C c) {
                return Triplet.with(a, b, c);
            }
        };
    }

    public static <A, B, T> rx.functions.Func2<T, Pair<A, B>, Triplet<T, A, B>> toTripletFromSingle() {
        return new Func2<T, Pair<A, B>, Triplet<T, A, B>>() {
            @Override
            public Triplet<T, A, B> call(T t, Pair<A, B> objects) {
                return Triplet.with(t, objects.getValue0(), objects.getValue1());
            }
        };
    }

    public static <A, B, T> Func2<Pair<A, B>, T, Triplet<A, B, T>> toTripletFromPair() {
        return new Func2<Pair<A, B>, T, Triplet<A, B, T>>() {
            @Override
            public Triplet<A, B, T> call(Pair<A, B> objects, T t) {
                return Triplet.with(objects.getValue0(), objects.getValue1(), t);
            }
        };
    }

    /* Quartet */
    public static <A, B, C, D> Func4<A, B, C, D, Quartet<A, B, C, D>> toQuartet() {
        return new Func4<A, B, C, D, Quartet<A, B, C, D>>() {
            @Override
            public Quartet<A, B, C, D> call(A a, B b, C c, D d) {
                return Quartet.with(a, b, c, d);
            }
        };
    }

    public static <A, B, C, T> Func2<T, Triplet<A, B, C>, Quartet<T, A, B, C>> toQuartetFromSingle() {
        return new Func2<T, Triplet<A, B, C>, Quartet<T, A, B, C>>() {
            @Override
            public Quartet<T, A, B, C> call(T t, Triplet<A, B, C> objects) {
                return Quartet.with(t, objects.getValue0(), objects.getValue1(),
                        objects.getValue2());
            }
        };
    }

    public static <A, B, C, D> Func2<Pair<A, B>, Pair<C, D>, Quartet<A, B, C, D>> toQuartetFromPair() {
        return new Func2<Pair<A, B>, Pair<C, D>, Quartet<A, B, C, D>>() {
            @Override
            public Quartet<A, B, C, D> call(Pair<A, B> objects, Pair<C, D> objects2) {
                return Quartet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1());
            }
        };
    }

    public static <A, B, C, T> Func2<Triplet<A, B, C>, T, Quartet<A, B, C, T>> toQuartetFromTriplet() {
        return new Func2<Triplet<A, B, C>, T, Quartet<A, B, C, T>>() {
            @Override
            public Quartet<A, B, C, T> call(Triplet<A, B, C> objects, T t) {
                return Quartet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        t);
            }
        };
    }

    /* Quintet */

    public static <A, B, C, D, E> Func5<A, B, C, D, E, Quintet<A, B, C, D, E>> toQuintet() {
        return new Func5<A, B, C, D, E, Quintet<A, B, C, D, E>>() {
            @Override
            public Quintet<A, B, C, D, E> call(A a, B b, C c, D d, E e) {
                return Quintet.with(a, b, c, d, e);
            }
        };
    }

    public static <A, B, C, D, T> Func2<T, Quartet<A, B, C, D>, Quintet<T, A, B, C, D>> toQuintetFromSingle() {
        return new Func2<T, Quartet<A, B, C, D>, Quintet<T, A, B, C, D>>() {
            @Override
            public Quintet<T, A, B, C, D> call(T t, Quartet<A, B, C, D> objects) {
                return Quintet.with(t, objects.getValue0(), objects.getValue1(),
                        objects.getValue2(), objects.getValue3());
            }
        };
    }

    public static <A, B, C, D, E> Func2<Pair<A, B>, Triplet<C, D, E>, Quintet<A, B, C, D, E>> toQuintetFromPair() {
        return new Func2<Pair<A, B>, Triplet<C, D, E>, Quintet<A, B, C, D, E>>() {
            @Override
            public Quintet<A, B, C, D, E> call(Pair<A, B> objects, Triplet<C, D, E> objects2) {
                return Quintet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2());
            }
        };
    }

    public static <A, B, C, D, E> Func2<Triplet<A, B, C>, Pair<D, E>, Quintet<A, B, C, D, E>> toQuintetFromTriplet() {
        return new Func2<Triplet<A, B, C>, Pair<D, E>, Quintet<A, B, C, D, E>>() {
            @Override
            public Quintet<A, B, C, D, E> call(Triplet<A, B, C> objects, Pair<D, E> objects2) {
                return Quintet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects2.getValue0(), objects2.getValue1());
            }
        };
    }

    public static <A, B, C, D, T> Func2<Quartet<A, B, C, D>, T, Quintet<A, B, C, D, T>> toQuintetFromQuartet() {
        return new Func2<Quartet<A, B, C, D>, T, Quintet<A, B, C, D, T>>() {
            @Override
            public Quintet<A, B, C, D, T> call(Quartet<A, B, C, D> objects, T t) {
                return Quintet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), t);
            }
        };
    }

    /* Sextet */

    public static <A, B, C, D, E, F> Func6<A, B, C, D, E, F, Sextet<A, B, C, D, E, F>> toSextet() {
        return new Func6<A, B, C, D, E, F, Sextet<A, B, C, D, E, F>>() {
            @Override
            public Sextet<A, B, C, D, E, F> call(A a, B b, C c, D d, E e, F f) {
                return Sextet.with(a, b, c, d, e, f);
            }
        };
    }

    public static <A, B, C, D, E, T> Func2<T, Quintet<A, B, C, D, E>, Sextet<T, A, B, C, D, E>> toSextetFromSingle() {
        return new Func2<T, Quintet<A, B, C, D, E>, Sextet<T, A, B, C, D, E>>() {
            @Override
            public Sextet<T, A, B, C, D, E> call(T t, Quintet<A, B, C, D, E> objects) {
                return Sextet.with(t, objects.getValue0(), objects.getValue1(),
                        objects.getValue2(), objects.getValue3(), objects.getValue4());
            }
        };
    }

    public static <A, B, C, D, E, F> Func2<Pair<A, B>, Quartet<C, D, E, F>, Sextet<A, B, C, D, E, F>> toSextetFromPair() {
        return new Func2<Pair<A, B>, Quartet<C, D, E, F>, Sextet<A, B, C, D, E, F>>() {
            @Override
            public Sextet<A, B, C, D, E, F> call(Pair<A, B> objects, Quartet<C, D, E, F> objects2) {
                return Sextet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2(), objects2.getValue3());
            }
        };
    }

    public static <A, B, C, D, E, F> Func2<Triplet<A, B, C>, Triplet<D, E, F>, Sextet<A, B, C, D, E, F>> toSextetFromTriplet() {
        return new Func2<Triplet<A, B, C>, Triplet<D, E, F>, Sextet<A, B, C, D, E, F>>() {
            @Override
            public Sextet<A, B, C, D, E, F> call(Triplet<A, B, C> objects, Triplet<D, E, F> objects2) {
                return Sextet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects2.getValue0(), objects2.getValue1(), objects2.getValue2());
            }
        };
    }

    public static <A, B, C, D, E, F> Func2<Quartet<A, B, C, D>, Pair<E, F>, Sextet<A, B, C, D, E, F>> toSextetFromQuartet() {
        return new Func2<Quartet<A, B, C, D>, Pair<E, F>, Sextet<A, B, C, D, E, F>>() {
            @Override
            public Sextet<A, B, C, D, E, F> call(Quartet<A, B, C, D> objects, Pair<E, F> objects2) {
                return Sextet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects2.getValue0(), objects2.getValue1());
            }
        };
    }

    public static <A, B, C, D, E, T> Func2<Quintet<A, B, C, D, E>, T, Sextet<A, B, C, D, E, T>> toSextetFromQuintet() {
        return new Func2<Quintet<A, B, C, D, E>, T, Sextet<A, B, C, D, E, T>>() {
            @Override
            public Sextet<A, B, C, D, E, T> call(Quintet<A, B, C, D, E> objects, T t) {
                return Sextet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), t);
            }
        };
    }

    /* Septet */

    public static <A, B, C, D, E, F, G> Func7<A, B, C, D, E, F, G, Septet<A, B, C, D, E, F, G>> toSeptet() {
        return new Func7<A, B, C, D, E, F, G, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> call(A a, B b, C c, D d, E e, F f, G g) {
                return Septet.with(a, b, c, d, e, f, g);
            }
        };
    }

    public static <A, B, C, D, E, F, T> Func2<T, Sextet<A, B, C, D, E, F>, Septet<T, A, B, C, D, E, F>> toSeptetFromSingle() {
        return new Func2<T, Sextet<A, B, C, D, E, F>, Septet<T, A, B, C, D, E, F>>() {
            @Override
            public Septet<T, A, B, C, D, E, F> call(T t, Sextet<A, B, C, D, E, F> objects) {
                return Septet.with(t, objects.getValue0(), objects.getValue1(),
                        objects.getValue2(), objects.getValue3(), objects.getValue4(),
                        objects.getValue5());
            }
        };
    }

    public static <A, B, C, D, E, F, G> Func2<Pair<A, B>, Quintet<C, D, E, F, G>, Septet<A, B, C, D, E, F, G>> toSeptetFromPair() {
        return new Func2<Pair<A, B>, Quintet<C, D, E, F, G>, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> call(Pair<A, B> objects,
                                                    Quintet<C, D, E, F, G> objects2) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2(), objects2.getValue3(),
                        objects2.getValue4());
            }
        };
    }

    public static <A, B, C, D, E, F, G> Func2<Triplet<A, B, C>, Quartet<D, E, F, G>, Septet<A, B, C, D, E, F, G>> toSeptetFromTriplet() {
        return new Func2<Triplet<A, B, C>, Quartet<D, E, F, G>, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> call(Triplet<A, B, C> objects,
                                                    Quartet<D, E, F, G> objects2) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects2.getValue0(), objects2.getValue1(), objects2.getValue2(),
                        objects2.getValue3());
            }
        };
    }

    public static <A, B, C, D, E, F, G> Func2<Quartet<A, B, C, D>, Triplet<E, F, G>, Septet<A, B, C, D, E, F, G>> toSeptetFromQuartet() {
        return new Func2<Quartet<A, B, C, D>, Triplet<E, F, G>, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> call(Quartet<A, B, C, D> objects,
                                                    Triplet<E, F, G> objects2) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects2.getValue0(), objects2.getValue1(),
                        objects2.getValue2());
            }
        };
    }

    public static <A, B, C, D, E, F, G> Func2<Quintet<A, B, C, D, E>, Pair<F, G>, Septet<A, B, C, D, E, F, G>> toSeptetFromQuintet() {
        return new Func2<Quintet<A, B, C, D, E>, Pair<F, G>, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> call(Quintet<A, B, C, D, E> objects,
                                                    Pair<F, G> objects2) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects2.getValue0(),
                        objects2.getValue1());
            }
        };
    }

    public static <A, B, C, D, E, F, T> Func2<Sextet<A, B, C, D, E, F>, T, Septet<A, B, C, D, E, F, T>> toSeptetFromSextet() {
        return new Func2<Sextet<A, B, C, D, E, F>, T, Septet<A, B, C, D, E, F, T>>() {
            @Override
            public Septet<A, B, C, D, E, F, T> call(Sextet<A, B, C, D, E, F> objects, T t) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects.getValue5(), t);
            }
        };
    }

    /* Octet */
    public static <A, B, C, D, E, F, G, H> Func8<A, B, C, D, E, F, G, H, Octet<A, B, C, D, E, F, G, H>> toOctet() {
        return new Func8<A, B, C, D, E, F, G, H, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> call(A a, B b, C c, D d, E e, F f, G g, H h) {
                return Octet.with(a, b, c, d, e, f, g, h);
            }
        };
    }


    public static <A, B, C, D, E, F, G, T> Func2<T, Septet<A, B, C, D, E, F, G>, Octet<T, A, B, C, D, E, F, G>> toOctetFromSingle() {
        return new Func2<T, Septet<A, B, C, D, E, F, G>, Octet<T, A, B, C, D, E, F, G>>() {
            @Override
            public Octet<T, A, B, C, D, E, F, G> call(T t, Septet<A, B, C, D, E, F, G> objects) {
                return Octet.with(t, objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects.getValue5(),
                        objects.getValue6());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> Func2<Pair<A, B>, Sextet<C, D, E, F, G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromPair() {
        return new Func2<Pair<A, B>, Sextet<C, D, E, F, G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> call(Pair<A, B> objects,
                                                      Sextet<C, D, E, F, G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2(), objects2.getValue3(),
                        objects2.getValue4(), objects2.getValue5());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> Func2<Triplet<A, B, C>, Quintet<D, E, F, G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromTriplet() {
        return new Func2<Triplet<A, B, C>, Quintet<D, E, F, G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> call(Triplet<A, B, C> objects,
                                                      Quintet<D, E, F, G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects2.getValue0(), objects2.getValue1(), objects2.getValue2(),
                        objects2.getValue3(), objects2.getValue4());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> Func2<Quartet<A, B, C, D>, Quartet<E, F, G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromQuartet() {
        return new Func2<Quartet<A, B, C, D>, Quartet<E, F, G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> call(Quartet<A, B, C, D> objects,
                                                      Quartet<E, F, G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects2.getValue0(), objects2.getValue1(),
                        objects2.getValue2(), objects2.getValue3());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> Func2<Quintet<A, B, C, D, E>, Triplet<F, G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromQuintet() {
        return new Func2<Quintet<A, B, C, D, E>, Triplet<F, G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> call(Quintet<A, B, C, D, E> objects,
                                                      Triplet<F, G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> Func2<Sextet<A, B, C, D, E, F>, Pair<G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromSextet() {
        return new Func2<Sextet<A, B, C, D, E, F>, Pair<G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> call(Sextet<A, B, C, D, E, F> objects,
                                                      Pair<G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects.getValue5(),
                        objects2.getValue0(), objects2.getValue1());
            }
        };
    }

    public static <A, B, C, D, E, F, G, T> Func2<Septet<A, B, C, D, E, F, G>, T, Octet<A, B, C, D, E, F, G, T>> toOctetFromSeptet() {
        return new Func2<Septet<A, B, C, D, E, F, G>, T, Octet<A, B, C, D, E, F, G, T>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, T> call(Septet<A, B, C, D, E, F, G> objects, T t) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects.getValue5(),
                        objects.getValue6(), t);
            }
        };
    }
}
