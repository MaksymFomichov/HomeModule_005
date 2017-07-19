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
        }
    }

    public void closeDoor() {
        if (!door) {
            System.out.println("Дверь уже закрыта!");
        } else {
            System.out.println("Дверь закрылась!");
        }
    }

    public void invertDoor() {
        if (door) {
            door = false;
            System.out.println("Открытая дверь закрыась");
        } else {
            door = true;
            System.out.println("Закрытая дверь открылась!");
        }
    }

    public void openWindow() {
        if (door) {
            System.out.println("Окно уже открыто!");
        } else {
            System.out.println("Окно открылось!");
        }
    }

    public void closeWindow() {
        if (!door) {
            System.out.println("Окно уже закрыта!");
        } else {
            System.out.println("Окно закрылось!");
        }
    }

    public void invertWindow() {
        if (door) {
            door = false;
            System.out.println("Открытое окно закрылось");
        } else {
            door = true;
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
