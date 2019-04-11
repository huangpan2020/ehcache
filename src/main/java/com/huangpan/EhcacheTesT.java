package com.huangpan;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheTesT {
	
	public static String xmlPath = "ehcache.xml";  
	
	public static void main(String[] args) {
		/**
		 * 之前方式：
		 *  CacheManager manager=CacheManager.create("./src/main/resources/ehcache.xml");
		 */
		URL url=EhcacheTesT.class.getClassLoader().getResource("com/huangpan/ehcache.xml");
        // 根据ehcache.xml配置文件创建Cache管理器
        CacheManager manager=CacheManager.create(url);
        Cache c=manager.getCache("a"); // 获取指定Cache
        Element e=new Element("java1234","屌"); // 实例化一个元素
        c.put(e); // 把一个元素添加到Cache中
         
        Element e2=c.get("java1234"); // 根据Key获取缓存元素
        System.out.println(e2);
        System.out.println(e2.getObjectValue());
         
        c.flush(); // 刷新缓存
        manager.shutdown(); // 关闭缓存管理器
    }
}
