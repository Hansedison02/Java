public class MyOwnAutoStore {
    public static void main(String[] args) {
        Mobil Starion = new Sedan(200, 20000, "#23242C", 7);
        System.out.println("Car Regular Price: $" + Starion.getRegularPrice());
        System.out.println("Car Sale Price: $" + Starion.getSalePrice());

        Truk Colt_Diesel = new Truk(180, 30000, "#FCFC40", 3000);
        System.out.println(Colt_Diesel);
        System.out.println("Truck Regular Price: $" + Colt_Diesel.getRegularPrice());
        System.out.println("Truck Sale Price: $" + Colt_Diesel.getSalePrice());

        Sedan GTO = new Sedan(220, 25000, "#C42B1C", 7);
        System.out.println("Sedan Regular Price: $" + GTO.getRegularPrice());
        System.out.println("Sedan Sale Price: $" + GTO.getSalePrice());
    }
}