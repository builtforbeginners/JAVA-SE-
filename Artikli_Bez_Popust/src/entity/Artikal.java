/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author petarpetrov
 */
@Entity
@Table(name = "artikal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikal.findAll", query = "SELECT a FROM Artikal a"),
    @NamedQuery(name = "Artikal.findById", query = "SELECT a FROM Artikal a WHERE a.id = :id"),
    @NamedQuery(name = "Artikal.findByArtikalId", query = "SELECT a FROM Artikal a WHERE a.artikalId = :artikalId"),
    @NamedQuery(name = "Artikal.findByObjektId", query = "SELECT a FROM Artikal a WHERE a.objektId = :objektId"),
    @NamedQuery(name = "Artikal.findByNaziv", query = "SELECT a FROM Artikal a WHERE a.naziv = :naziv"),
    @NamedQuery(name = "Artikal.findByDatumOd", query = "SELECT a FROM Artikal a WHERE a.datumOd = :datumOd"),
    @NamedQuery(name = "Artikal.findByDatumDo", query = "SELECT a FROM Artikal a WHERE a.datumDo = :datumDo"),
    @NamedQuery(name = "Artikal.findByNaPopust", query = "SELECT a FROM Artikal a WHERE a.naPopust = :naPopust")})
public class Artikal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "artikal_id")
    private int artikalId;
    @Basic(optional = false)
    @Column(name = "objekt_id")
    private int objektId;
    @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "datum_od")
    @Temporal(TemporalType.DATE)
    private Date datumOd;
    @Basic(optional = false)
    @Column(name = "datum_do")
    @Temporal(TemporalType.DATE)
    private Date datumDo;
    @Basic(optional = false)
    @Column(name = "na_popust")
    private boolean naPopust;

    public Artikal() {
    }

    public Artikal(Integer id) {
        this.id = id;
    }

    public Artikal(Integer id, int artikalId, int objektId, String naziv, Date datumOd, Date datumDo, boolean naPopust) {
        this.id = id;
        this.artikalId = artikalId;
        this.objektId = objektId;
        this.naziv = naziv;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.naPopust = naPopust;
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArtikalId() {
        return artikalId;
    }

    public void setArtikalId(Integer artikalId) {
        this.artikalId = artikalId;
    }

    public int getObjektId() {
        return objektId;
    }

    public void setObjektId(int objektId) {
        this.objektId = objektId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public boolean getNaPopust() {
        return naPopust;
    }

    public void setNaPopust(boolean naPopust) {
        this.naPopust = naPopust;
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
        if (!(object instanceof Artikal)) {
            return false;
        }
        Artikal other = (Artikal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Artikal[ id=" + id + " ]";
    }
    
}
