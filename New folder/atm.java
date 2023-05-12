import java.util.Scanner;

public class atm {

    public static void main(String[] arg) {

        student st = new student();
        Scanner sc = new Scanner(System.in);
        int amn =0;
        int cas = 0;
        System.out.println("Enter PIN");
        int pin = sc.nextInt();
        if (pin == 7499) {
            System.out.println("To choose the option press the number before the choice");
            System.out.println("1:withdraw");
            System.out.println("2:Transaction History");
            System.out.println("3:Transfer");
            System.out.println("4:Deposit");
            System.out.println("5;quite");
            int cho = sc.nextInt();

            switch (cho) {
                case 1:
                    System.out.println("enter the amount to be withdraw");
                    cas = sc.nextInt();
                    if (amn > cas) {
                        amn = amn - cas;
                        System.out.println(cas + " amount withdrawed");
                        System.out.println("account balance=" + amn);
                        st.createData(cas);
                    } else {
                        System.out.println(" do not have sufficient amount");
                    }
                    break;
                case 2:
                    System.out.println(" Transaction history are");

                    st.readData();
                    break;
                case 3:
                    System.out.println("Enter the account number");
                    int acc = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the IFSC Code");
                    String fi = sc.nextLine();
                    System.out.println("Enter the amount to be send");
                    int ps = sc.nextInt();
                    if (amn > ps) {
                        System.out.println(ps + " Transfered to " + acc);
                        st.createData(ps);
                    } else {
                        System.out.println("Not have sufficient balance");
                    }
                    break;
                case 4:
                    System.out.println("Enter the amount to deposit ");
                    int dnm = sc.nextInt();
                    amn = amn + dnm;
                    st.createDatat(dnm);
                    System.out.println("You have amount " + dnm + " in your account ");
                    System.out.println("your balance is"+amn);
                    break;
                default:
                    System.out.println("Quit");
            }
        } else {
            System.out.println("You have enter wrong password");
        }
        sc.close();
    }
}
