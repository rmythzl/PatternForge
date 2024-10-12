package Design.Patterns.Java.observer;

public class SmsObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("SMS enviado: " + message);
    }
}