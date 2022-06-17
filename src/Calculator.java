import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usr = sc.nextLine();
        try{
            String[] musr = usr.split(" ");
            switch (musr[1]){
                case ("+"):
                    System.out.println(Double.parseDouble(musr[0]) + Double.parseDouble(musr[2]));
                    break;
                case ("-"):
                    System.out.println(Double.parseDouble(musr[0]) - Double.parseDouble(musr[2]));
                    break;
                case ("*"):
                    System.out.println(Double.parseDouble(musr[0]) * Double.parseDouble(musr[2]));
                    break;
                case ("/"):
                    if(Double.parseDouble(musr[2]) == 0){
                        throw new Exception("Error! Division by zero");
                        //break;
                    }
                    System.out.println(Double.parseDouble(musr[0]) / Double.parseDouble(musr[2]));
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
