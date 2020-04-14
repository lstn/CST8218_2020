/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.esti0011.business;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas.estienne
 */
@Entity
@Table(name = "WIDGETLUCAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WidgetLucas.findAll", query = "SELECT w FROM WidgetLucas w"),
    @NamedQuery(name = "WidgetLucas.findById", query = "SELECT w FROM WidgetLucas w WHERE w.id = :id"),
    @NamedQuery(name = "WidgetLucas.findByName959", query = "SELECT w FROM WidgetLucas w WHERE w.name959 = :name959"),
    @NamedQuery(name = "WidgetLucas.findByQuantity959", query = "SELECT w FROM WidgetLucas w WHERE w.quantity959 = :quantity959")})
public class WidgetLucas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(max = 255)
    @Column(name = "NAME959")
    private String name959;
    @Column(name = "QUANTITY959")
    private Integer quantity959;

    public WidgetLucas() {
    }

    public WidgetLucas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName959() {
        return name959;
    }

    public void setName959(String name959) {
        this.name959 = name959;
    }

    public Integer getQuantity959() {
        return quantity959;
    }

    public void setQuantity959(Integer quantity959) {
        this.quantity959 = quantity959;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WidgetLucas)) {
            return false;
        }
        WidgetLucas other = (WidgetLucas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cst8218.esti0011.business.WidgetLucas[ id=" + id + " ]";
    }
    
}
