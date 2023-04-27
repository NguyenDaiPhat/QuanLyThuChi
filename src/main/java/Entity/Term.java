/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.time.LocalDate;

/**
 *
 * @author Line's laptop
 */
public class Term {
    private int id;
    private LocalDate date;
    private String title;
    private int price ;
    private String description;
    private String type;

    public Term(int id, LocalDate date, String title, int price, String description, String type) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.price = price;
        this.description = description;
        this.type = type;
    }

    public Term() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getXMLString() {
        return "<term>\n" +
"		<id>"+id+"</id>\n" +
"		<date>"+date+"</date>\n" +
"		<title>"+title+"</title>\n" +
"		<price>"+price+"</price>\n" +
"               <description>"+description+"</description>\n" +
"               <type>"+type+"</type>\n" +
"	</term>";
    }

    @Override
    public String toString() {
        return "Term{" + "id=" + id + ", date=" + date + ", title=" + title + ", price=" + price + ", description=" + description + ", type=" + type + '}';
    }
}
