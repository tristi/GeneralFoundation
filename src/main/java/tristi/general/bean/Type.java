/*
 * Created on 6 Dec 2015 ( Time 04:13:35 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    @Size( min = 1, max = 255 )
    private String typeid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 255 )
    private String typeUserid;

    @Size( max = 50 )
    private String typecode;

    @Size( max = 100 )
    private String typename;


    private Boolean typeisactive;


    private Date typemoddate;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTypeid( String typeid ) {
        this.typeid = typeid ;
    }

    public String getTypeid() {
        return this.typeid;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setTypeUserid( String typeUserid ) {
        this.typeUserid = typeUserid;
    }
    public String getTypeUserid() {
        return this.typeUserid;
    }

    public void setTypecode( String typecode ) {
        this.typecode = typecode;
    }
    public String getTypecode() {
        return this.typecode;
    }

    public void setTypename( String typename ) {
        this.typename = typename;
    }
    public String getTypename() {
        return this.typename;
    }

    public void setTypeisactive( Boolean typeisactive ) {
        this.typeisactive = typeisactive;
    }
    public Boolean getTypeisactive() {
        return this.typeisactive;
    }

    public void setTypemoddate( Date typemoddate ) {
        this.typemoddate = typemoddate;
    }
    public Date getTypemoddate() {
        return this.typemoddate;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(typeid);
        sb.append("|");
        sb.append(typeUserid);
        sb.append("|");
        sb.append(typecode);
        sb.append("|");
        sb.append(typename);
        sb.append("|");
        sb.append(typeisactive);
        sb.append("|");
        sb.append(typemoddate);
        return sb.toString(); 
    } 


}