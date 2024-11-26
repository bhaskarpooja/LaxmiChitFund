import java.util.*;
class LaxmiChitFund
{

    static Scanner sc = new Scanner(System.in);
    static String user;
    static Long phone;
    static String add;
    static String type;
    static int pin;
    static double bal;
    static ArrayList<String> tran = new ArrayList<>();
    public static void main(String[] args)
    {
        for ( ; ; )
        {
           System.out.println();
           System.out.println("*********** WELCOME ************"); 
           System.out.println("         LAXMI CHIT FUND  ");
           System.out.println();
           System.out.println("1. New Account ");
           System.out.println("2. Login");
           System.out.println();
           System.out.print("Enter an option: ");
           int option = sc.nextInt();
           switch(option)
           {
            case 1: newAccount(); break;
            case 2: loginUser(); break;
            default:System.out.println("Wrong option entered"); 
            }
        }
    }
    public static void newAccount()
    {
        if(user!=null)
        {
            System.out.println();
            System.out.println("Account is Already created .Please Login ");
            return;
        }

        System.out.println();
        System.out.println("Account Creation");
        System.out.print("Username: ");
        sc.nextLine();
        user = sc.nextLine();
        System.out.print("Phone Number: ");
        phone = sc.nextLong();
        System.out.print("Address: ");
        sc.nextLine();
        add = sc.nextLine();
        System.out.print("Pin: ");
        pin = sc.nextInt();
        System.out.print("Account type: ");
        type =sc.next();
        System.out.print("Amount to be deposited: ");
        bal = sc.nextDouble();
        tran.add("Credited: "+ bal);
        System.out.println();
        System.out.println("Account Created");
    }

    public static void loginUser()
    {
        if(user!=null)
        {
            System.out.println();
            System.out.println("Login");
            System.out.print("Username: ");
            sc.nextLine();
            String user1 = sc.nextLine();
            System.out.print("Pin: ");
            int pin1 = sc.nextInt();
            if(user1.equals(user) && pin==pin1)
            {
                   features();
            }
            else{

                System.out.println();
                System.out.println("Wrong Cred");
                System.out.println();
            }
        }
        else{
            System.out.println("CREATE YOUR ACCOUNT FIRST");
        }
    }
    public static void features()
    {
        for ( ; ; )
        {
            System.out.println();
            System.out.println("Features ");
            System.out.println("1. Deposit Amount ");
            System.out.println("2. Debit Amount ");
            System.out.println("3. Check Balance");
            System.out.println("4. Transfer Amount ");
            System.out.println("5. Statement ");
            System.out.println("6. Edit Account ");
            System.out.println("7. Loan & More ");
            System.out.println("8. Logout ");
            System.out.println();
            System.out.println("Enter an option : ");
            int option = sc.nextInt();
            switch(option)
            {

            case 1: depositAmount(); break;
            case 2: debitAmount(); break;
            case 3: checkBalance(); break;
            case 4: transferAmount(); break;
            case 5:statement(); break;
            case 6:editAccount();break;
            case 7:Loan(); break;
            case 8:System.exit(0);
            default:System.out.println("Wrong option");
            }
            System.out.println();
        }
    }
    public static void statement()
    {
          System.out.println();
          System.out.println("Statement ");
          System.out.println();
          for (String i: tran) {
               System.out.println(i);
          }
          System.out.println();
    }
    public static void checkBalance()
    {
         System.out.println("Check Balance");

         System.out.println();
         System.out.print("Enter your pin :");
         int pin1 = sc.nextInt();
         if(pin==pin1)
         {
             System.out.println();
             System.out.println("Your account Balance is: "+bal+" rs");  
         }else{
             System.out.println();
             System.out.println("Wrong pin Entered");
              }
    }

    public static void depositAmount()
    {
        System.out.println();
        System.out.println("deposit Amount ");
        System.out.println();
        System.out.print("Enter an amount: ");
        double deposit = sc.nextDouble();
        bal = bal + deposit;
        tran.add("Credited: "+ deposit);
        System.out.println();
        System.out.println("Amount Deposited");

    }
    public static void debitAmount()
    {
         System.out.println("");
         System.out.println("Debit Amount ");
         System.out.println();
         System.out.print("Enter an amount: ");
         double debit = sc.nextDouble();
         System.out.print("Enter your pin: ");
         int pin1= sc.nextInt();

         if(pin==pin1)
         {
             if(debit<=bal)
             {
             	bal = bal - debit;
             	tran.add("Debited: "+ debit); System.out.println("Amount Debited ");
             }
             else
             {
             	System.out.println();
             	System.out.println("Insufficient Funds ");
             }
         }
         else{
         	System.out.println();
         	System.out.println("Wrong pin Entered");
         }
    }
    public static void transferAmount(){
         System.out.println("Enter account number of acc you want to transfer to");
         sc.nextLine();
         String accountno=sc.nextLine();
         System.out.print("Enter amount you want to transfer :");
         double transfer=sc.nextDouble();
         if(transfer<=bal){
             bal-=transfer;
             System.out.println(transfer+" rs transferred to "+ accountno +" successfully");
             tran.add("transferred: "+transfer);
         }
         else{
            System.out.println("Insufficient Balance");
         }
         
    }
    public static void editAccount(){
         for (; ; ) {
             
            System.out.println();
            System.out.println("Edit Account details");
            System.out.println("1. Username");
            System.out.println("2. Phone Number ");
            System.out.println("3. Address ");
            System.out.println("4. Pin ");
            System.out.println("5. Exit ");
            System.out.println();
            System.out.println("Enter an option : ");
            int option = sc.nextInt();
            switch(option)
            {

            case 1: 
                  System.out.print("Enter a new username:");
                  sc.nextLine();
                  String user1=sc.nextLine();
                  user=user1;
                  System.out.println("Username updated successfully");
                  break;
            case 2:              
                 System.out.print("Enter a new phone number:");
                 sc.nextLine();
                 long phone1=sc.nextLong();
                 phone=phone1;
                 System.out.println("Phone Number updated successfully");
                 break;
            case 3: 
                 System.out.print("Enter a new Address:");
                 sc.nextLine();
                 String add1=sc.nextLine();
                 add=add1;
                 System.out.println("address updated successfully");
                 break;
            case 4: 
                 System.out.print("Enter a new Pin:");
                 int pin1=sc.nextInt();
                 pin=pin1;
                 System.out.println("pin updated successfully");
                 break;
            case 5: return;
            default:System.out.println("Wrong option");
            }
        }
    }
    public static void Loan(){
        float monthlyRate=0,rate=0;
        double emi=0,interest=0;
        outerLoop:
        for (; ; ) {
        
            System.out.println("        ***** Loan Module *****");
            System.out.println();
            System.out.println("1. Education Loan ");
            System.out.println("2. Personal loan ");
            System.out.println("3. Home loan ");
            System.out.println("4. Car loan ");
            System.out.println("5.Exit ");
            System.out.println();
            System.out.println("Enter an option : ");
            int option = sc.nextInt();
            if (option == 5) {
            break outerLoop; 
            }
            System.out.print("Enter Loan amount : ");
            double loan=sc.nextDouble();
            System.out.print("Enter tenure in years : ");
            int tenure=sc.nextInt();
            switch(option)
            {
                case 1:
                    rate=6.5f;
                    monthlyRate = rate / (12 * 100);
                    emi=(loan * monthlyRate * Math.pow((1+monthlyRate),tenure*12))/(Math.pow((1+monthlyRate),tenure*12)-1) ;
                     interest=loan*(rate/100);
                    System.out.println("loan details: ");
                    System.out.println("Principle : "+loan);
                    System.out.println("Interest rate : "+rate+" %");
                    System.out.println("Monthly EMI : "+emi+" rs");
                    System.out.println("Total Interest payable : "+interest);
                    break;
                case 2:
                    rate=10.5f;
                    monthlyRate = rate / (12 * 100);
                    emi=(loan * monthlyRate * Math.pow((1+monthlyRate),tenure*12))/(Math.pow((1+monthlyRate),tenure*12)-1) ;
                     interest=loan*(rate/100);
                    System.out.println("loan details: ");
                    System.out.println("Principle : "+loan);
                    System.out.println("Interest rate : "+rate+" %");
                    System.out.println("Monthly EMI : "+emi+" rs");
                    System.out.println("Total Interest payable : "+interest);
                    break;
                case 3:
                    rate = 8.0f;
                    monthlyRate = rate / (12 * 100);
                    emi=(loan * monthlyRate * Math.pow((1+monthlyRate),tenure*12))/(Math.pow((1+monthlyRate),tenure*12)-1) ;
                    interest=loan*(rate/100);
                    System.out.println("loan details: ");
                    System.out.println("Principle : "+loan);
                    System.out.println("Interest rate : "+rate+" %");
                    System.out.println("Monthly EMI : "+emi+" rs");
                    System.out.println("Total Interest payable : "+interest);
                    break;
                case 4:
                    rate = 15.0f;
                    monthlyRate = rate / (12 * 100);
                    emi=(loan * monthlyRate * Math.pow((1+monthlyRate),tenure*12))/(Math.pow((1+monthlyRate),tenure*12)-1) ;
                    // String.format("%2f",emi);
                     interest=loan*(rate/100);
                    System.out.println("loan details: ");
                    System.out.println("Principle : "+loan);
                    System.out.println("Interest rate : "+rate+" %");
                    System.out.println("Monthly EMI : "+emi+" rs");
                    System.out.println("Total Interest payable : "+interest);
                    break;
                // case 5:
                // return;
                //     break outerLoop;
                default:
                System.out.println("Invalid option. Try again.");

            }
           
            
        }
    }
}