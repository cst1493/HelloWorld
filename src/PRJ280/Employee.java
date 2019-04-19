package PRJ280;

abstract class Employee //SuperClass
{
    //Creating the variables
    private String firstName;
    private String lastName;
    private int hour;
    private int pay;

    //Creating default constructor
    public Employee() //only constructor needed to set to default employee options.
    {
        this.firstName = "";
        this.lastName = "";
        hour = 0;
        pay = 0;
    }

    //Creating instance of Employee
    public Employee(String firstName, String lastName, int hour1, int pay1) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        hour = hour1;
        pay = pay1;
    }

    public String getfirstName() 
    {
        return firstName;
    }

    public void setfirstName(String setfirstName) {
        firstName = setfirstName;
    }

    public String getlastName() 
    {
        return lastName;
    }

    public void setlastName(String setlastName) {
        lastName = setlastName;
    }

    public int gethour() 
    {
        return hour;
    }

    public void sethour(int hour1) {
        hour = hour1;
    }
    
    public int getpay() {
        return pay;
    }
    
    public void setpay (int pay1) {
        pay = pay1;
    }
    
    public abstract double amountPaid();
    
}
