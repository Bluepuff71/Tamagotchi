package javatech.io;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

//TODO documentation
public class XMLSerialization {

    public static <T extends Serializable> void Serialize(T object, File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        XMLEncoder xmlEncoder = new XMLEncoder(fileOut);
        xmlEncoder.writeObject(object);
        xmlEncoder.close();
        fileOut.close();
    }

    public static <T extends Serializable> T Deserialize(File file) throws IOException, ClassNotFoundException{
        FileInputStream fileIn = new FileInputStream(file);
        XMLDecoder xmlDecoder = new XMLDecoder(fileIn);
        @SuppressWarnings("unchecked")
        T obj = (T) xmlDecoder.readObject();
        xmlDecoder.close();
        fileIn.close();
        return obj;
    }
}
