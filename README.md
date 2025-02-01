Multithreaded Parking System Simulation
Overview
This project is a simulation of a parking system using multithreading and semaphores in Java. The parking lot has a limited number of parking spots and three gates through which cars can enter. The system manages the concurrent arrival and departure of cars, ensuring that the parking spots are allocated and released correctly using thread synchronization mechanisms.

Objectives
Thread Synchronization: Utilize threading and semaphores to manage access to the parking spots.

Concurrency Management: Ensure that the system handles concurrent arrivals and departures without errors.

Simulation Realism: Cars arrive at specific times and stay for predetermined durations, reflecting real-world timing.

Status Reporting: Implement a feature to report the number of cars currently parked and the total number of cars served over time.

System Specifications
Parking Spots: 4 spots available in total.

Gates: 3 gates (Gate 1, Gate 2, Gate 3).

Car Arrival: Each gate receives cars at different times, specified in an input file.

Features
Parking Lot Setup: The parking lot is initialized with 4 parking spots.

Gate Simulation: Car arrivals at three different gates are simulated using separate threads.

Car Threads: Each car is represented by a thread that attempts to enter the parking lot.

Semaphore Usage: Semaphores are used to manage the availability of parking spots and prevent race conditions.

Logging and Reporting: The system logs the activity of each car and reports the number of cars currently in the parking lot and the total number of cars served at the end of the simulation.

Input and Output
Input: The system reads and parses input from a text file that specifies the arrival times and parking durations for each car at each gate.

Output: The system outputs the status of each car (arrival, parking, waiting, departure) and the current parking status.
