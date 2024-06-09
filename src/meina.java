import java.io.*;
import java.time.LocalDate;

public class meina {
    private static final File myFile = new File("notebook.txt");

    public static void main(String[] args)  throws IOException {
        new meina();
    }
    private static void writeNote (String writeNode){
        LocalDate currentDate = LocalDate.now();
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(myFile, true);
            byte[] strToBytes = ("\n" + currentDate + " " + writeNode).getBytes();
            outputStream.write(strToBytes);

            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void readNote () throws IOException {
        System.out.print("------------------------\n");
        FileInputStream inputStream = new FileInputStream(myFile);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, bytesRead));
        }
        inputStream.close();
        System.out.print("\n------------------------");
    }
    public meina() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = "";
        while (!command.equals("#exit")) {
            System.out.print("\nВведите команду : ");
            command = reader.readLine();
            switch (command) {
                case "#write":
                    System.out.print("Введите новую запись: ");
                    String newRecord = reader.readLine();
                    writeNote(newRecord);
                    System.out.println("Запись добавлена");
                    break;
                case "#read":
                    readNote();
                    break;
                case "#exit":
                    System.out.println("Завершение работы Windows...");
                    break;
                default:
                    System.out.println("Неверная команда");
                    break;
            }
        }

    }
}
