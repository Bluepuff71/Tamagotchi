package javatech.io;

import java.io.*;
import java.nio.file.Path;

/**
 * Handles binary i/o operations of class instances
 */
public class BinarySerialization{

    /**
     * Serializes the object of type {@code T} to the specified path.
     * @param object the object you are serializing
     * @param file the file to save to
     * @param <T> the {@code object} type
     * @throws IOException if an error occurs during serialization
     */
    public static <T extends Serializable> void Serialize(T object, File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(object);
        out.close();
        fileOut.close();
    }

    /**
     * Deserializes from a specified path to type {@code T}.
     * @param file the file to save to
     * @param <T> the returned object's type
     * @return the deserialized object
     * @throws IOException if an error occurs during deserialization
     * @throws ClassNotFoundException if the specified class {@code T} is not found
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T Deserialize(File file) throws IOException, ClassNotFoundException{
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        T tObj = (T) in.readObject();
        in.close();
        fileIn.close();
        return tObj;
    }
}
