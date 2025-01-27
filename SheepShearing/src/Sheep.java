/*
 * LILY DELLER 
 */
class Sheep implements Comparable<Sheep> {
    String name;
    int shearingTime;
    int arrivalTime;
//constructor
    public Sheep(String name, int shearingTime, int arrivalTime) {
        this.name = name;
        this.shearingTime = shearingTime;
        this.arrivalTime = arrivalTime;
    }
//Compares two sheep based on shearing time and then name
    @Override
    public int compareTo(Sheep other) {
        if (this.shearingTime != other.shearingTime) {
            return this.shearingTime - other.shearingTime;
        } else {
            return this.name.compareTo(other.name);
        }
    }
    //String representation of the sheep

    @Override
    public String toString() {
        return name;
    }
}