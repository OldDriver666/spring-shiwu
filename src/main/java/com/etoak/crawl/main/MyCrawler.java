package com.etoak.crawl.main;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.etoak.crawl.link.LinkFilter;
import com.etoak.crawl.link.Links;
import com.etoak.crawl.page.Page;
import com.etoak.crawl.page.PageParserTool;
import com.etoak.crawl.page.RequestAndResponseTool;

public class MyCrawler {

    /**
     * 使用种子初始化 URL 队列
     *
     * @param seeds 种子 URL
     * @return
     */
    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++){
            Links.addUnvisitedUrlQueue(seeds[i]);
        }
    }


    /**
     * 抓取过程
     *
     * @param seeds
     * @return
     */
    public void crawling(String[] seeds) {

        //初始化 URL 队列
        initCrawlerWithSeeds(seeds);

        //定义过滤器，提取以 http://www.baidu.com 开头的链接
        LinkFilter filter = new LinkFilter() {
            public boolean accept(String url) {
                if (url.startsWith(""))
                    return true;
                else
                    return false;
            }
        };

        //循环条件：待抓取的链接不空且抓取的网页不多于 1000
        while (!Links.unVisitedUrlQueueIsEmpty()  && Links.getVisitedUrlNum() <= 1000) {

            //先从待访问的序列中取出第一个；
            String visitUrl = (String) Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null){
                continue;
            }

            //根据URL得到page;
            Page page = RequestAndResponseTool.sendRequstAndGetResponse(visitUrl);

            //对page进行处理： 访问DOM的某个标签
            Elements es = PageParserTool.select(page,"a");
            for (Element element : es) {
				if (element.toString().split("开发工程师").length > 1 && element.toString().split("target").length > 1) {
//					System.out.println(element.attr("href"));
//					String url = element.toString().split("href=\"")[1].split("\" onmousedown")[0];
					String url = element.attr("href");
					WebPageSource.getJob(url);
					//根据URL得到page;
//		            Page page1 = RequestAndResponseTool.sendRequstAndGetResponse(url);
//		            Elements es1 = PageParserTool.select(page,"p");
//		            System.out.println(es1);
				}
			}
//            if(!es.isEmpty()){
//                System.out.println("下面将打印所有a标签： ");
//                if (es.toString().split("工程师").length > 1) {
//                	System.out.println(es);
//                }
//            }
            

//            //将保存文件
//            FileTool.saveToLocal(page);
//
//            //将已经访问过的链接放入已访问的链接中；
//            Links.addVisitedUrlSet(visitUrl);

//            //得到超链接
//            Set<String> links = PageParserTool.getLinks(page,"img");
//            for (String link : links) {
//                Links.addUnvisitedUrlQueue(link);
//                System.out.println("新增爬取路径: " + link);
//            }
        }
    }


    //main 方法入口
    public static void main(String[] args) {
        MyCrawler crawler = new MyCrawler();
        crawler.crawling(new String[]{"https://www.lagou.com/jobs/list_%E9%AB%98%E7%BA%A7java%E5%B7%A5%E7%A8%8B%E5%B8%88?px=default&yx=15k-25k&city=%E6%B7%B1%E5%9C%B3#order"});
    }
}
