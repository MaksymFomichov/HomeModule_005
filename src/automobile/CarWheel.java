package automobile;

public class CarWheel {
    private double statusWheel;
    private boolean correctValue = true;

    public CarWheel() {
        this.statusWheel = 1;
    }

    public CarWheel(double statusWheel) {
        if (statusWheel >= 0 && statusWheel <= 1) {
            this.statusWheel = statusWheel;
        } else {
            System.out.println("Значение износа выше или ниже предела 0-1");
            this.correctValue = false;
        }
    }

    public void getNewWheel() {
        if (correctValue) {
            if (statusWheel == 1) {
                System.out.println("Замена не требуется, шина и так новая");
            } else {
                statusWheel = 1;
                System.out.println("Замена произведена");
            }
        }
    }

    // делал от текущего состояния
    public void reWriteWheel(int persent) {
        if (persent >= 0 && persent <= 100) {
            if (correctValue) {
                double tempStatusWheel = statusWheel;
                statusWheel = statusWheel - (statusWheel * persent / 100);
                System.out.println("Начальное состояние: " + tempStatusWheel + "\nНужно стереть на: " + persent + "%\nТекущее состояние шины: " + statusWheel);
            }
        } else {
            System.out.println("Значение процента выходит за рамки 0-100");
        }
    }

    public double getStatusWheel() {
        return statusWheel;
    }

    public void getDataWheel(){
        System.out.println("Текущий статус износа: " + statusWheel);
    }
}
