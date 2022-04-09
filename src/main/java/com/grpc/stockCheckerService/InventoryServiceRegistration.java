package com.grpc.stockCheckerService;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InventoryServiceRegistration {
    public void register(int port, String serviceType, String serviceName, String serviceDescription) {
        try {
            //create instance of jmdns
            JmDNS jmDNS = JmDNS.create(InetAddress.getLocalHost());

            //build info to create service info object
            int servicePort = port;

            ServiceInfo serviceInfo = ServiceInfo.create(serviceType,serviceName,servicePort,serviceDescription);

            //register service
            jmDNS.registerService(serviceInfo);

            System.out.printf("jmDNS: registering service with type: %s and name: %s on port %d ", serviceType, serviceName, servicePort);

            //sleep for 10 seconds
            Thread.sleep(1000);
            System.out.println("\njmDNS: Service Registered");
        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
