package com.jiangjf.service.impl;

import com.jiangjf.pojo.Person;
import com.jiangjf.service.MyPersonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangjf
 * @date 2021/10/3
 */
public class MyPersonServiceImpl extends UnicastRemoteObject implements MyPersonService {

    public MyPersonServiceImpl() throws RemoteException {
    }

    @Override
    public List<Person> findAll() throws RemoteException {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "张三丰"));
        persons.add(new Person(2, "张无忌"));
        return persons;
    }
}
