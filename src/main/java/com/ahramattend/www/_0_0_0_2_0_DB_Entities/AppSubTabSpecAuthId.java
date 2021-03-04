package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AppSubTabSpecAuthId generated by hbm2java
 */
@Embeddable
public class AppSubTabSpecAuthId  implements java.io.Serializable {


     private int subTabId;
     private String employeeId;
     private short applicationId;
     private int tabId;

    public AppSubTabSpecAuthId() {
    }

    public AppSubTabSpecAuthId(int subTabId, String employeeId, short applicationId, int tabId) {
       this.subTabId = subTabId;
       this.employeeId = employeeId;
       this.applicationId = applicationId;
       this.tabId = tabId;
    }
   


    @Column(name="SUB_TAB_ID", nullable=false, precision=8, scale=0)
    public int getSubTabId() {
        return this.subTabId;
    }
    
    public void setSubTabId(int subTabId) {
        this.subTabId = subTabId;
    }


    @Column(name="EMPLOYEE_ID", nullable=false, length=10)
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="APPLICATION_ID", nullable=false, precision=3, scale=0)
    public short getApplicationId() {
        return this.applicationId;
    }
    
    public void setApplicationId(short applicationId) {
        this.applicationId = applicationId;
    }


    @Column(name="TAB_ID", nullable=false, precision=5, scale=0)
    public int getTabId() {
        return this.tabId;
    }
    
    public void setTabId(int tabId) {
        this.tabId = tabId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AppSubTabSpecAuthId) ) return false;
		 AppSubTabSpecAuthId castOther = ( AppSubTabSpecAuthId ) other; 
         
		 return (this.getSubTabId()==castOther.getSubTabId())
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) )
 && (this.getApplicationId()==castOther.getApplicationId())
 && (this.getTabId()==castOther.getTabId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSubTabId();
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         result = 37 * result + this.getApplicationId();
         result = 37 * result + this.getTabId();
         return result;
   }   


}

