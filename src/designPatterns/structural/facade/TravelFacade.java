package designPatterns.structural.facade;

public class TravelFacade {

    private FlightBooking flightBooking = new FlightBooking();
    private HotelBooking hotelBooking = new HotelBooking();
    private TrainBooking trainBooking = new TrainBooking();

    public enum BookingType {
        FLIGHT, HOTEL, TRAIN, FLIGHT_AND_HOTEL, TRAIN_AND_HOTEL;
    }

    public void book(BookingType type, BookingInfo info) {
        switch (type) {
            case FLIGHT:
                flightBooking.bookFlight(info);
                break;
            case HOTEL:
                hotelBooking.bookHotel(info);
                break;
            case TRAIN:
                trainBooking.bookTrain(info);
                break;
            case FLIGHT_AND_HOTEL:
                flightBooking.bookFlight(info);
                hotelBooking.bookHotel(info);
                break;
            case TRAIN_AND_HOTEL:
                trainBooking.bookTrain(info);
                hotelBooking.bookHotel(info);
                break;
        }
    }
}

class FlightBooking{
    public void bookFlight(BookingInfo info){
        System.out.println("Flight booked");
    }
}

class HotelBooking{

    public void bookHotel(BookingInfo info){
        System.out.println("Hotel booked");
    }
}

class TrainBooking{
    public void bookTrain(BookingInfo info){
        System.out.println("Train booked");
    }
}

class BookingInfo{
    String bookingId;
}


