package designPatterns.structural.facade;

public class Client {
    public static void main(String[] args) {
        TravelFacade travelFacade = new TravelFacade();
        travelFacade.book(TravelFacade.BookingType.HOTEL, new BookingInfo());
    }
}
