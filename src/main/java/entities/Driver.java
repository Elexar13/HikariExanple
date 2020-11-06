package entities;

public class Driver {
    int id;
    String name;
    int truckId;


    public Driver(int id, String name, int truck_id) {
        this.id = id;
        this.name = name;
        this.truckId = truck_id;
    }

    public Driver() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String age) {
        this.name = age;
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truck_id) {
        this.truckId = truck_id;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                " name='" + name +
                " truck_id=" + truckId +"\n";
    }
}
