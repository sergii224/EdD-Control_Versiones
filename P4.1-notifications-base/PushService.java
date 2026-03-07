public class PushService implements NotificationService {

    @Override
    public void send(String message, String recipient) {
        System.out.println("Enviando push a " + recipient + ": " + message);
    }

}
