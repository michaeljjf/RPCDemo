package com.jiangjf.service;

import com.jiangjf.pojo.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author jiangjf
 * @date 2021/10/3
 */
public interface MyPersonService extends Remote {
    public List<Person> findAll() throws RemoteException;
}
