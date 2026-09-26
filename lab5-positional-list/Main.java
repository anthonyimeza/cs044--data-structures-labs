

public class Main {
    public static void main(String[] args) {

        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        System.out.println("--- Travel Itinerary Test ---");

        Position<String> ny = itinerary.addLast("New York");
        Position<String> la = itinerary.addLast("Los Angeles");
        Position<String> rome = itinerary.addLast("Rome");
        System.out.println("--- Initial List---");

        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }

        System.out.println("\n--- Inserting Stop Test ---");
        Position<String> osaka = itinerary.addLast("Osaka");

        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }

        System.out.println("\n--- Adding stop in between Test ---");

        Position<String> london = itinerary.addBefore(rome, "London") ;

        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }


    }
}
