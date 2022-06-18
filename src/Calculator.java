import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\iakon\\IdeaProjects\\Calculator\\input.txt");
            try{
                Scanner sc = new Scanner(file);
                String usr = sc.nextLine();
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
            catch (FileNotFoundException ex){
                System.out.println("File not found");
            }
            catch (NumberFormatException ex){
                System.out.println("Error! Not number");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
    }
}
