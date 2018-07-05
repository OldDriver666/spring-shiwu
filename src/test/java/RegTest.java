
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.nio.CharBuffer;

public class RegTest {
	public static void main(String[] args)
    {

        //定义一个文章列表类。包含文章的网址和文章标题
        class ArticleList{
            String URLs;
            String title;

            public ArticleList(){}
            public ArticleList(String t,String u)
            {
                title=t;
                URLs=u;
                 
            }
                    
            public String toString()
            {
                return ("标题："+title+" 网址："+URLs+" ");
                
            }
        }
        //----------start---读取HTML文件至buff--------------------------------------------------------
        File file = new File("C:\\Users\\tany\\Desktop\\【深圳,Java高级开发工程师招聘，求职】-前程无忧.htm");
        BufferedReader reader = null;
        StringBuffer buff = new StringBuffer(); 
        try {
        System.out.println("以行为单位读取文件内容，一次读一整行：");
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
         
        int line = 1;
        //一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null){
        //显示行号
         buff.append(tempString+"/r/n");
        //System.out.println("line " + line + ": " + tempString);
        line++;
        }
     // System.out.println(buff.toString());
        reader.close();
        } catch (IOException e) {
        e.printStackTrace();
        } finally {
        if (reader != null){
        try {
        reader.close();
        } catch (IOException e1) {
        }
        }
        }

        //------------end--读取---------------------------------------------------------------------------
        
        ArrayList <ArticleList>  al=new ArrayList<ArticleList>();
        String s=buff.toString();
        System.out.println(s);//"</p><p style=height:14px><a href=http://jingjia.baidu.com>企业推广</a> | <a href=http://top.baidu.com>搜索风云榜</a> | <a href=/home.html>关于百度</a> | <a href=http://ir.baidu.com>About Baidu</a></p><p id=b>&copy;2008 Baidu <a href=http://www.baidu.com/duty>使用百度前必读</a> <a href=http://www.miibeian.gov.cn target=_blank>京ICP证030173号</a> <a href=http://www.hd315.gov.cn/beian/view.asp?bianhao=010202001092500412><img src=http://gimg.baidu.com/img/gs.gif></a></p></center></body></html><!--543ff95f18f36b11-->";
        String regex="<a.*?/a>";    
 
        Pattern pt=Pattern.compile(regex);
        //System.out.println(regex);
        Matcher mt=pt.matcher(s);
       // String includeString=".*baidu.com.*";//必须包含 字符串"baidu.com"
 
        while(mt.find())
        { 
            if(true)
            {
                  
                 //System.out.println(mt.group());
                
                 String s2=">[^<].*?[^>]</a>";//标题部分
                 String s3="href=\".*?\"";
                 
                  
                  Pattern pt2=Pattern.compile(s2);
                  Matcher mt2=pt2.matcher(mt.group());
                  Pattern pt3=Pattern.compile(s3);
                  Matcher mt3=pt3.matcher(mt.group());
                  while(mt2.find()&&mt3.find())
                  {
                      System.out.println("标题："+mt2.group().replaceAll(">|</a>",""));
                      System.out.println("网址："+mt3.group().replaceAll("href=|>",""));
                      String t=mt2.group().replaceAll(">|</a>","");
                      String u=mt3.group().replaceAll("href=|>","");
                      al.add(new ArticleList(t,u));
                  }
                  
            } 
            
        }//end while
        
        for(int i=0;i<al.size();i++)
        System.out.println(al.get(i));
        
        System.out.println("共有"+al.size()+"个结果"); 
    }
}