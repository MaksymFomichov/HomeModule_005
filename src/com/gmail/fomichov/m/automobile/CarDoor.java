package com.gmail.fomichov.m.automobile;

public class CarDoor {
    private boolean door;
    private boolean window;

    public CarDoor() {
        this.door = false;
        this.window = false;
    }

    public CarDoor(boolean door, boolean window) {
        this.door = door;
        this.window = window;
    }

    public void openDoor() {
        if (door) {
            System.out.println("Дверь уже открыта!");
        } else {
            System.out.println("Дверь открылась!");
            door = true;
        }
    }

    public void closeDoor() {
        if (!door) {
            System.out.println("Дверь уже закрыта!");
        } else {
            System.out.println("Дверь закрылась!");
            door = false;
        }
    }

    public void invertDoor() {
        if (door) {
            door = false;
            System.out.println("Открытая дверь закрылась");
        } else {
            door = true;
            System.out.println("Закрытая дверь открылась!");
        }
    }

    public void openWindow() {
        if (window) {
            System.out.println("Окно уже открыто!");
        } else {
            System.out.println("Окно открылось!");
            window = true;

        }
    }

    public void closeWindow() {
        if (!window) {
            System.out.println("Окно уже закрыта!");
        } else {
            System.out.println("Окно закрылось!");
            window = false;
        }
    }

    public void invertWindow() {
        if (window) {
            window = false;
            System.out.println("Открытое окно закрылось");
        } else {
            window = true;
            System.out.println("Закрытое окно открылось!");
        }
    }

    public void statusDoor() {
        System.out.println("Дверь: " + door + "\nOкно: " + window);
    }

    public String statusDoorReturn() {
        String result = "дверь: " + door + " окно: " + window;
        return result;
    }
}
