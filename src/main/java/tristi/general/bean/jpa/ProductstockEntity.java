/*
 * Created on 6 Dec 2015 ( Time 04:08:36 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package tristi.general.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Persistent class for entity stored in table "productstock"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="productstock", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ProductstockEntity.countAll", query="SELECT COUNT(x) FROM ProductstockEntity x" )
} )
public class ProductstockEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="productstockid", nullable=false, length=255)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID     productstockid ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="productstockqty")
    private Integer    productstockqty ;

    @Column(name="productstockmin")
    private Integer    productstockmin ;

    @Column(name="productstockmax")
    private Integer    productstockmax ;

    @Temporal(TemporalType.DATE)
    @Column(name="productstockmoddate")
    private Date       productstockmoddate ;

	// "productstockLocationid" (column "productstock_locationid") is not defined by itself because used as FK in a link 
	// "productstockUserid" (column "productstock_userid") is not defined by itself because used as FK in a link 
	// "productstockProductuomid" (column "productstock_productuomid") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="productstock_productuomid", referencedColumnName="productuomid")
    private ProductuomEntity productuom  ;

    @ManyToOne
    @JoinColumn(name="productstock_userid", referencedColumnName="userid")
    private UseraccessEntity useraccess  ;

    @OneToMany(mappedBy="productstock", targetEntity=DetailexpiredEntity.class)
    private List<DetailexpiredEntity> listOfDetailexpired;

    @ManyToOne
    @JoinColumn(name="productstock_locationid", referencedColumnName="locationid")
    private LocationEntity location    ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ProductstockEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setProductstockid( UUID productstockid ) {
        this.productstockid = productstockid ;
    }
    public UUID getProductstockid() {
        return this.productstockid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : productstockqty ( int4 ) 
    public void setProductstockqty( Integer productstockqty ) {
        this.productstockqty = productstockqty;
    }
    public Integer getProductstockqty() {
        return this.productstockqty;
    }

    //--- DATABASE MAPPING : productstockmin ( int4 ) 
    public void setProductstockmin( Integer productstockmin ) {
        this.productstockmin = productstockmin;
    }
    public Integer getProductstockmin() {
        return this.productstockmin;
    }

    //--- DATABASE MAPPING : productstockmax ( int4 ) 
    public void setProductstockmax( Integer productstockmax ) {
        this.productstockmax = productstockmax;
    }
    public Integer getProductstockmax() {
        return this.productstockmax;
    }

    //--- DATABASE MAPPING : productstockmoddate ( date ) 
    public void setProductstockmoddate( Date productstockmoddate ) {
        this.productstockmoddate = productstockmoddate;
    }
    public Date getProductstockmoddate() {
        return this.productstockmoddate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setProductuom( ProductuomEntity productuom ) {
        this.productuom = productuom;
    }
    public ProductuomEntity getProductuom() {
        return this.productuom;
    }

    public void setUseraccess( UseraccessEntity useraccess ) {
        this.useraccess = useraccess;
    }
    public UseraccessEntity getUseraccess() {
        return this.useraccess;
    }

    public void setListOfDetailexpired( List<DetailexpiredEntity> listOfDetailexpired ) {
        this.listOfDetailexpired = listOfDetailexpired;
    }
    public List<DetailexpiredEntity> getListOfDetailexpired() {
        return this.listOfDetailexpired;
    }

    public void setLocation( LocationEntity location ) {
        this.location = location;
    }
    public LocationEntity getLocation() {
        return this.location;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(productstockid);
        sb.append("]:"); 
        sb.append(productstockqty);
        sb.append("|");
        sb.append(productstockmin);
        sb.append("|");
        sb.append(productstockmax);
        sb.append("|");
        sb.append(productstockmoddate);
        return sb.toString(); 
    } 

}