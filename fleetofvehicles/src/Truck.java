public class Truck extends Vehicle{
    private double loadCap;
    private double towCap;
    
    public Truck()
    {
        super();
        this.loadCap = 1.0;
        this.towCap = 1.0;
    }
    public Truck(String aM, double aC, String aO, double aL, double aT)//Parameterized Constructor
    {
        super(aM, aC, aO);
        this.setLoadCap(aL);
        this.setTowCap(aT);
    }
    public double getLoadCap()
    {
        return this.loadCap;
    }
    public double getTowCap()
    {
        return this.towCap;
    }
    public void setLoadCap(double aL)
    {
        if(aL >= 0)
            this.loadCap = aL;
        else
            this.loadCap = 1.0;
    }
    public void setTowCap(double aT)
    {
        if(aT >= 0)
            this.towCap = aT;
        else
            this.towCap = 1.0;
    }
    public String toString()
    {
        return super.toString()+"\nLoad Capacity: "+this.loadCap+"\nTowing Capacity: "+this.towCap;
    }
    public boolean equals(Truck aTR)
    {
        return aTR != null &&
                super.equals(aTR) &&
                this.loadCap == aTR.getLoadCap() &&
                this.towCap == aTR.getTowCap();
    }
}
