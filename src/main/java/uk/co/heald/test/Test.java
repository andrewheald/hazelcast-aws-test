package uk.co.heald.test;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Test {

    public static void main(String args[]) {

        try {
            Config cfg1 = new Config("config1");
            HazelcastInstance instance1 = Hazelcast.newHazelcastInstance(cfg1);
            Map<String, Date> map = instance1.getMap("test.data");
            String hostname = InetAddress.getLocalHost().getHostName();
            map.put(hostname, Calendar.getInstance().getTime());
            Map<String, Date> map1 = instance1.getMap("test.data");
            System.out.println(hostname);
            System.out.println(map1.get(hostname));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
