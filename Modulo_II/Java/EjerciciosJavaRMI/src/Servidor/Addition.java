package Servidor;

import beans.AdditionInterface;

import java.rmi.RemoteException;

public class Addition implements AdditionInterface {

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
