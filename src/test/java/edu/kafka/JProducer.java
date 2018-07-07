package edu.kafka;
 
 
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
 
 
public class JProducer implements Runnable
{
    private Producer<String, String> producer;
 
    public JProducer()
    {
        Properties props = new Properties();
 
        props.put("bootstrap.servers", ConfigureAPI.BROKER_LIST);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("request.required.acks", "-1");
 
        producer = new KafkaProducer<String, String>(props);
 
    }
 
    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        try
        {
            String data = "hello lmx!";
            producer.send(new ProducerRecord<String, String>(ConfigureAPI.TOPIC, data));
            System.out.println(data);
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.getStackTrace();
        }
        finally
        {
            producer.close();
        }
 
    }
 
    public static void main(String[] args)
    {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(new JProducer());
        threadPool.shutdown();
    }
 
}