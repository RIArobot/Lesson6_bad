package ex7;

class EmailNotifier {
    public void sendEmail(String message) {
        System.out.println("Отправка email: " + message);
    }
}

class SMSNotifier {
    public void sendSMS(String message) {
        System.out.println("Отправка SMS: " + message);
    }
}


class AlertService {
    private EmailNotifier emailNotifier;
    private SMSNotifier smsNotifier;

    public AlertService() {
        this.emailNotifier = new EmailNotifier();
        this.smsNotifier = new SMSNotifier();
    }

    public void sendAlert(String message, String type) {
        if (type.equals("email")) {
            emailNotifier.sendEmail(message);
        } else if (type.equals("sms")) {
            smsNotifier.sendSMS(message);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AlertService alerts = new AlertService();
        alerts.sendAlert("Сервер упал!", "email");
        alerts.sendAlert("Сервер упал!", "sms");
    }
}