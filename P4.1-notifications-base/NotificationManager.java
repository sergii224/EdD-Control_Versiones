public class NotificationManager {

    public void send(String type, String message, String recipient) {

        if (type == null || message == null || recipient == null) {
            System.out.println("Error: parámetros inválidos");
            return;
        }

        System.out.println("LOG: intentando enviar notificación");

        NotificationService service = null;

        if (type.equals("email")) {
            service = new EmailService();
        } else if (type.equals("sms")) {
            service = new SMSService();
        } else if (type.equals("push")) {
            service = new PushService();
        }

        if (service != null) {
            service.send(message, recipient);
        } else {
            System.out.println("LOG: tipo de notificación no soportado");
        }
    }
}
