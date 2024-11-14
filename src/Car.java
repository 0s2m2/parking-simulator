import java.util.HashMap;
import java.util.Map;

public class Car extends Thread {
    private final int carId;
    private final int gateId;
    private final int arrivalTime;
    private final int parkingDuration;
    private final ParkingLot parkingLot;
    private static final Map<Integer, Integer> gatesServings = new HashMap<>();

    public Car(int carId, int gateId, int arrivalTime, int parkingDuration, ParkingLot parkingLot) {
        this.carId = carId;
        this.gateId = gateId;
        this.arrivalTime = arrivalTime;
        this.parkingDuration = parkingDuration;
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        try {
            // Simulate car arrival time
            Thread.sleep(arrivalTime * 1000L);

            //.
            synchronized (gatesServings) {
                gatesServings.put(gateId, gatesServings.getOrDefault(gateId, 0) + 1);
            }

            String carInfo = "Car " + carId + " from Gate " + gateId;
            System.out.println(carInfo + " arrived at time " + arrivalTime);

            parkingLot.acquireSpot(carInfo);

            // Time of Car in Parking
            Thread.sleep(parkingDuration * 1000L);

            parkingLot.releaseSpot(carInfo, this.parkingDuration);
        } catch (InterruptedException e) {
            System.out.println("Car " + carId + " was interrupted.");
        }
    }

    //.
    public static void carsServedDetails(ParkingLot parkingLot) {
        System.out.println("Total Cars Served: " + parkingLot.getTotalCarsServed());
        System.out.println("Current Cars in Parking: " + parkingLot.parkedCars);

        for (Map.Entry<Integer, Integer> entry : gatesServings.entrySet()) {
            int gateID = entry.getKey();
            int carsServedInThisGate = entry.getValue();
            System.out.println("Gate " + gateID + " served " + carsServedInThisGate + " cars.");
        }
    }
}