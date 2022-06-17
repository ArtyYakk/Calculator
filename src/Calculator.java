import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String usr = sc.nextLine();
            try{
                String[] musr = usr.split(" ");
                double a = Double.parseDouble(musr[0]);
                double b = Double.parseDouble(musr[2]);
                switch (musr[1]){
                    case ("+"):
                        System.out.println(a + b);
                        break;
                    case ("-"):
                        System.out.println(a - b);
                        break;
                    case ("*"):
                        System.out.println(a * b);
                        break;
                    case ("/"):
                        if(Double.parseDouble(musr[2]) == 0){
                            throw new Exception("Error! Division by zero");
                            //break;
                        }
                        System.out.println(a / b);
                        break;
                    default:
                        throw new Exception("Operation Error!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Error! Not number");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
