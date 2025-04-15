package ex6;


interface SmartHomeDevice {
    void turnOn();
    void turnOff();
    void adjustBrightness(int level);
    void setTemperature(int temp);
    void playMusic(String song);
    void lockDoor();
}


class SmartBulb implements SmartHomeDevice {
    private boolean isOn;
    private int brightness;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Лампочка включена");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Лампочка выключена");
    }

    @Override
    public void adjustBrightness(int level) {
        brightness = level;
        System.out.println("Яркость установлена на " + level + "%");
    }


    @Override
    public void setTemperature(int temp) {
        throw new UnsupportedOperationException("Лампочка не поддерживает температуру");
    }

    @Override
    public void playMusic(String song) {
        throw new UnsupportedOperationException("Лампочка не играет музыку");
    }

    @Override
    public void lockDoor() {
        throw new UnsupportedOperationException("Лампочка не может закрывать двери");
    }
}


class SmartThermostat implements SmartHomeDevice {
    private int temperature;

    @Override
    public void turnOn() {
        System.out.println("Термостат включен");
    }

    @Override
    public void turnOff() {
        System.out.println("Термостат выключен");
    }

    @Override
    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Температура установлена на " + temp + "°C");
    }


    @Override
    public void adjustBrightness(int level) {
        throw new UnsupportedOperationException("Термостат не регулирует яркость");
    }

    @Override
    public void playMusic(String song) {
        throw new UnsupportedOperationException("Термостат не играет музыку");
    }

    @Override
    public void lockDoor() {
        throw new UnsupportedOperationException("Термостат не закрывает двери");
    }
}

public class Main {
    public static void main(String[] args) {
        SmartHomeDevice bulb = new SmartBulb();
        SmartHomeDevice thermo = new SmartThermostat();

        bulb.turnOn();
        bulb.adjustBrightness(80);
        // bulb.setTemperature(20); // Выбросит исключение

        thermo.setTemperature(22);
        // thermo.playMusic("Song"); // Выбросит исключение
    }
}
