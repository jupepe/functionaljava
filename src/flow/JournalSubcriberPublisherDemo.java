package flow;

public class JournalSubcriberPublisherDemo {
    public static void main(String[] args) {
        JournalPublisher publisher = new JournalPublisher();

        JournalSubscriber<String> subscriber1 = new JournalSubscriber<>(
                "First Subscriber");
        JournalSubscriber<String> subscriber2 = new JournalSubscriber<>(
                "Second Subscriber");
        
        publisher.subscribe(subscriber1);

        publisher.subscribe(subscriber2);
        
        publisher.submit("The Guardian");
        publisher.submit("The New York Times");
        publisher.submit("The Washington Post");
        publisher.submit("The Sydney Morning Herald");
        publisher.submit("The Times of India");
        publisher.submit("China Daily");
        //publisher.submit("Keskisuomalainen"); // First Subscriber has error. java.lang.IllegalArgumentException: non-positive subscription request

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        publisher.close();
    }
}