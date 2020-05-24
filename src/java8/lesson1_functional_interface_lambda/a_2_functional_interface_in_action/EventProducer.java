package java8.lesson1_functional_interface_lambda.a_2_functional_interface_in_action;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EventProducer extends Thread {
    private List<Listener> listeners = new ArrayList<>();
    private int eventCounter;

    public EventProducer() {
    }

    @Override
    public void run() {
        while (true) {
            sleep();
           // System.out.println("New event");
            for (Listener listener : listeners) {
                listener.onEvent("New event " + (++eventCounter));
            }

        }
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void appendListener(Listener listener) {
        listeners.add(listener);
    }

    public static void main(String[] args) {
     //   showEventProducerBeforeJava8_1();
        showEventProducerJava8_2();
    }

    static class FirstListener implements Listener {

        @Override
        public void onEvent(String event) {
            System.out.println("Listener 1: '" + event + "'");
        }


    }

    private static void showEventProducerBeforeJava8_1() {
        var eventProducer = new EventProducer();
        eventProducer.start();
        eventProducer.appendListener(new FirstListener());
       /* eventProducer.appendListener(new Listener() {
            @Override
            public void onEvent(String event) {
                System.out.println("Listener 2: '" + event + "'");
            }
        });*/
    }

    private static void showEventProducerJava8_2() {
        var eventProducer = new EventProducer();
        eventProducer.start();
        eventProducer.appendListener(event -> System.out.println("Listener 2: '" + event + "'"));
    }
}
