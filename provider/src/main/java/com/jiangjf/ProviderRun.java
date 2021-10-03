package com.jiangjf;

import com.jiangjf.service.MyPersonService;
import com.jiangjf.service.impl.MyPersonServiceImpl;
import org.apache.zookeeper.*;

import java.nio.charset.StandardCharsets;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author jiangjf
 * @date 2021/10/3
 */
public class ProviderRun {
    public static void main(String[] args) {

        try {
            MyPersonService myPersonService = new MyPersonServiceImpl();
            LocateRegistry.createRegistry(8989);
            String url = "rmi://localhost:8989/myPersonService";
            Naming.bind(url, myPersonService);
            System.out.println("RMI服务启动成功！");

            ZooKeeper zooKeeper = new ZooKeeper("192.168.102.130:2181", 100000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("ZooKeeper连接成功！");
                }
            });

            String result = zooKeeper.create("/rpc/provider",
                    "rmi://localhost:8989/myPersonService".getBytes(StandardCharsets.UTF_8)
                    , ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            System.out.println("result = " + result);
            System.out.println("注册成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
