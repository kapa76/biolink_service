package org.biolink.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class ThreadVacancy implements Callable<String> {

    private static final Logger logger =
            LoggerFactory.getLogger(ThreadVacancy.class);

    public ThreadVacancy() {
    }

    @Override
    public String call() throws Exception {
        return null;
    }
}
