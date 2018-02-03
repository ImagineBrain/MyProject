package com.xzx.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/7, 007
 * Time: 15:12
 */
public class SayHelloClient {
    public static void main(String[] args) {
        try {
            ISayHello sayHello = (ISayHello) Naming.lookup("rmi://localhost:8345/sayHello");
            sayHello.sayHello();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
