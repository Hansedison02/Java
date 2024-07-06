package JavaSimple;

import java.util.Random;

class Person
{
    private String name;
    public Person (String name)
    {
        this.name = name;
    }
    public String address;

    public String getAdress()
    {
        return address;
    }

    public void setAdress(String address)
    {

    }

    public String toString()
    {
        return "Person 1: " + name + "(" + address + ")";
    }
}