package flow;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class JournalSubscriber<T> implements Subscriber<T> {

    private Subscription subscription;
    private String name;
    private Integer counter;

    public JournalSubscriber(String name) {
        this.name = name;
        this.counter = 6;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println(name + " onSubscribe");
        this.subscription = subscription;
        subscription.request(this.counter);

    }

    @Override
    public void onNext(T item) {
        System.out.println(name + " got a message " + item.toString());
        subscription.request(this.counter--);

    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + " has error. " + throwable.toString());
    }

    @Override
    public void onComplete() {
        System.out.println(name + " has been completed");

    }

}
