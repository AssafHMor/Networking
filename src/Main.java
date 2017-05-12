/**
 * Created by Owner on 11/05/2017.
 */

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import javax.jnlp.IntegrationService;
import javax.swing.*;
public class Main {
    public static void main(String[] args) throws IOException {

            // Fetch local host
        InetAddress localhost = InetAddress.getLocalHost();

            // IPv4 usage
        byte[] ip = localhost.getAddress();

        boolean proceed = true;
        ArrayList<InetAddress > addressArray = new ArrayList<>();
        while (proceed) {
            // looping
            for (int i = 1; i <= 254; i++) {

                ip[3] = (byte) i;
                InetAddress address = InetAddress.getByAddress(ip);
                if (address.isReachable(500))
                    addressArray.add(address);

                else if (!address.getHostAddress().equals(address.getHostName()))
                    System.out.println(address);
                    ///JOptionPane.showMessageDialog(null,address + " - DNS lookup known..");
                else
                    System.out.println(address);
                    ///JOptionPane.showMessageDialog(null,address + " - the host address and the host name are same");
                System.out.println(addressArray);
            }
            String str = null;
            for (int i = 0; i< addressArray.size();i++){
                str.concat(addressArray.toString());
                System.out.println(str);
            }
            JOptionPane.showMessageDialog(null, str);

            if (JOptionPane.showConfirmDialog(null,"Do you wish to continue?",null,JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                proceed = false;
            else
                continue;
        }
    }

}

