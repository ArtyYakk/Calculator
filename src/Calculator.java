import java.io.*;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\iakon\\IdeaProjects\\Calculator\\input.txt");
        FileOutputStream fos;
        PrintStream printStream = null;
        String as = null;
        String bs = null;
        String op = null;
                try{
                    Scanner sc = new Scanner(file);
                    fos = new FileOutputStream("C:\\Users\\iakon\\IdeaProjects\\Calculator\\output.txt");
                    printStream = new PrintStream(fos);
                    while(sc.hasNextLine()){
                        String usr = sc.nextLine();
                        String[] musr = usr.split(" ");
                        as = musr[0];
                        bs = musr[2];
                        op = musr[1];
                        double a = Double.parseDouble(as);
                        double b = Double.parseDouble(bs);
                        switch (musr[1]) {
                            case ("+") -> {
                                System.out.println(a + " + " + b + " = " + (a + b));
                                printStream.println(a + " + " + b + " = " + (a + b));
                            }
                            case ("-") -> {
                                System.out.println(a + " - " + b + " = " + (a - b));
                                printStream.println(a + " - " + b + " = " + (a - b));
                            }
                            case ("*") -> {
                                System.out.println(a + " * " + b + " = " + (a * b));
                                printStream.println(a + " * " + b + " = " + (a * b));
                            }
                            case ("/") -> {
                                if (Double.parseDouble(musr[2]) == 0) {
                                    throw new Exception("Error! Division by zero");
                                }
                                System.out.println(a + " / " + b + " = " + (a / b));
                                printStream.println(a + " / " + b + " = " + (a / b));
                            }
                            default -> throw new Exception("Operation Error!");
                        }
                    } //cycle end
                } //try end

                catch (FileNotFoundException ex){
                    System.out.println(as + " " + op + " " + bs + " = " + "File not found");
                    if(printStream != null){
                        printStream.println(as + " " + op + " " + bs + " = " + "File not found");
                    }
                }
                catch (IOException ex){
                    System.out.println(as + " " + op + " " + bs + " = " + "Output error");
                    printStream.println(as + " " + op + " " + bs + " = " + "Output error");
                }
                catch (NumberFormatException ex){
                    System.out.println(as + " " + op + " " + bs + " = " + "Error! Not number");
                    if(printStream != null) {
                        printStream.println(as + " " + op + " " + bs + " = " + "Error! Not number");
                    }
                }
                catch(Exception ex){
                    System.out.println(as + " " + op + " " + bs + " = " + ex.getMessage());
                    if(printStream != null) {
                        printStream.println(as + " " + op + " " + bs + " = " + ex.getMessage());
                    }
                }
    }
}
