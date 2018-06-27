import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CountWords {
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\tany\\Desktop\\ggg.txt");
		String str = read(file).toLowerCase();
		String[] array = new String[]{"数据库设计","设计模式","系统设计","架构设计","hibernate","nosql","springmvc","html","css"
				,"spring","mysql","oracle","redis","mongo","hbase","nginx","jquery","dubbo","cloud",
				"mybatis","netty","hadoop","jvm","mycat","zookeeper","linux","python","docker","git","svn","maven","gradle",
				"rabbitmq","p2p","团队","分布式","高并发","金融", "互联网","经验者优先","需求","沟通","设计","缓存","队列","消息","jsp","大数据",
				"boot","调优","多线程","activemq","uml"};
		
		Map<String,Integer> map = new TreeMap<String,Integer>();
		System.out.println("样本:"+str.split("5.").length);
		for (String word : array) {
			map.put( word, str.split(word).length);
			System.out.println(word + ":" + str.split(word).length);
		}
		System.out.println("----------------------*------------------------------");
		for (Entry<String,Integer> es : map.entrySet()) {
			System.out.println(es.getKey() + ":" + es.getValue());
		}
		System.out.println("----------------------*------------------------------");
		List<Map.Entry<String, Integer>> entryArrayList = new ArrayList<>(map.entrySet());
        Collections.sort(entryArrayList,new Comparator<Map.Entry<String,Integer>>() {  
            //升序排序  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                return o2.getValue().compareTo(o1.getValue());  
            }  
        });  
        System.out.println("----------------------*------------------------------");
        for (Map.Entry<String, Integer> entry : entryArrayList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("----------------------*------------------------------");
		
		
	
	}
	
	
	public static String read(File file){
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = br.readLine())!=null){
                sb.append(line);                
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                if(br!=null){
                    br.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return sb.toString();
        
    }
}
