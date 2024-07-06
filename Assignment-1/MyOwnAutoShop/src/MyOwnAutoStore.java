public class MyOwnAutoStore 
{
    public static void main(String[] args) 
    {
    Mobil car1 = new Mobil(200, 20000, "Red");
    System.out.println("Car Regular Price: $" + car1.getRegularPrice());
    System.out.println("Car Sale Price: $" + car1.getSalePrice());

    Truk truck1 = new Truk(180, 30000, "Blue", 3000);
    System.out.println("Truck Regular Price: $" + truck1.getRegularPrice());
    System.out.println("Truck Sale Price: $" + truck1.getSalePrice());

    Sedan sedan1 = new Sedan(220, 25000, "Green", 7);
    System.out.println("Sedan Regular Price: $" + sedan1.getRegularPrice());
    System.out.println("Sedan Sale Price: $" + sedan1.getSalePrice());
    }
}