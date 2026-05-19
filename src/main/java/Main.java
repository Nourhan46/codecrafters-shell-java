import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        // TODO: Uncomment the code below to pass the first stage
        String path_commands = System.getenv("PATH");
        String path_command[] = path_commands.split(":");
        while(true) {


            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if(command.equals("exit"))
                return;

            else if (command.contains("type"))
            { int f=1;
                String c= command.substring(5);
                if(c.equals("exit") || c.equals("type") || c.equals("echo") ) {
                    System.out.println(c + " " + "is a shell builtin");
                    f=0;
                }
                if(f==1) {
                    for (int i = 0; i < path_command.length; i++) {
                        File file = new File(path_command[i], c);

                        if (file.exists() && file.canExecute()) {
                            f = 0;
                            System.out.println(c + " is " + file.getAbsolutePath());
                        }
                    }

                }

                if(f==1)
                    System.out.println(c + " "+"not found");

            }
            else if(command.contains("echo"))
                System.out.println(command.substring(5));
            int program_found=0;
            String[] commandParts = command.split(" ");
            String programName = commandParts[0];
            for (int i = 0; i < path_command.length; i++) {
                File file = new File(path_command[i], programName);

                if (file.exists() && file.canExecute()) {
                    program_found= 1;
                    break;
                }
            }
            if (program_found == 1) {
                ProcessBuilder processBuilder = new ProcessBuilder(commandParts);
                processBuilder.inheritIO();
                Process process = processBuilder.start();
                process.waitFor();
            }
           else
               System.out.println(command + ": command not found");
        }
    }
}
