package com.grpc.warehouseService;

import com.grpc.stockCheckerService.InventoryServiceDiscovery;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class WareHouseServiceDiscovery {

    String host;
    int port;

    //option 1
    private static class MyServiceListener implements ServiceListener {

        private int port;
        private String host;
        private ServiceInfo serviceInfo;

        //First event is that service is added
        public void serviceAdded(ServiceEvent event) {
            // TODO Auto-generated method stub
            System.out.println("\nService Added " + event.getInfo());

        }

        public void serviceRemoved(ServiceEvent event) {
            // TODO Auto-generated method stub
            System.out.println("Service Removed " + event.getInfo());

        }

        //next event is that service is resolved
        //this is required in order to populate the
        //serviceInfo object
        public void serviceResolved(ServiceEvent event) {
            // TODO Auto-generated method stub
            System.out.println("Service Resolved " + event.getInfo());

            ServiceInfo serviceInfo = event.getInfo();

            //use setter below
            this.setServiceInfo(serviceInfo);

            //now do a few printouts
            System.out.println("host " + serviceInfo.getHostAddress());
            //this.setHost(serviceInfo.getHostAddress());
            System.out.println("port " + serviceInfo.getPort());
            this.setPort(serviceInfo.getPort());
            System.out.println("type " + serviceInfo.getType());
            System.out.println("name " + serviceInfo.getName());
            System.out.println("Computername " + serviceInfo.getServer());
            System.out.println("desc/properties " + serviceInfo.getNiceTextString());
            //System.out.println("desc/properties " + serviceInfo.);
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        //this getter allows the runjmDns method to get the serviceInof
        public ServiceInfo getServiceInfo() {
            return serviceInfo;
        }

        public void setServiceInfo(ServiceInfo serviceInfo) {
            this.serviceInfo = serviceInfo;
        }

    }

    //public static void main(String[] args) {
    public static ServiceInfo runjmDNS(String service_type) {

        int port = 0;
        ServiceInfo serviceInfo = null;
        // get an instance of jmDNS


        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            //will discover the service based on service type
            //String service_type = "_grpc._tcp.local";

            //need to listen for services added/removed etc.

            //jmdns.addServiceListener(service_type, new MyServiceListener());         //listen for specified type
            MyServiceListener msl = new MyServiceListener();
            jmdns.addServiceListener(service_type, msl);


            //sleep for 1 seconds
            Thread.sleep(1000);

            //now get the service info
            serviceInfo = msl.getServiceInfo();
            port = msl.getPort();
            System.out.println("This is the port retrieved from jmDNS: " + port);

            jmdns.close();


        } catch (UnknownHostException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        //pass the serviceInfo back to the client
        return serviceInfo;

    }
}
