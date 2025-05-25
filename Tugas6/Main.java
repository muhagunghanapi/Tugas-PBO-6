import java.util.Scanner;

interface Laptop {
    int MAX_VOL = 100;
    int MIN_VOL = 0;

    void powerOn();
    void powerOff();
    void volumeUp();
    void volumeDown();
}

class Acer implements Laptop {
    private int volume;
    private boolean isPowerOn;

    public Acer() {
        this.volume = 50;
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Laptop Acer menyala");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Laptop Acer mati");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn && volume < MAX_VOL) {
            volume += 10;
            System.out.println("Acer volume: " + volume);
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn && volume > MIN_VOL) {
            volume -= 10;
            System.out.println("Acer volume:" + volume);
        }
    }
}

class Toshiba implements Laptop {
    private int volume;
    private boolean isPowerOn;

    public Toshiba() {
        this.volume = 50;
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Laptop Toshiba menyala");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Laptop Toshiba mati");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn && volume < MAX_VOL) {
            volume += 10;
            System.out.println("Toshiba volume: " + volume);
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn && volume > MIN_VOL) {
            volume -= 10;
            System.out.println("Toshiba volume: " + volume);
        }
    }
}

class MacBook implements  Laptop {
    private  int volume;
    private  boolean isPowerOn;

    public MacBook() {
        this.volume = 50;
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("MacBook menyala");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("MacBook mati");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn && volume < MAX_VOL) {
             volume += 10;
             System.out.println("MacBook volume: " + volume);
        }
       
    }

    @Override
    public void volumeDown() {
        if (isPowerOn && volume > MIN_VOL) {
            volume -= 10;
            System.out.println("MacBook volume: " + volume);
        }
    }
}

class LaptopUser {
    private Laptop laptop;

    public LaptopUser(Laptop laptop) {
        this.laptop = laptop;
    }

    public void turnOnLaptop() {
        laptop.powerOn();
    }

    public void turnOffLaptop() {
        laptop.powerOff();
    }

    public void makeLaptopLouder() {
        laptop.volumeUp();
    }

    public void makeLaptopSilence() {
        laptop.volumeDown();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih Laptop: 1. Acer 2. Toshiba 3. MacBook");
        System.out.println("Masukkan pilihan (1/2/3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Laptop selectedLaptop;
        switch (choice) {
            case 1:
                selectedLaptop = new Acer();
                break;
            case 2:
                selectedLaptop =  new Toshiba();
                break;
            case 3:
                selectedLaptop = new MacBook();
                break;
            default:
                System.out.println("Pilihan tidak valid. Keluar...");
            return;
        }

        LaptopUser user = new LaptopUser(selectedLaptop);
        System.out.println("\nLaptop siap digunakan. Masukkan perintah:");

        while (true) {
            System.out.print("\nMasukkan perintah (ON/OFF/UP/DOWN/EXIT): ");
            String command = scanner.nextLine().toUpperCase();

            switch (command) {
                case "ON":
                    user.turnOnLaptop();
                    break;
                case "OFF":
                    user.turnOffLaptop();
                    break;
                case "UP":
                    user.makeLaptopLouder();
                    break;
                case "DOWN":
                    user.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Keluar dari program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Perintah tidak dikenal. Coba lagi.");
            }
        }
    }
}