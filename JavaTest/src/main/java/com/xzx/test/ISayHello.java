package com.xzx.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/7, 007
 * Time: 14:51
 */
public interface ISayHello extends Remote {
    public void sayHello() throws RemoteException;
}
