import java.io.*;

public class FileWorker {

    static void write(File file, Zooclub zooclub) {
        try (BufferedWriter bw = new BufferedWriter((new FileWriter(file)))) {
            bw.write(zooclub.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void addition(File file, Zooclub zooclub) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.newLine();
            bw.write(zooclub.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void serialize(Zooclub zooclub, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos)) {
            outputStream.writeObject(zooclub);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deserialize(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Zooclub zoo = (Zooclub) ois.readObject();
            System.out.println(zoo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
