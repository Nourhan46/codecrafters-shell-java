import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        // TODO: Uncomment the code below to pass the first stage

        while(true) {


            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if(command.equals("exit"))
                return;

            else if (command.contains("type"))
            {
                String c= command.substring(5);
                if(c.equals("exit") || c.equals("type") || c.equals("echo") )
                    System.out.println(c +" "+"is a shell builtin");
                else
                    System.out.println(c + " "+"not found");

            }
            else if(command.contains("echo"))
                System.out.println(command.substring(5));
           else
               System.out.println(command + ": command not found");
        }
    }
}
