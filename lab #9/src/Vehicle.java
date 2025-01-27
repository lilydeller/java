public class Vehicle {
    private String manuName;
    private double cylinders;
    private String ownersName;
    public Vehicle()
    {
        this.manuName = "none";
        this.cylinders = 6.0;
        this.ownersName = "none";
    }
    public Vehicle(String aM, double aC, String aO)//Parameterized Constructor
    {
        this.setManuName(aM);
        this.setCylinders(aC);
        this.setOwnersName(aO);
    }
    
    public String getManuName()
    {
        return this.manuName;
    }
    public double getCylinders()
    {
        return this.cylinders;
    }
    public String getOwnersName()
    {
        return this.ownersName;
    }    
    
    public void setManuName(String aM)
    {
        if(aM != null)
            this.manuName = aM;
        else
            this.manuName = "none";
    }
    public void setCylinders(double aC)
    {
        if(aC >= 0.0)
            this.cylinders = aC;
        else
            this.cylinders = 6.0;
    }
    public void setOwnersName(String aO)
    {
        if(aO != null)
            this.ownersName = aO;
        else
            this.ownersName = "none";
    }
    
    public String toString()
    {
        return "Manufacturer: "+this.manuName+"\nCylinders: "+this.cylinders+"\nOwner: "+this.ownersName;
    }
    public boolean equals(Vehicle retV)
    {
        return retV != null && 
                this.manuName == retV.getManuName() &&
                this.cylinders == retV.getCylinders() &&
                this.ownersName == retV.getOwnersName();
    }
}