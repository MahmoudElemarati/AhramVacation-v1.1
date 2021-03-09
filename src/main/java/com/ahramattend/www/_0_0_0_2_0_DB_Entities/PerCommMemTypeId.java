package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerCommMemTypeId generated by hbm2java
 */
@Embeddable
public class PerCommMemTypeId  implements java.io.Serializable {


     private String commTypeCode;
     private String commMemTypeCode;

    public PerCommMemTypeId() {
    }

    public PerCommMemTypeId(String commTypeCode, String commMemTypeCode) {
       this.commTypeCode = commTypeCode;
       this.commMemTypeCode = commMemTypeCode;
    }
   


    @Column(name="COMM_TYPE_CODE", nullable=false, length=5)
    public String getCommTypeCode() {
        return this.commTypeCode;
    }
    
    public void setCommTypeCode(String commTypeCode) {
        this.commTypeCode = commTypeCode;
    }


    @Column(name="COMM_MEM_TYPE_CODE", nullable=false, length=5)
    public String getCommMemTypeCode() {
        return this.commMemTypeCode;
    }
    
    public void setCommMemTypeCode(String commMemTypeCode) {
        this.commMemTypeCode = commMemTypeCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerCommMemTypeId) ) return false;
		 PerCommMemTypeId castOther = ( PerCommMemTypeId ) other; 
         
		 return ( (this.getCommTypeCode()==castOther.getCommTypeCode()) || ( this.getCommTypeCode()!=null && castOther.getCommTypeCode()!=null && this.getCommTypeCode().equals(castOther.getCommTypeCode()) ) )
 && ( (this.getCommMemTypeCode()==castOther.getCommMemTypeCode()) || ( this.getCommMemTypeCode()!=null && castOther.getCommMemTypeCode()!=null && this.getCommMemTypeCode().equals(castOther.getCommMemTypeCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCommTypeCode() == null ? 0 : this.getCommTypeCode().hashCode() );
         result = 37 * result + ( getCommMemTypeCode() == null ? 0 : this.getCommMemTypeCode().hashCode() );
         return result;
   }   


}


