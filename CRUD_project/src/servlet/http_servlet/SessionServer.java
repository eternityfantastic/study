package servlet.http_servlet;

import model.Admin;

import java.io.*;
import java.util.UUID;

public class SessionServer {
    public static String put(Admin admin) throws IOException {
        String sessionId = UUID.randomUUID().toString();
        String filename = "会话\\" + sessionId;

        OutputStream os = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(admin);
        os.close();

        return sessionId;
    }

    public static Admin get(String sessionId) throws IOException, ClassNotFoundException {
        String filename = "会话\\" + sessionId;
        File file = new File(filename);
        if (!file.exists()) {
            return null;
        }

        InputStream is = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(is);
//        读出来是一个对象；
        Admin admin = (Admin)ois.readObject();
        is.close();

        return admin;
    }
}
