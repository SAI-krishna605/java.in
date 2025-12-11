import java.util.Random;
import java.util.Scanner;

public class voting {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age:");
        int age = sc.nextInt();

        if (age < 18 & age>120) {
            System.out.println("You are not eligible to vote");
            return;  
        } else {
            System.out.println("You are eligible to vote");
        }
        System.out.println("Choose your party:");
        System.out.println("*. BJP");
        System.out.println("*. TRS");
        System.out.println("*. Congress");
        System.out.println("*. INC");
        System.out.print("Enter your vote : ");
        
        int vote = sc.nextInt();  

        Random rand = new Random();
        int bjpVotes = rand.nextInt(1000);
        int trsVotes = rand.nextInt(1000);
        int congressVotes = rand.nextInt(1000);
        int INCvotes = rand.nextInt(1000);
        switch (vote) {
            case 1: bjpVotes++; 
                    System.out.println("You voted for BJP");
                    break;
            case 2: trsVotes++; 
                    System.out.println("You voted for TRS");
                    break;
            case 3: congressVotes++; 
                    System.out.println("You voted for Congress");
                    break;
            case 4: INCvotes++; 
                    System.out.println("You voted for INC");
                    break;
            default:
                
        }

        System.out.println("\n--- Final Vote Count ---");
        System.out.println("BJP Votes      : " + bjpVotes);
        System.out.println("TRS Votes      : " + trsVotes);
        System.out.println("Congress Votes : " + congressVotes);
        System.out.println("INC Votes      : " + INCvotes);
        System.out.println("");
        if (bjpVotes > trsVotes && bjpVotes > congressVotes && bjpVotes > INCvotes) {
            System.out.println("Winner: BJP");
        } 
        else if (trsVotes > bjpVotes && trsVotes > congressVotes && trsVotes > INCvotes) {
            System.out.println("Winner: TRS");
        } 
        else if (congressVotes > bjpVotes && congressVotes > trsVotes && congressVotes > INCvotes) {
            System.out.println("Winner: Congress");
        }
        else if (INCvotes > bjpVotes && INCvotes > trsVotes && INCvotes > congressVotes) {
            System.out.println("Winner: INC");
        } 
        else {
            System.out.println("Result: Tie between parties");
        }

        System.out.println("THANK YOU FOR VOTING 🚩");
    }
}
