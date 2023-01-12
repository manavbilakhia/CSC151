package assignment;
import java.util.*;
public class Vehicles {

    private LinkedList<Integer> vehicles;
    private static final Integer maxSpeed = 90;
    private static final Integer minSpeed = 5;

    /** constructors */
    public Vehicles() {
        vehicles = new LinkedList<>();
    }

    /**
     *constructor which takes ArrayList of Integers as its parameter
     *@param arrayListVehicles of ArrayList of Integers
     */
    public Vehicles (ArrayList<Integer> arrayListVehicles) {

        vehicles = new LinkedList<>();
        Collections.sort(arrayListVehicles, Collections.reverseOrder());

        for (int i = 0; i < arrayListVehicles.size(); i++) {

            Integer vehicleSpeed = arrayListVehicles.get(i);
            String infoString = "add " + vehicleSpeed + " to " + i;

            if (vehicleSpeed < minSpeed)
                vehicleSpeed = minSpeed;
            else if (vehicleSpeed > maxSpeed)
                vehicleSpeed = maxSpeed;

            System.out.println(infoString);

            if (vehicles.size() != 0) {
                vehicleSpeed = vehicles.get(i - 1) - 1;

                if (vehicleSpeed < minSpeed)
                    vehicleSpeed = minSpeed;
            }

            vehicles.add(vehicleSpeed);
        }
    }

    /**
     * toString: displays vehicle list in the form of a String
     *
     * @return String
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < this.vehicles.size(); i++) {
            joiner.add(vehicles.get(i).toString());
        }
        return joiner.toString();
    }

    /**
     * addNewVehicle: Adds a new vehicle to the list based on speed and every other vehicle changes their speed
     * accordingly
     * @param speed
     * @param position
     */
    public void addNewVehicle(Integer speed, Integer position) {

        if (speed < minSpeed)
            speed = minSpeed;
        else if (speed > maxSpeed)
            speed = maxSpeed;

        if (position > vehicles.size()) {
            position = vehicles.size();
        }

        vehicles.add(position, speed);

        switch (position) {
            case 0:
                for (int i = position + 1; i < vehicles.size(); i++) {
                    Integer speedChange = vehicles.get(i - 1) - 1;
                    if (speedChange < minSpeed)
                        speedChange = minSpeed;
                    vehicles.set(i, speedChange);
                }
                break;
            default:
                if ( position == vehicles.size() - 1 ) {
                    Integer speedChange = vehicles.get(position - 1) - 1;
                    vehicles.set(position, speedChange);
                }
                else {
                    //System.out.println("made it into here");
                    Integer speedChange = vehicles.get(position - 1) - 1;
                    vehicles.set(position, speedChange);
                    for (int i = position + 1; i < vehicles.size(); i++) {
                        speedChange = vehicles.get(i - 1) -1;
                        if (speedChange < minSpeed)
                            speedChange = minSpeed;
                        vehicles.set(i, speedChange);
                    }
                }
        }

    }

    public static void main (String[] args) {
        Vehicles emptyList = new Vehicles();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(30);
        inputList.add(99);
        inputList.add(22);
        inputList.add(4);
        inputList.add(25);
        Vehicles fullList = new Vehicles(inputList);
        System.out.println("emptyList: " + emptyList);
        System.out.println("fullList" + fullList);
        fullList.addNewVehicle(20, 0);
        System.out.println("After adding 20 to position 0:\n" + fullList);
        fullList.addNewVehicle(30, 3);
        System.out.println("After adding 30 to position 3:\n" + fullList);
        fullList.addNewVehicle(100, 5);
        System.out.println("After adding 100 to position 5:\n" + fullList);
        fullList.addNewVehicle(70, 8);
        System.out.println("After adding 70 to position 8:\n" + fullList);
        fullList.addNewVehicle(8, 0);
        System.out.println("After adding 8 to position 0:\n" + fullList);
        fullList.addNewVehicle(100000, 0);
        System.out.println("After adding ten million thousand to position 0:\n" + fullList);

    }

}
