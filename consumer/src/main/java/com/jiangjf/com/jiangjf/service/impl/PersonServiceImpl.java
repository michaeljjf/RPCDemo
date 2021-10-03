package com.jiangjf.com.jiangjf.service.impl;

import com.jiangjf.com.jiangjf.service.PersonService;
import com.jiangjf.pojo.Person;
import com.jiangjf.service.MyPersonService;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.rmi.Naming;
import java.util.List;

/**
 * @author jiangjf
 * @date 2021/10/3
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public List<Person> show() {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.102.130:2181", 100000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("ZooKeeper连接成功！");
                }
            });
            byte[] result = zooKeeper.getData("/rpc/provider", false, null);
            MyPersonService myPersonService = (MyPersonService) Naming.lookup(new String(result));
            return myPersonService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
