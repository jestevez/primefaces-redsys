package com.example.redsys.web;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.slf4j.LoggerFactory;

public class RedSysDB {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(RedSysDB.class);
    static String path = "C:\\redsysdb\\";
    static String ext = ".ser";

    public static Order obtenerPedido(String name) {
        FileInputStream streamIn = null;
        try {
            streamIn = new FileInputStream(path + name + ext);
            ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
            Order order = (Order) objectinputstream.readObject();
            return order;
        } catch (IOException | ClassNotFoundException ex) {
            LOG.error("Exception {}", ex);
            return null;
        } finally {
            try {
                if (streamIn != null) {
                    streamIn.close();
                }
            } catch (IOException ex) {
                LOG.error("Exception {}", ex);
            }
        }
    }

    public static boolean guardarPedido(Order order, String name) {
        FileOutputStream fout = null;
        try {
            // Serializar en db local
            fout = new FileOutputStream(path + name + ext);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(order);
            return true;
        } catch (IOException ex) {
            LOG.error("Exception {}", ex);
            return false;
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException ex) {
                LOG.error("Exception {}", ex);
            }
        }
    }
}
