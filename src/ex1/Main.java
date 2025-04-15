package ex1;

import java.time.LocalDateTime;

class OrderProcessor {
    public void processOrder(String orderId) {
        try {
            // Логика обработки заказа...
            System.out.println("Заказ " + orderId + " обработан.");
        } catch (Exception e) {
            String errorTime = LocalDateTime.now().toString();
            System.out.println("[ERROR][" + errorTime + "] Ошибка обработки заказа: " + e.getMessage());
        }
    }
}

class PaymentProcessor {
    public void processPayment(String paymentId) {
        try {
            // Логика обработки платежа...
            System.out.println("Платеж " + paymentId + " обработан.");
        } catch (Exception e) {
            String errorTime = LocalDateTime.now().toString();
            System.out.println("[ERROR][" + errorTime + "] Ошибка обработки платежа: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder("ORD123");

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment("PAY456");
    }
}