import java.util.Random;
import java.util.Scanner;

public class Collatz {
	
	public static void main(String[] Args) {
		
		Collatz c = new Collatz();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		
			System.out.println("Enter number: ");

			String number = sc.nextLine();
			
			if(number.equals("random")) {
				c.operation(new Random().nextInt(100000),1,0);
			}
			
			else {
				
				try {
					int num = Integer.parseInt(number);
					
					System.out.print("Sequence is: ");
					
					c.operation(num, 1,0);
					
					System.out.println("---------------------");
					
				}catch(Exception e) {
					System.out.println("Try an integer next time...");
				}
				
			}
		}
	}
	
	public int operation(int num, int max, int time) {
		
		time++;
		
		if(num == 1) {
			System.out.println("1");
			System.out.println("Max number is: " + max);
			System.out.println("It took "+(time-1)+" moves to fall down to 1.");
			return -1;
			
		}
		
		else if(num == 0) {
			System.out.println("End");
			System.out.println("Max number is: 0");
			System.out.println("It took ???"+" moves to fall down to 1.");
			return -1;
		}
		
		else if(num%2 == 1) {
			System.out.print(num + " | ");
			
			if(max < num) {
				max = num;
			}
			
			return operation(3*num+1, max, time);
		}
		else {
			
			System.out.print(num + " | ");
			
			if(max < num) {
				max = num;
			}
			
			return operation(num/2, max, time);
		}
	}
	
}

/*
 
v1.0:
It works

v1.1:
Max number is printed now

v1.2:
NOW WITH TRY-CATCH: It's error proof now! Also I added the random option

v1.3:
Time to fall down to 1 has been added
  
*/
