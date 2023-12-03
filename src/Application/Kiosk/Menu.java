package Application.Kiosk;

import com.sun.jdi.event.MethodEntryEvent;

public class Menu {
    private int number;
    private String name;
    private int price;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
