import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Car extends Thread {
    private final int carId;
    private final int gateId;
    private final int arrivalTime;
    private final int parkingDuration;
    private final ParkingLot parkingLot;
    private static final Map<Integer, Integer> gatesServings = new HashMap<>();
    private final BufferedWriter bw;

    public Car(int carId, int gateId, int arrivalTime, int parkingDuration, ParkingLot parkingLot, BufferedWriter bw) {
        this.carId = carId;
        this.gateId = gateId;
        this.arrivalTime = arrivalTime;
        this.parkingDuration = parkingDuration;
        this.parkingLot = parkingLot;
        this.bw = bw;
    }

    @Override
    public void run() {
        try {
            // Simulate car arrival time
            Thread.sleep(arrivalTime * 1000L);

            synchronized (gatesServings) {
                gatesServings.put(gateId, gatesServings.getOrDefault(gateId, 0) + 1);
            }

            String carInfo = "Car " + carId + " from Gate " + gateId;
            bw.write(carInfo + " arrived at time " + arrivalTime + "\n");

            parkingLot.acquireSpot(carInfo, bw);

            // Time of Car in Parking
            Thread.sleep(parkingDuration * 1000L);

            parkingLot.releaseSpot(carInfo, this.parkingDuration, bw);
        } catch (InterruptedException | IOException e) {
            try {
                bw.write("Car " + carId + " was interrupted.\n");
            } catch (IOException ignored) {}
        }
    }

    public static void carsServedDetails(ParkingLot parkingLot, BufferedWriter bw) throws IOException {
        bw.write("Total Cars Served: " + parkingLot.getTotalCarsServed() + "\n");
        bw.write("Current Cars in Parking: " + parkingLot.parkedCars + "\n");

        for (Map.Entry<Integer, Integer> entry : gatesServings.entrySet()) {
            int gateID = entry.getKey();
            int carsServedInThisGate = entry.getValue();
            bw.write("Gate " + gateID + " served " + carsServedInThisGate + " cars.\n");
        }
        bw.flush();
    }
}
