# Multithreaded Parking System Simulation

## Overview  
This project is a simulation of a parking system using **multithreading** and **semaphores** in Java. The parking lot has a limited number of parking spots and three gates through which cars can enter. The system manages concurrent arrivals and departures of cars while ensuring thread synchronization and avoiding race conditions.

---

## Objectives  
- **Thread Synchronization**: Use semaphores to manage access to parking spots.  
- **Concurrency Management**: Handle simultaneous car arrivals/departures without errors.  
- **Simulation Realism**: Cars arrive and park for specific durations based on input data.  
- **Status Reporting**: Track and display the number of parked cars and total cars served.  

---

## System Specifications  
- **Parking Spots**: 4 spots total.  
- **Gates**: 3 gates (Gate 1, Gate 2, Gate 3).  
- **Input File**: A `.txt` file defines car arrival times and parking durations.  

---

## Features  
- **Gate Simulation**: Each gate runs as a separate thread.  
- **Semaphore-Based Allocation**: Parking spots are managed using a counting semaphore.  
- **Real-Time Logging**: Detailed logs of car arrivals, departures, and waiting times.  
- **Final Report**: Summary of total cars served per gate and parking status.  

---

## Input and Output  

### Input File Format  
```plaintext
Gate 1, Car 0, Arrive 0, Parks 3  
Gate 1, Car 1, Arrive 1, Parks 4  
Gate 2, Car 5, Arrive 3, Parks 4  
...  
