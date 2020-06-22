package com.homolangma.suspension;

import java.util.LinkedList;

/**
 * @author: Mr.Harry
 * @date : 2020/5/20 23:40
 * @title :
 */
public class RequestQueue {

    public LinkedList<Request> getQueue() {
        return queue;
    }

    public void setQueue(LinkedList<Request> queue) {
        this.queue = queue;
    }

    private LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest() {
        synchronized (queue) {

            while (queue.size() <= 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    System.out.println("e---R");
                    return null;
                }
            }
            Request request = queue.removeFirst();
            return request;
        }


    }

    public void putRequest(Request request) {
        synchronized (queue) {
            queue.addLast(request);
            queue.notifyAll();
        }
    }

}
