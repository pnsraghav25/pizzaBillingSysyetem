import java.util.*;
import java.io.*;
import P1.*;
// import java.lang.*;
class thread implements Runnable
{
    Thread t;
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("Press Enter to pay the Amount");
            String k=sc.nextLine();
            System.out.println("Give your Amount to the Accountant");
            Thread.sleep(2000);
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("-------------------------------Thanks for Payment----------------------------------");
            System.out.println("-------------------------Thanks for visiting Come Again----------------------------");
            FileWriter fptr = new FileWriter("Bill.txt", false); 
            PrintWriter fptr2 = new PrintWriter(fptr, false);
            fptr2.flush();
            fptr2.close();
            fptr.close();
            System.out.println("-----------------------------------------------------------------------------------");
            System.exit(0);
            
        }
        catch (Exception e) 
        {
            System.out.println("Thread interuptted!");
        }
    }
}
interface calcost
{
    double cost(double price,double count);
}
class Error extends Exception
{
    Error(String str)
    {
        System.out.println(str);
    }
}
class customer
{
    double bill=0;
}
class pizza
{
    Scanner sc = new Scanner(System.in);
    String size;
    int num;
    double price,count;
    void get_info()
    {
        int p_type,p;
        String st1="";
    System.out.println("Choose the type of pizza 1.Veg or 2.Non-Veg: ");
                    p_type=sc.nextInt();
                    System.out.println("Choose the pizza you want: ");
                    p=sc.nextInt();
                    if(p_type==1)
                    {
                        if(p==1)
                        {
                            st1="Margarita";
                        }
                        if(p==2)
                        {
                            st1="Paneer Tandoori";
                        }
                        if(p==3)
                        {
                            st1="Mushroom";
                        }
                        if(p==4)
                        {
                            st1="Farm House";
                        }
                    }
                    else if(p_type==2)
                    {
                        if(p==1)
                        {
                            st1="Chicken";
                        }
                        if(p==2)
                        {
                            st1="BBQ";
                        }
                        if(p==3)
                        {
                            st1="Cubed Chicken Tikka";
                        }
                        if(p==4)
                        {
                            st1="Chicken Overload";
                        }
                    }
        System.out.println("Choose the size of pizza: ");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t1----->Small\n\t\t\t\t\t2----->Medium\n\t\t\t\t\t3----->Large");
        System.out.println("----------------------------------------------------------------------------------------------");
        num=sc.nextInt();
        if(num==1)
        {
            size="Small";
            price=300;
        }
        else if (num==2)
        {
            size="Medium";
            price=400;
        }
        else if (num==3)
        {
            size="Large";
            price=500;
        }
        else
        {
            System.out.println("Order not added as specified size not available try again!");
            return;
        }
        System.out.println("Enter the count: ");
        count=sc.nextInt();
        String str1=String.valueOf(price);
        String str3=String.valueOf(count);
        try {
            BufferedWriter fptr = new BufferedWriter(new FileWriter("Bill.txt", true));
            fptr.write(str1);
            fptr.write(",");
            fptr.write(str3);
            fptr.write(",");
            fptr.write(size);
            fptr.write(",");
            fptr.write(st1);
            fptr.write("\n");
            fptr.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        System.out.println("Your order Sucessfully added...");
    }
    void Display()
    {
        try {
            File fptr = new File("Bill.txt");
            Scanner sc = new Scanner(fptr);
            String Str= sc.nextLine();
            int i=1;
            while(Str!=null)
            {
                System.out.println("------------------------------------------Item - "+i+"------------------------------------------");
                String[] s = Str.split(",");
                System.out.println("\t\t\t\t  Size of Pizza: "+s[2]);
                System.out.println("\t\t\t\t  Pizza Name: "+s[3]);
                System.out.println("\t\t\t\t  Quantity: "+s[1]);
                System.out.println("\t\t\t\t  Cost per peice: "+s[0]);
                i++;
                Str= sc.nextLine();
            }
        } 
        catch (NoSuchElementException e)
        {
                System.out.print("");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
    calcost rate = (price,count) ->
    {
        return price*count;
    };
}
public class pizzaden
{
    public static void main(String[] args) throws Error {
        int choice;
        
        try (Scanner sc = new Scanner(System.in)) 
        {
            Customer c = new Customer();
            c.menu();
            System.out.println("-------------------------------Welcome to Pizza Hut-------------------------------");
            customer c1 = new customer();
            pizza p1= new pizza();
            while(true)
            {
                System.out.println("Choose from one of the following options: ");
                System.out.println("1.Buy a Pizza\n2.Display your order\n3.Pay Bill\n4.To Make Transaction\n5.Exit");
                choice=sc.nextInt();
                switch(choice)
                {
                    case 1:
                        p1.get_info();
                        c1.bill+=p1.price*p1.count;
                        break;
                    case 2:
                        try{
                            if(c1.bill==0)
                            {
                                throw new Error("You Did not add Anything to cart Try adding items to cart...");
                            }
                            else
                            {
                                System.out.println("-------------------------------------Your Order Details-------------------------------------");
                                p1.Display();
                            }
                        }
                        catch (Exception e) 
                        {
                            System.out.print("");
                        }
                        break;
                    case 3:
                        try{
                            if(c1.bill==0)
                            {
                                throw new Error("You Did not add Anything to cart Try adding items to cart...");
                            }
                            else
                            {
                                System.out.println("The Amount you have to pay is :"+c1.bill);
                            }
                        }
                        catch (Exception e) 
                        {
                            System.out.print("");
                        }
                        break;
                    case 4: 
                        thread t1= new thread();
                        t1.run();
                    case 5:
                        System.exit(0);
                    default:
                    System.out.println("Enter a proper value");
                    break;
                }
                System.out.println("---------------------------------------------------------------------------------------------");
            }
        }
    }
}