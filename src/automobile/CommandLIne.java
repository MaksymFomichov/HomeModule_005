package automobile;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandLIne {
    private static ArrayList<Car> cars = new ArrayList<>();

    public void start() {
        System.out.println("Выберите пункт меню:");
        System.out.println("1 - Создать автомобиль");
        System.out.println("2 - Вывести данные об автомобиле");
        System.out.println("3 - Управление дверьми автомобиля");
        System.out.println("4 - Управление колесами автомобиля");
        System.out.println("0 - Выход");

        switch (checkInt()) {
            case 1:
                createAuto();
                break;
            case 2:
                showAuto();
                break;
            case 3:
                controlDoor();
                break;
            case 4:
                controlWheel();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Неверный выбор, повторите попытку!");
                start();
                break;
        }
    }

    private void createAuto() {
        System.out.println("Введите данные по " + (cars.size() + 1) + " авто");
        System.out.println("дата выпуска:");
        String dataMade = getString();
        System.out.println("тип двигателя:");
        String typeEngine = getString();
        System.out.println("максимальная скорость:");
        int maxSpeed = checkInt();
        System.out.println("разгон до сотни:");
        double timeTo100 = checkDouble();
        System.out.println("максимальная вместимость:");
        int maxPeopleInside = checkInt();
        System.out.println("количество людей в машине на данный момент:");
        int currentPeopleInside = checkInt();
        System.out.println("текущая скорость:");
        int currentSpeed = checkInt();
        cars.add(new Car(dataMade, typeEngine, maxSpeed, timeTo100, maxPeopleInside, currentPeopleInside, currentSpeed));
        start();
    }

    private void showAuto() {
        if (statusAuto()) {
            for (int i = 0; i < cars.size(); i++) {
                System.out.println("Автомобиль - " + (i + 1));
                cars.get(i).fullInfo();
                System.out.println();
            }
        } else {
            errorAuto();
        }
        start();
    }

    private void controlDoor() {
        if (statusAuto()) {
            int tempCar;
            if (cars.size() > 1) {
                System.out.println("В системе " + cars.size() + " машин, выберите машину в которой хотите производить действия с дверью:");
                tempCar = checkInt();
            } else {
                tempCar = 1;
            }
            System.out.println("В машине " + cars.get(tempCar - 1).carDoors.size() + " двери, выберите дверь с которой хотите проводить действия:");
            int tempDoor = checkInt();
            startDoor(tempCar - 1, tempDoor - 1);
        }
        start();
    }

    private void startDoor(int car, int door) {
        System.out.println("1 - открыть дверь");
        System.out.println("2 - закрыть дверь");
        System.out.println("3 - открыть окно");
        System.out.println("4 - закрыть окно");
        System.out.println("5 - обратное действие для двери");
        System.out.println("6 - обратное действие для окна");
        System.out.println("7 - информация о статусе двери и окна");
        System.out.println("0 - вернуться в главное меню");

        switch (checkInt()) {
            case 1:
                cars.get(car).carDoors.get(door).openDoor();
                controlDoor();
                break;
            case 2:
                cars.get(car).carDoors.get(door).closeDoor();
                controlDoor();
                break;
            case 3:
                cars.get(car).carDoors.get(door).openWindow();
                controlDoor();
                break;
            case 4:
                cars.get(car).carDoors.get(door).closeWindow();
                controlDoor();
                break;
            case 5:
                cars.get(car).carDoors.get(door).invertDoor();
                controlDoor();
                break;
            case 6:
                cars.get(car).carDoors.get(door).invertWindow();
                controlDoor();
                break;
            case 7:
                System.out.println(cars.get(car).carDoors.get(door).statusDoorReturn());
                controlDoor();
                break;
            case 0:
                start();
                break;
            default:
                System.out.println("Неверный выбор, повторите попытку!");
                controlDoor();
                break;
        }
    }


    private void controlWheel() {
        if (statusAuto()) {
            int tempCar;
            if (cars.size() > 1) {
                System.out.println("В системе " + cars.size() + " машин, выберите машину в которой хотите производить действия с колесами:");
                tempCar = checkInt();
            } else {
                tempCar = 1;
            }
            System.out.println("В машине " + cars.get(tempCar - 1).carWheels.size() + " колеса, выберите колесо с которой хотите проводить действия:");
            int tempWheel = checkInt();
            startWheel(tempCar - 1, tempWheel - 1);
        }
        start();
    }

    private void startWheel(int car, int wheel) {
        System.out.println("1 - заменить колесо");
        System.out.println("2 - стереть колесо");
        System.out.println("3 - состояние колеса");
        System.out.println("4 - снять все колеса");
        System.out.println("5 - добавить колеса");
        System.out.println("6 - получить максимальную скорость в зависимости от износа");
        System.out.println("0 - вернуться в главное меню");

        switch (checkInt()) {
            case 1:
                cars.get(car).carWheels.get(wheel).getNewWheel();
                controlWheel();
                break;
            case 2:
                System.out.println("Выедите процент стрирания ");
                int temp = checkInt();
                cars.get(car).carWheels.get(wheel).reWriteWheel(temp);
                controlWheel();
                break;
            case 3:
                System.out.println("Состояние колеса " + cars.get(car).carWheels.get(wheel).getStatusWheel());
                controlWheel();
                break;
            case 4:
                cars.get(car).deleteAllWheel();
                controlWheel();
                break;
            case 5:
                System.out.println("Введите количество колес для добавления к машине ");
                int tempWheel = checkInt();
                cars.get(car).plusWheel(tempWheel);
                controlWheel();
                break;
            case 6:
                cars.get(car).getMaxSpeed();
                controlWheel();
                break;
            case 0:
                start();
                break;
            default:
                System.out.println("Неверный выбор, повторите попытку!");
                controlWheel();
                break;
        }
    }

    // проверяем есть ли автомобиль
    private boolean statusAuto() {
        if (cars.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    // проверяем на целое число
    private int checkInt() {
        Scanner sc = new Scanner(System.in);
        int value;
        while (true) {
            try {
                value = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Только целое число!");
                sc.nextLine();
            }
        }
        return value;
    }

    // проверяем на дробное число
    private double checkDouble() {
        Scanner sc = new Scanner(System.in);
        double value;
        while (true) {
            try {
                value = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Только дробное число!");
                sc.nextLine();
            }
        }
        return value;
    }

    // читаем строку
    private String getString() {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        return value;
    }

    // выводим ошибку и запускаем заново
    private void errorAuto() {
        System.out.println("Нет ни одной машины в системе!\n");
        start();
    }
}
