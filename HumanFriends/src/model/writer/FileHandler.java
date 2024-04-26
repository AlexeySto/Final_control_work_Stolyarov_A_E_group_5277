package model.writer;

import java.io.*;

public class FileHandler implements Writable{

    @Override
    public boolean save(Object object, String fileName) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(object);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Object load(String fileName) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
