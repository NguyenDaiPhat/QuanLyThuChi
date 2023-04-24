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
public class Thu {
    private int id;
    private LocalDate date;
    private String title;
    private int price ;
    private String description;

    public Thu(int id, LocalDate date, String title, int price, String description) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public Thu() {
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
}
