import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.println("-------------");
        System.out.println("1.addition(+)");
        System.out.println("2.Substraction(-)");
        System.out.println("3.Multiplication(*)");
        System.out.println("4.Division(/)");

        System.out.println("Enter your choice from 1 to 4:");
        int choice = scanner.nextInt();

        System.out.println("Enter the first number:");
        double num1=scanner.nextDouble();

        System.out.println("Enter the second number:");
        double num2=scanner.nextDouble();

        double result =0;
        boolean validOperation=true;


        switch (choice) {
            case 1://Addition
                result=num1+num2;
                break;

            case 2://Subtraction
                result=num1-num2;
                break;

            case 3://Multiplication
                result=num1*num2;
                break;

            case 4://Division
                if(num2!=0){
                result=num1/num2;
                }else{
                    System.out.println("Invalid Operation");
                    validOperation=false;
                }
                break;
                default:
                System.out.println("Invalid Choice. Please try choice between 1 to 4");;
                validOperation=false;
        
        }

    //display the result if the choice is valid
    if (validOperation) {
        System.out.println("result:"+ result);
        
    }
    scanner.close();

        
        

        
    }

}
