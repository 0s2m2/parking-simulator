import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ParkingLot {
    private final Semaphore parkingSpots;
    public int parkedCars = 0;
    private int totalCarsServed = 0;

    public ParkingLot(int totalSpots) {
        parkingSpots = new Semaphore(totalSpots);
    }

    public synchronized void parkCar(String carInfo, BufferedWriter bw) throws IOException {
        parkedCars++;
        totalCarsServed++;
        bw.write(carInfo + " parked. (Parking Status: " + parkedCars + " spots occupied)\n");
    }

    public synchronized void leaveCar(String carInfo, int parkDuration, BufferedWriter bw) throws IOException {
        parkedCars--;
        bw.write(carInfo + " left after " + parkDuration + " units of time (Parking Status: " + parkedCars + " spots occupied)\n");
    }

    public void acquireSpot(String carInfo, BufferedWriter bw) throws InterruptedException, IOException {
        if (parkingSpots.tryAcquire()) {
            parkCar(carInfo, bw);
        } else {
            bw.write(carInfo + " waiting for a spot\n");
            while (true) {
                if (parkingSpots.tryAcquire()) {
                    parkCar(carInfo, bw);
                    break;
                }
            }
        }
    }

    public void releaseSpot(String carInfo, int parkingDuration, BufferedWriter bw) throws IOException {
        leaveCar(carInfo, parkingDuration, bw);
        parkingSpots.release();
    }

    public int getTotalCarsServed() {
        return totalCarsServed;
    }
}
