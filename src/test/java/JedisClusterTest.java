
 
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
 
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
 
/**
 * Jedis集群测试
 * 
 * @author Switch
 * @data 2017年2月11日
 * @version V1.0
 */
public class JedisClusterTest {
    public static void main(String[] args) throws IOException {
        // 创建并填充节点信息
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.245.131", 6379));
        nodes.add(new HostAndPort("192.168.245.132", 6379));
        nodes.add(new HostAndPort("192.168.245.133", 6379));
        nodes.add(new HostAndPort("192.168.245.134", 6379));
        nodes.add(new HostAndPort("192.168.245.135", 6379));
        nodes.add(new HostAndPort("192.168.245.136", 6379));
 
        // 创建JedisCluster对象
        JedisCluster jedisCluster = new JedisCluster(nodes);
 
        // 使用jedisCluster操作redis
        String key = "jedisCluster";
        String setResult = jedisCluster.set(key, "hello redis!");
        System.out.println(setResult);
 
        String getResult = jedisCluster.get(key);
        System.out.println(getResult);
 
        // 关闭jedisCluster（程序执行完后才能关闭，内部封装了连接池）
        jedisCluster.close();
    }
}