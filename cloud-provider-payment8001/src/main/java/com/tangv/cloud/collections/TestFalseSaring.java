package com.tangv.cloud.collections;

/**
 * author:   tangwei
 * Date:     2021/8/29 13:53
 * Description:
 */
public class TestFalseSaring
{




    public

    static

    void
    main
            (
                    String
                            []
                            args
            )

            throws

            InterruptedException

    {

        testPointer
                (
                        new

                                Pointer
                                ());


    }




    private

    static

    void
    testPointer
            (
                    Pointer
                            pointer
            )

            throws

            InterruptedException

    {


        long
                start
                =

                System
                        .
                                currentTimeMillis
                                        ();


        Thread
                t1
                =

                new

                        Thread
                        (()

                                ->

                        {


                            for

                            (
                                    int
                                    i
                                    =

                                    0
                                    ;
                                    i
                                            <

                                            100000000
                                    ;
                                    i
                                            ++)

                            {

                                pointer
                                        .
                                        x
                                        ++;


                            }


                        });




        Thread
                t2
                =

                new

                        Thread
                        (()

                                ->

                        {


                            for

                            (
                                    int
                                    i
                                    =

                                    0
                                    ;
                                    i
                                            <

                                            100000000
                                    ;
                                    i
                                            ++)

                            {

                                pointer
                                        .
                                        y
                                        ++;


                            }


                        });



        t1
                .
                        start
                                ();

        t2
                .
                        start
                                ();

        t1
                .
                        join
                                ();

        t2
                .
                        join
                                ();




        System
                .
                        out
                .
                        println
                                (
                                        System
                                                .
                                                        currentTimeMillis
                                                                ()

                                                -
                                                start
                                );


        System
                .
                        out
                .
                        println
                                (
                                        pointer
                                );


    }

}



class Pointer {

    volatile long x;

    long p1, p2, p3, p4, p5, p6, p7;

    volatile long y;
}