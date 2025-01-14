package org.example;  //POJO

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
    @Id
    public int aid;
    public String aname;
    public String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
