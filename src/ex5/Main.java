package ex5;

abstract class PaymentProcessor {
    protected double balance;

    public PaymentProcessor(double initialBalance) {
        this.balance = initialBalance;
    }

    // Базовый метод для всех платежей
    public void processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        if (amount > balance) {
            throw new IllegalStateException("Недостаточно средств");
        }
        balance -= amount;
        System.out.println("Платеж на " + amount + " обработан. Остаток: " + balance);
    }

    public abstract void verifyAccount();
}

class CreditCardProcessor extends PaymentProcessor {
    public CreditCardProcessor(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void verifyAccount() {
        System.out.println("Проверка данных кредитной карты...");
    }
}

class CryptoProcessor extends PaymentProcessor {
    public CryptoProcessor(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void verifyAccount() {
        System.out.println("Проверка криптокошелька...");
    }

    @Override
    public void processPayment(double amount) {

        if (amount < 0.01) {
            throw new IllegalArgumentException("Минимальная сумма 0.01");
        }

        balance -= amount;
        System.out.println("Криптоплатеж на " + amount + " обработан. Остаток: " + balance);
    }
}

public class Main {
    public static void makePayment(PaymentProcessor processor, double amount) {
        processor.verifyAccount();
        processor.processPayment(amount); // Опасность: разное поведение подклассов
    }

    public static void main(String[] args) {
        PaymentProcessor creditCard = new CreditCardProcessor(1000);
        PaymentProcessor crypto = new CryptoProcessor(1000);

        makePayment(creditCard, 100); // Работает
        makePayment(crypto, 0.001);   // Выбросит исключение (неожиданно для базового класса)
        makePayment(crypto, 2000);    // Нарушение....
    }
}
