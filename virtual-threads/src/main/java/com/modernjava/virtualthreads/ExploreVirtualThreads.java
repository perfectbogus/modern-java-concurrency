package com.modernjava.virtualthreads;


import com.modernjava.util.CommonUtil;

import static com.modernjava.util.LoggerUtil.log;

public class ExploreVirtualThreads {

    public static void doSomeWork() {
        log("started doSomeWork");
        CommonUtil.sleep(1000);
        log("finished doSomeWork");
    }

    public static void main(String[] args) {
        var t1 = Thread.ofVirtual().name("t1");
        var t2 = Thread.ofVirtual().name("t2");

        t1.start(() -> {
            log("Run task1 in the background");
        });

        t2.start(ExploreVirtualThreads::doSomeWork);

        log("Program Completed!");

        CommonUtil.sleep(2000);


    }
}
