package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AppSubTabId generated by hbm2java
 */
@Embeddable
public class AppSubTabId  implements java.io.Serializable {


     private short applicationId;
     private int tabId;
     private int subTabId;
     private String subTabName;
     private String subTabAccessservlet;
     private String availableToUserControl;
     private Integer subTabIndex;
     private Short authTypeId;

    public AppSubTabId() {
    }

	
    public AppSubTabId(short applicationId, int tabId, int subTabId, String subTabName, String subTabAccessservlet) {
        this.applicationId = applicationId;
        this.tabId = tabId;
        this.subTabId = subTabId;
        this.subTabName = subTabName;
        this.subTabAccessservlet = subTabAccessservlet;
    }
    public AppSubTabId(short applicationId, int tabId, int subTabId, String subTabName, String subTabAccessservlet, String availableToUserControl, Integer subTabIndex, Short authTypeId) {
       this.applicationId = applicationId;
       this.tabId = tabId;
       this.subTabId = subTabId;
       this.subTabName = subTabName;
       this.subTabAccessservlet = subTabAccessservlet;
       this.availableToUserControl = availableToUserControl;
       this.subTabIndex = subTabIndex;
       this.authTypeId = authTypeId;
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


    @Column(name="SUB_TAB_ID", nullable=false, precision=8, scale=0)
    public int getSubTabId() {
        return this.subTabId;
    }
    
    public void setSubTabId(int subTabId) {
        this.subTabId = subTabId;
    }


    @Column(name="SUB_TAB_NAME", nullable=false, length=100)
    public String getSubTabName() {
        return this.subTabName;
    }
    
    public void setSubTabName(String subTabName) {
        this.subTabName = subTabName;
    }


    @Column(name="SUB_TAB_ACCESSSERVLET", nullable=false, length=100)
    public String getSubTabAccessservlet() {
        return this.subTabAccessservlet;
    }
    
    public void setSubTabAccessservlet(String subTabAccessservlet) {
        this.subTabAccessservlet = subTabAccessservlet;
    }


    @Column(name="AVAILABLE_TO_USER_CONTROL", length=10)
    public String getAvailableToUserControl() {
        return this.availableToUserControl;
    }
    
    public void setAvailableToUserControl(String availableToUserControl) {
        this.availableToUserControl = availableToUserControl;
    }


    @Column(name="SUB_TAB_INDEX", precision=8, scale=0)
    public Integer getSubTabIndex() {
        return this.subTabIndex;
    }
    
    public void setSubTabIndex(Integer subTabIndex) {
        this.subTabIndex = subTabIndex;
    }


    @Column(name="AUTH_TYPE_ID", precision=3, scale=0)
    public Short getAuthTypeId() {
        return this.authTypeId;
    }
    
    public void setAuthTypeId(Short authTypeId) {
        this.authTypeId = authTypeId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AppSubTabId) ) return false;
		 AppSubTabId castOther = ( AppSubTabId ) other; 
         
		 return (this.getApplicationId()==castOther.getApplicationId())
 && (this.getTabId()==castOther.getTabId())
 && (this.getSubTabId()==castOther.getSubTabId())
 && ( (this.getSubTabName()==castOther.getSubTabName()) || ( this.getSubTabName()!=null && castOther.getSubTabName()!=null && this.getSubTabName().equals(castOther.getSubTabName()) ) )
 && ( (this.getSubTabAccessservlet()==castOther.getSubTabAccessservlet()) || ( this.getSubTabAccessservlet()!=null && castOther.getSubTabAccessservlet()!=null && this.getSubTabAccessservlet().equals(castOther.getSubTabAccessservlet()) ) )
 && ( (this.getAvailableToUserControl()==castOther.getAvailableToUserControl()) || ( this.getAvailableToUserControl()!=null && castOther.getAvailableToUserControl()!=null && this.getAvailableToUserControl().equals(castOther.getAvailableToUserControl()) ) )
 && ( (this.getSubTabIndex()==castOther.getSubTabIndex()) || ( this.getSubTabIndex()!=null && castOther.getSubTabIndex()!=null && this.getSubTabIndex().equals(castOther.getSubTabIndex()) ) )
 && ( (this.getAuthTypeId()==castOther.getAuthTypeId()) || ( this.getAuthTypeId()!=null && castOther.getAuthTypeId()!=null && this.getAuthTypeId().equals(castOther.getAuthTypeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getApplicationId();
         result = 37 * result + this.getTabId();
         result = 37 * result + this.getSubTabId();
         result = 37 * result + ( getSubTabName() == null ? 0 : this.getSubTabName().hashCode() );
         result = 37 * result + ( getSubTabAccessservlet() == null ? 0 : this.getSubTabAccessservlet().hashCode() );
         result = 37 * result + ( getAvailableToUserControl() == null ? 0 : this.getAvailableToUserControl().hashCode() );
         result = 37 * result + ( getSubTabIndex() == null ? 0 : this.getSubTabIndex().hashCode() );
         result = 37 * result + ( getAuthTypeId() == null ? 0 : this.getAuthTypeId().hashCode() );
         return result;
   }   


}


