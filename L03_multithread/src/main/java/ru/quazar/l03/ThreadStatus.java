package ru.quazar.l03;

import java.util.Set;

class ThreadStatus {

    public static int getStatus() {
        int countThread = 0;
        Set< Thread > threadSet = Thread.getAllStackTraces().keySet();
        for (Thread t : threadSet)

        {
            if (t.getThreadGroup() == Thread.currentThread().getThreadGroup()) {
                System.out.println("Thread :" + t + ":" + "state:" + t.getState());
                ++countThread;
            }
        }

        return countThread;
    }
}
