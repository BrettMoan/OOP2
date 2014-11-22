import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by andrew on 9/24/14.
 */
public class SerialBox implements Serializable {
    protected String name;
    protected String ip_address;
    protected boolean is_alive;

    /**
     * SerialBox Constructor
     * @param p_name
     * @param p_ip_address
     * @param p_is_alive
     */
    public SerialBox(String p_name, String p_ip_address, boolean p_is_alive) {
        name = p_name;
        ip_address = p_ip_address;
        is_alive = p_is_alive;
    }

    /**
     * SerialBox.serial_in() Function
     *
     * Reads JSON file and returns SerialBox object.
     *
     * @param filename
     * @return SerialBox object
     */
    public static SerialBox serial_in(String filename) {
        HashMap json;
        String name_in = null;
        String ip_address_in = null;
        boolean is_alive_in = false;

        try {
            File serialFile = new File(filename);
            FileInputStream fileStream = new FileInputStream(serialFile);
            JSONInputStream jsonIn = new JSONInputStream(fileStream);
            json = (HashMap) jsonIn.readObject();
            jsonIn.close();

            name_in = (String) json.get("name");
            ip_address_in = (String) json.get("ip_address");
            is_alive_in = (Boolean) json.get("is_alive");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SerialBox(name_in, ip_address_in, is_alive_in);
    }

    /**
     * SerialBox serial_out() Method
     *
     * Write SerialBox object to JSON file.
     *
     * @param filename
     */
    public void serial_out(String filename) {
        try {
            File serialFile = new File(filename);
            FileOutputStream fileStream = new FileOutputStream(serialFile);
            JSONOutputStream jsonOut = new JSONOutputStream(fileStream);
            jsonOut.writeObject(this);
            jsonOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * SerialBox printDemThings() Method
     *
     * Print attributes of SerialBox object.
     *
     */
    public void printDemThings() {
        System.out.println("NAME: " + this.name);
        System.out.println("IP: " + this.ip_address);
        System.out.println("ALIVE: " + this.is_alive);
    }

    public static void main(String[] args) {
        String load_json;
        String server_name;
        String server_ip_address;
        String server_alive_string;
        boolean server_alive = false;

        Scanner in = new Scanner(System.in);

        System.out.print("Load JSON? (y/n): ");
        load_json = in.nextLine();

        load_json = load_json.toLowerCase();

        if (load_json.equals("y") || load_json.equals("yes")) {
            try {
                SerialBox serialBoxIn = SerialBox.serial_in("serialbox.json");
                serialBoxIn.printDemThings();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        else {
            System.out.print("Server Name: ");
            server_name = in.nextLine();
            System.out.print("IP Address: ");
            server_ip_address = in.nextLine();
            System.out.print("Is server alive? (y/n): ");
            server_alive_string = in.nextLine();

            server_alive_string = server_alive_string.toLowerCase();

            if (server_alive_string.equals("y") || server_alive_string.equals("yes")) {
                server_alive = true;
            }

            SerialBox serialBoxTest = new SerialBox(server_name, server_ip_address, server_alive);
            serialBoxTest.serial_out("serialbox.json");
            serialBoxTest.printDemThings();
        }

/* !! IGNORE : Testing Code !!
 *       try {
 *           String jsonString = JSONUtilities.stringify(serialBoxTest);
 *           System.out.println(jsonString);
 *       } catch (JSONException e) {
 *           e.printStackTrace();
 *       }
 */
    }
}
