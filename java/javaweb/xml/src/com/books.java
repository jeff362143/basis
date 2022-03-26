package com;


import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class books {



    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public books(String name, String author, int price,String sn) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.sn = sn;
    }

    private String sn;
    private  String name;
    private  String author;
    private  int price;


     /*已导入dom4j
     * 会出现特别多的warning，查询后结论为jdk版本过高
     * 值得注意的是，new File("books.xml")这样失败了，写入整个url路径后成功了
     */
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("xml\\xml\\books.xml"));
        Element rootElement = document.getRootElement();
        Element element = rootElement.element("book");
//      不然直接打印后代元素，只能从子元素一级一级下来
        Element element1 = element.element("author");
//        System.out.println(element1.asXML());
//        以String形式输出了整个xml文本
//        System.out.println(document.asXML());

//      elementText()直接将element对象中的name标签中的内容给出(给的是子元素)，还有getText方法可以打印标签中的文本(只能打印自己)
        String str = element.elementText("name");
//        System.out.println(str);
        System.out.println(new books(str,"hkin",79,"222"));
    }
}
