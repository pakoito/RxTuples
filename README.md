#RxTuples

RxTuples is a library to smooth RxJava usage by adding simple Tuple creation functions.

##Rationale

Quite often when using RxJava you find the need to forward a value alongside the result of an operation, combine several values, or simply adding an external value to the current internal state of the chain. For this you either create ad-hoc types that may only be used locally, which is inefficient.

Other languages have the concept of a Tuple built into them, which is an in-place list of values. Lots of Java libraries implement their own concept of Tuple, being a Pair, a Point, or VecX types. This library uses [javatuples](http://www.javatuples.org/) in an attempt to unify them[.](https://imgs.xkcd.com/comics/standards.png) Javatuples are all "typesafe, immutable, iterable, serializable, comparable" classes  ranging from 1 to 10 elements.

##Usage

RxTuples come as lazily evaluated FuncN and its main use case is alongside the combineLatest, withLatestFrom, zip, and zipWith operators.

Zip a list element into a pair with their position:

    Observable.zip(Observable.from(myStringList), Observable.range(0, myStringList.size()), 
                   RxTuples.<String, Integer>toPair());

Merge the value of several hot observables:

    Observable.combineLatest(networkSubject(), bluetoothSubject(), compassSubject(), 
                             RxTuples.<NetworkStatus, BluetoothState, CompassPosition>toTriplet());

or more complicated cases

    Observable.just(Quintet.with(1, 2, 3, 4, 5))
              .zipWith(
                    Observable.just(Triplet.with(6, 7, 8)),
                    RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctetFromQuintet());


##License

Copyright (c) pakoito 2015

The Apache Software License, Version 2.0

See LICENSE.md