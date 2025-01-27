public class Car extends Vehicle{
    private double mileage;
    private int passengers;
    
    public Car()
    {
        super();
        this.mileage = 1.0;
        this.passengers = 1;
    }
    public Car(String aM, double aC, String aO, double aMi, int aP)//Parameterized Constructor
    {
        super(aM, aC, aO);
        this.setMileage(aMi);
        this.setPassengers(aP);
    }
    public double getMileage()
    {
        return this.mileage;
    }
    public int getPassengers()
    {
        return this.passengers;
    }
    public void setMileage(double aMi)
    {
        if(aMi >= 0)
            this.mileage = aMi;
        else
            this.mileage = 1.0;
    }
    public void setPassengers(int aP)
    {
        if(aP >= 0)
            this.passengers = aP;
        else
            this.passengers = 1;
    }
    public String toString()
    {
        return super.toString()+"\nGas Mileage: "+this.mileage+"\nNumber of Passengers: "+this.passengers;
    }
    public boolean equals(Car aC)
    {
        return aC != null &&
                super.equals(aC) &&
                this.mileage == aC.getMileage() &&
                this.passengers == aC.getPassengers();
    }
}
