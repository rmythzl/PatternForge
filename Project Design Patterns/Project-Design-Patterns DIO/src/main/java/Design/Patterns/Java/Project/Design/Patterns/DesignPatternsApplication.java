package Design.Patterns.Java.Project.Design.Patterns;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.jdi.request.EventRequestManager;

import Design.Patterns.Java.factory.NotificationFactory;
import Design.Patterns.Java.factory.NotificationService;
import Design.Patterns.Java.observer.EmailObserver;
import Design.Patterns.Java.observer.EventManager;
import Design.Patterns.Java.observer.SmsObserver;
import Design.Patterns.Java.singleton.ConfigService;

@SpringBootApplication
public class DesignPatternsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Testando Singleton
        ConfigService config1 = ConfigService.getInstance();
        ConfigService config2 = ConfigService.getInstance();

        System.out.println("Config inicial: " + config1.getConfig());

        config1.setConfig("nova-config");
        System.out.println("Config após alteração: " + config2.getConfig());

        System.out.println("São a mesma instância? " + (config1 == config2));

        // Testando Factory Pattern
        NotificationFactory factory = new NotificationFactory();

        NotificationService emailService = factory.getNotificationService("email");
        emailService.sendNotification("Seu pedido foi confirmado!");

        NotificationService smsService = factory.getNotificationService("sms");
        smsService.sendNotification("Seu código de verificação é 123456.");

        // Testando Observer Pattern
        EventRequestManager eventManager = (EventRequestManager) new EventManager();
        ((EventManager) eventManager).subscribe(new EmailObserver());
        ((EventManager) eventManager).subscribe(new SmsObserver());

        ((EventManager) eventManager).notifyObservers("Promoção lançada!");
    }
}
