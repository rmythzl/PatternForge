package Design.Patterns.Java.observer;


public class EmailObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("E-mail enviado: " + message);
    }
}