package com.xzx.test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/7, 007
 * Time: 15:00
 */
public class SayHelloServer {
    public static void main(String[] args){
        try {
            ISayHello sayHello = new SayHelloImpl();
            LocateRegistry.createRegistry(8345);
            Naming.bind("rmi://localhost:8345/sayHello", sayHello);
            System.out.println("Server Started");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
