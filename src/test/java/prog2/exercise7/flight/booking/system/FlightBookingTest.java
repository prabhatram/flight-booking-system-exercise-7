package prog2.exercise7.flight.booking.system;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Test;



public class FlightBookingTest 
{  
    
    @Test
    public void testing_Ticket_Details_Method(){
        
        int size = 3;
        
        FlightBooking fb = new FlightBooking(size);

        String [] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String [] gender = {"Male", "Female", "Other"};
        int [] age = {43, 32, 21};
        String [] seatsBooked = new String[size];

        for(int i=0; i<size; ++i){
            fb.setPassengerFullName(i, fullName[i]);
            fb.setPassengerGender(i, gender[i]);
            fb.setPassengerAge(i, age[i]);
        }

        fb.setTripSource("1");
        fb.setSourceAirport("1");

        fb.setTripDestination("1", "4");
        fb.setDestinationAirport("1", "4");

        fb.setTripType("1");

        fb.setBookingClass("3");

        for(int i=0; i<size; ++i){
            fb.setFlightSeats(i);
        }

        String sdepart = "2023-04-18";
        LocalDate departingOn = LocalDate.parse(sdepart);

        String returnD = "2023-05-21";
        LocalDate returningOn = LocalDate.parse(returnD);

        fb.setDepartureDate(departingOn);
        fb.setReturnDate(returningOn);

        fb.setDepartingTicketPrice(0, 3);
        
        fb.setReturnTicketPrice();

        fb.setTotalTicketPrice();

        for(int j=0, k=279; j<size; ++j, ++k){
            fb.setTicketNumber(j);
            seatsBooked[j]=fb.getFlightSeats(k);
        }

        fb.displayTripDetails(size);

        for(int k = 0; k<size; ++k){

            
            String details = fb.getTicketDetails(seatsBooked[k].replace("-Booked", ""));
            String result = details.toLowerCase().trim().replace(" ", "");
            
            
            String expected = "Passenger Name: " + fb.getPassengerFullName(k) + "\n" + 
            "\n" + "Source: NANJING (NANJING_LUKOU_INTERNATIONAL_AIRPORT)" + "\n" + 
            "Destination: HELSINKI (HELSINKI_AIRPORT)" + "\n" + 
            "Departure: 2023-04-18" + "\n" + "Return: 2023-05-21" + "\n" + 
            "Trip's Total Cost: " + fb.getTotalTicketPrice();

            String expectedResult = expected.toLowerCase().trim().replace(" ", "");

            assertEquals(expectedResult, result);
            
        }
        
    }

    @Test
    public void testing_Reminder_Queues(){

        int size = 3;
        
        FlightBooking fb = new FlightBooking(size);

        String [] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String [] gender = {"Male", "Female", "Other"};
        int [] age = {43, 32, 21};

        for(int i=0; i<size; ++i){
            fb.setPassengerFullName(i, fullName[i]);
            fb.setPassengerGender(i, gender[i]);
            fb.setPassengerAge(i, age[i]);
        }

        fb.setReminderQueue();
        
        LocalDate currentDay = LocalDate.now();
        LocalDate departingOn = currentDay.plusDays(3);

        for(int i=3, j=0; i>0; --i, j++){

            fb.getReminderQueue(departingOn.minusDays(j));

        }

        if(fb.reminderQ.size() == 0){
            assertEquals(1, 1);
        }
        else {
            assertEquals(1, 2);
        }
    }
      
}
