package com.xzx.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/7, 007
 * Time: 14:52
 */
public class SayHelloImpl extends UnicastRemoteObject implements ISayHello {
    protected SayHelloImpl() throws RemoteException {
    }

    @Override
    public void sayHello() throws RemoteException {
        System.out.println("Hello Client");
    }
}
