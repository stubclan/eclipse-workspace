import java.util.Scanner;

public class helloWorld {

	public static void main(String[] args) {
	String string1 = "Sujan";
    System.out.println("Hi, my name is " + string1);
    Scanner sc = new Scanner(System.in);
    System.out.println("what's your name?");
    String input = sc.nextLine();
    System.out.println("Nice to meet you, " + input);
    sc.close();
    }	
}
