package P1;
import java.util.*;
public class Customer
{
    public void menu()
    {
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("Margarita");
        lst.add("Chicken");
        lst.add("Paneer Tikka");
        lst.add("BBQ");
        lst.add("Mushroom");
        lst.add("Cubed Chicken Tikka");
        lst.add("Farm House");
        lst.add("Chicken Overload");System.out.println("---------------------------------------Menu---------------------------------------");
        System.out.println("\t\tVegitarian\t\t|\tNon-Vegitarian\t\t");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\t\t1."+lst.get(0)+"\t\t|\t1."+lst.get(1)+"\t\t");
        System.out.println("\t\t2."+lst.get(2)+"\t\t|\t2."+lst.get(3)+"\t\t");
        System.out.println("\t\t3."+lst.get(4)+"\t\t|\t3."+lst.get(5)+"\t\t");
        System.out.println("\t\t4."+lst.get(6)+"\t\t|\t4."+lst.get(7)+"\t\t");
        System.out.println("");
    }
}