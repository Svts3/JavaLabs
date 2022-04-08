package ua.lviv.lab;
import ua.lviv.lab.devices.*;
public class Main {

    public static void main(String[] args) {
	
	Device laptop = new Laptop("Lenovo","legion",2000,2.4,"Ryzen 7 5600h","RTX 3060",
					16,512,72,17);
	System.out.println(laptop+"\n");
	
	
	Device phone = new Smartphone("Apple", "Iphone 13", 1700, 0.7, "A15 Bionic",
		"A15 Bionic",8 , 512, 8.6, 4000, 3);
	System.out.println(phone+"\n");
	Device pc = new PC("Lenovo","Tower",2100,5.7,"R5 5600x","RTX 3060",16,1000);
	System.out.println(pc);
	Device printer = new Printer("HP","LaserJet",700,5.5,"lazer",1);
	System.out.println(printer);
	Device calculator = new Calculator("Casio", "HL-815L", 10, 0.5, 12);
	System.out.println(calculator);
    }

}
