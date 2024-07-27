import java.util.Random;
import java.util.Scanner;
public class NumberGame {

    public static void main(String args[]) {

        Random rdm = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO THE NUMBER GUESSING GAME!");
        System.out.println("************************************");
        System.out.println("RULES\n1. You have only 5 attempts to guess the correct number\n2. You have to guess number between 1-100 ");

        int round=0;
        int round_won =0;
        boolean choice = true;
        while (choice) {
            
            int random_number = rdm.nextInt(1, 101);

            int attempts = 1;
            int max_attempts = 5;
            while (attempts <= max_attempts) {


                System.out.print("guess the number : ");
                int guessed_number = sc.nextInt();

                if (random_number == guessed_number) {
                   
                    System.out.println("Congratulations! You guessed the number " + random_number + " in " + attempts + " attempts.");
                    round_won++;
                    break;
                } 
                else if (random_number < guessed_number) {
                    System.out.println("too high");
                } 
                else {
                    System.out.println("too low");
                }

                if(attempts==max_attempts){
                    System.out.println("you have run out of attempts , correct number was : "+random_number);
                }

                attempts++;
            }

            System.out.println("*************************************");
            System.out.print("do you want to play again (yes/no) : ");
            String option = sc.next();
            choice = option.equalsIgnoreCase("yes");
            round++;
        }

        System.out.println("Game over.. round played : "+round+" | round won : "+round_won);
        sc.close();
    }
}
