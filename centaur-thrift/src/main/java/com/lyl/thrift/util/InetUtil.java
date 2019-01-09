package com.lyl.thrift.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyl
 * Date 2019/1/9 11:09
 */
public class InetUtil {
    public static Set<String> getLocalHost(){
        Set<String> localAddress = new HashSet<>();
        try {
            Enumeration<NetworkInterface> interfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (interfaceEnumeration.hasMoreElements()){
                NetworkInterface ni = interfaceEnumeration.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()){
                    InetAddress nextElement = address.nextElement();
                    localAddress.add(nextElement.getHostAddress());
                    System.out.println("HostName="+nextElement.getAddress().toString());
                    System.out.println("HostName="+nextElement.getHostName());
                    System.out.println("HostAddress="+nextElement.getHostAddress());
                }

            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return localAddress;
    }

    public static void main(String[] args) {
        getLocalHost();
    }
}
