import java.io.*;
import java.util.Scanner;

public class Calculator {
     public static final File file = new File("C:\\Users\\iakon\\IdeaProjects\\Calculator\\input.txt");
     public static final FileOutputStream fos;
     public static final Scanner sc;

     static {
        try {
            fos = new FileOutputStream("C:\\Users\\iakon\\IdeaProjects\\Calculator\\output.txt");
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static final PrintStream printStream = new PrintStream(fos);
    public static String as = null;
    public static String bs = null;
    public static String op = null;
    public static void main(String[] args) {

                try{
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
                    printStream.println(as + " " + op + " " + bs + " = " + "File not found");
                }
                catch (IOException ex){
                    System.out.println(as + " " + op + " " + bs + " = " + "Output error");
                    printStream.println(as + " " + op + " " + bs + " = " + "Output error");
                }
                catch (NumberFormatException ex){
                    System.out.println(as + " " + op + " " + bs + " = " + "Error! Not number");
                    printStream.println(as + " " + op + " " + bs + " = " + "Error! Not number");
                    main(null);
                }
                catch(Exception ex){
                    System.out.println(as + " " + op + " " + bs + " = " + ex.getMessage());
                    printStream.println(as + " " + op + " " + bs + " = " + ex.getMessage());
                    main(null);
                }
    }
}