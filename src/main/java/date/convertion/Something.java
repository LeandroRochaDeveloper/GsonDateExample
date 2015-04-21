/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date.convertion;

import java.util.Date;

/**
 *
 * @author Leandro
 */
public class Something {
    private Long id;
    private Date date;

    public Something() {
        this.id = 1L;
        this.date = new Date();
    }

    public Something(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
