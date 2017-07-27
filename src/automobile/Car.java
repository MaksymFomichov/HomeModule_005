package automobile;

import java.util.ArrayList;

public class Car {
    private String dataMade;
    private String typeEngine;
    private int maxSpeed;
    private double timeTo100;
    private int maxPeopleInside;
    private int currentPeopleInside;
    private int currentSpeed;
    public ArrayList<CarWheel> carWheels = new ArrayList<>();
    public ArrayList<CarDoor> carDoors = new ArrayList<>();


    public Car(String dataMade) {
        this.dataMade = dataMade;
    }

    public Car(String dataMade, String typeEngine, int maxSpeed, double timeTo100, int maxPeopleInside, int currentPeopleInside, int currentSpeed) {
        this.dataMade = dataMade;
        this.typeEngine = typeEngine;
        this.maxSpeed = maxSpeed;
        this.timeTo100 = timeTo100;
        this.maxPeopleInside = maxPeopleInside;
        this.currentPeopleInside = currentPeopleInside;
        this.currentSpeed = currentSpeed;

        for (int i = 0; i < 4; i++) {
            carDoors.add(new CarDoor());
            carWheels.add(new CarWheel());
        }
    }

    public Car() {

    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void plusOneManInCar() {
        if (currentPeopleInside == maxPeopleInside) {
            System.out.println("Невозможно посадить нового пасажира, все места заняты");
        } else {
            currentPeopleInside++;
            System.out.println("Добавлен 1 человек, на данный момент в машине -  " + currentPeopleInside + " человек");
        }
    }

    public void minusOneManOutCar() {
        if (currentPeopleInside > 0) {
            currentPeopleInside--;
            System.out.println("Высажен 1 человек, на данный момент в машине -  " + currentPeopleInside + " человек");
        } else {
            System.out.println("Невозможно высадить пасажира, машина пуста");
        }
    }

    public void clearCar() {
        if (currentPeopleInside > 0) {
            System.out.println("Машина пуста, высажено " + currentPeopleInside + " человек");
            currentPeopleInside = 0;
        } else {
            System.out.println("Невозможно высадить пассажиров, машина пуста");
        }
    }

    public void getDoorIndex(int index) {
        carDoors.get(index).statusDoor();
    }

    public void getWheelIndex(int index) {
        if (carWheels.size() == 0) {
            System.out.println("В машине колеса отсутсвуют");
        } else {
            carWheels.get(index).getDataWheel();
        }
    }

    public void deleteAllWheel() {
        carWheels.clear();
        System.out.println("Все колеса удалены");
    }

    public void plusWheel(int countWheel) {
        for (int i = 0; i < countWheel; i++) {
            carWheels.add(new CarWheel());
        }
        System.out.println("На данный момент установленно " + carWheels.size() + " колес");
    }

    public double getMaxSpeed() {
        if (currentPeopleInside <= 0) {
            System.out.println("Максимальная скорость равна 0, так как в машине нет пассажиров");
            return 0;
        } else {
            // получаем массив значений стертоси колес
            double valueWheel[] = new double[carWheels.size()]; // инициализируем массив
            for (int i = 0; i < valueWheel.length; i++) {
                valueWheel[i] = carWheels.get(i).getStatusWheel();
            }
            // получаем скорость
            double currentMaxSpeed = getMinValue(valueWheel) * maxSpeed;
            return currentMaxSpeed;
        }
    }

    private double getMinValue(double data[]) {
        double minValue = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] < minValue) {
                minValue = data[i];
            }
        }
       return minValue;
    }

    public void fullInfo() {
        System.out.println("дата выпуска: " + dataMade);
        System.out.println("тип двигателя: " + typeEngine);
        System.out.println("текущая максимальная скорость: " + getMaxSpeed());
        System.out.println("разгон до сотни: " + timeTo100);
        System.out.println("максимальная вместимость: " + maxPeopleInside);
        System.out.println("текущая вместимость: " + currentPeopleInside);
        System.out.println("текущая скорость: " + currentSpeed);
        System.out.println("состояние колес:");
        if (carWheels.size() == 0) {
            System.out.println("Колеса отсутсвуют");
        } else {
            for (int i = 0; i < carWheels.size(); i++) {
                System.out.println("    колесо " + (i + 1) + " - " + carWheels.get(i).getStatusWheel());
            }
        }
        System.out.println("состояние дверей:");
        for (int i = 0; i < carDoors.size(); i++) {
            System.out.println("    дверь " + (i + 1) + " - " + carDoors.get(i).statusDoorReturn());
        }


    }


}
