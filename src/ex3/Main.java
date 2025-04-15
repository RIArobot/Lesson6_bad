package ex3;

import java.util.ArrayList;
import java.util.List;

class Order {
    public String eMail;
    public String id;
    public List items;

    public Order(String eMail, String id, List items) {
        this.eMail = eMail;
        this.id = id;
        this.items = items;
    }

    public String getCustomerEmail() {
        return eMail;
    }

    public String getId() {
        return id;
    }

    public List getItems() {
        return items;
    }
}

class OrderProcessor {
    public void processOrder(Order order) {
        // 1. Валидация заказа
        if (order == null || order.getItems().isEmpty()) {
            System.err.println("Ошибка: неверный заказ");
            return;
        }

        // 2. Сохранение в базу данных
        saveToDatabase(order);

        // 3. Отправка email
        sendConfirmationEmail(order.getCustomerEmail());

        // 4. Логирование
        System.out.println("Заказ обработан: " + order.getId());
    }

    private void saveToDatabase(Order order) {
        // Логика сохранения в БД...
        System.out.println("Заказ сохранен в БД: " + order.getId());
    }

    private void sendConfirmationEmail(String email) {
        // Логика отправки email...
        System.out.println("Email отправлен на: " + email);
    }
}

public class Main {
    public static void main(String[] args) {
        OrderProcessor op = new OrderProcessor();
        Order order = new Order("www@www", "1", new ArrayList<>());
        op.processOrder(order);
    }
}
