package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PerSetup generated by hbm2java
 */
@Entity
@Table(name="PER_SETUP"
    ,schema="SHAMS"
)
public class PerSetup  implements java.io.Serializable {


     private PerSetupId id;
     private BudLocation budLocation;
     private String perOrgMan;
     private boolean attendanceFlg;
     private boolean historyFlg;
     private String perOrgManTitle;
     private String signature1;
     private String title1;
     private String signature2;
     private String title2;
     private String signature3;
     private String title3;
     private String signature4;
     private String title4;
     private String signature5;
     private String title5;
     private String signature6;
     private String title6;
     private String notes;
     private String bhSignature1;
     private String bhTitle1;
     private String bhSignature2;
     private String bhTitle2;
     private String bhSignature3;
     private String bhTitle3;
     private String bhNotes;
     private String bhGehaName;
     private String signature7;
     private String title7;
     private String bhSignature4;
     private String bhTitle4;
     private String bhSignature5;
     private String bhTitle5;
     private String generalJob;
     private String attendancePwd;
     private Boolean chkTerm;
     private Boolean chk1;
     private Boolean chk2;
     private Boolean chk3;
     private Boolean chk4;
     private Boolean chk5;
     private Boolean chk6;
     private Boolean chk7;
     private Boolean chk8;
     private Boolean chk9;
     private Boolean chk10;
     private Boolean chk11;
     private Boolean chk12;
     private Boolean chk13;
     private Boolean chk14;
     private Boolean chk15;
     private Boolean chk16;
     private Boolean chk17;
     private Boolean chk18;
     private Boolean chk19;
     private Boolean chk20;
     private Boolean chk21;
     private Boolean chk22;
     private Boolean chk23;

    public PerSetup() {
    }

	
    public PerSetup(PerSetupId id, BudLocation budLocation, boolean attendanceFlg, boolean historyFlg) {
        this.id = id;
        this.budLocation = budLocation;
        this.attendanceFlg = attendanceFlg;
        this.historyFlg = historyFlg;
    }
    public PerSetup(PerSetupId id, BudLocation budLocation, String perOrgMan, boolean attendanceFlg, boolean historyFlg, String perOrgManTitle, String signature1, String title1, String signature2, String title2, String signature3, String title3, String signature4, String title4, String signature5, String title5, String signature6, String title6, String notes, String bhSignature1, String bhTitle1, String bhSignature2, String bhTitle2, String bhSignature3, String bhTitle3, String bhNotes, String bhGehaName, String signature7, String title7, String bhSignature4, String bhTitle4, String bhSignature5, String bhTitle5, String generalJob, String attendancePwd, Boolean chkTerm, Boolean chk1, Boolean chk2, Boolean chk3, Boolean chk4, Boolean chk5, Boolean chk6, Boolean chk7, Boolean chk8, Boolean chk9, Boolean chk10, Boolean chk11, Boolean chk12, Boolean chk13, Boolean chk14, Boolean chk15, Boolean chk16, Boolean chk17, Boolean chk18, Boolean chk19, Boolean chk20, Boolean chk21, Boolean chk22, Boolean chk23) {
       this.id = id;
       this.budLocation = budLocation;
       this.perOrgMan = perOrgMan;
       this.attendanceFlg = attendanceFlg;
       this.historyFlg = historyFlg;
       this.perOrgManTitle = perOrgManTitle;
       this.signature1 = signature1;
       this.title1 = title1;
       this.signature2 = signature2;
       this.title2 = title2;
       this.signature3 = signature3;
       this.title3 = title3;
       this.signature4 = signature4;
       this.title4 = title4;
       this.signature5 = signature5;
       this.title5 = title5;
       this.signature6 = signature6;
       this.title6 = title6;
       this.notes = notes;
       this.bhSignature1 = bhSignature1;
       this.bhTitle1 = bhTitle1;
       this.bhSignature2 = bhSignature2;
       this.bhTitle2 = bhTitle2;
       this.bhSignature3 = bhSignature3;
       this.bhTitle3 = bhTitle3;
       this.bhNotes = bhNotes;
       this.bhGehaName = bhGehaName;
       this.signature7 = signature7;
       this.title7 = title7;
       this.bhSignature4 = bhSignature4;
       this.bhTitle4 = bhTitle4;
       this.bhSignature5 = bhSignature5;
       this.bhTitle5 = bhTitle5;
       this.generalJob = generalJob;
       this.attendancePwd = attendancePwd;
       this.chkTerm = chkTerm;
       this.chk1 = chk1;
       this.chk2 = chk2;
       this.chk3 = chk3;
       this.chk4 = chk4;
       this.chk5 = chk5;
       this.chk6 = chk6;
       this.chk7 = chk7;
       this.chk8 = chk8;
       this.chk9 = chk9;
       this.chk10 = chk10;
       this.chk11 = chk11;
       this.chk12 = chk12;
       this.chk13 = chk13;
       this.chk14 = chk14;
       this.chk15 = chk15;
       this.chk16 = chk16;
       this.chk17 = chk17;
       this.chk18 = chk18;
       this.chk19 = chk19;
       this.chk20 = chk20;
       this.chk21 = chk21;
       this.chk22 = chk22;
       this.chk23 = chk23;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="setupDate", column=@Column(name="SETUP_DATE", nullable=false, length=7) ) } )
    public PerSetupId getId() {
        return this.id;
    }
    
    public void setId(PerSetupId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="LOCATION_CODE", nullable=false, insertable=false, updatable=false)
    public BudLocation getBudLocation() {
        return this.budLocation;
    }
    
    public void setBudLocation(BudLocation budLocation) {
        this.budLocation = budLocation;
    }

    
    @Column(name="PER_ORG_MAN", length=75)
    public String getPerOrgMan() {
        return this.perOrgMan;
    }
    
    public void setPerOrgMan(String perOrgMan) {
        this.perOrgMan = perOrgMan;
    }

    
    @Column(name="ATTENDANCE_FLG", nullable=false, precision=1, scale=0)
    public boolean isAttendanceFlg() {
        return this.attendanceFlg;
    }
    
    public void setAttendanceFlg(boolean attendanceFlg) {
        this.attendanceFlg = attendanceFlg;
    }

    
    @Column(name="HISTORY_FLG", nullable=false, precision=1, scale=0)
    public boolean isHistoryFlg() {
        return this.historyFlg;
    }
    
    public void setHistoryFlg(boolean historyFlg) {
        this.historyFlg = historyFlg;
    }

    
    @Column(name="PER_ORG_MAN_TITLE", length=100)
    public String getPerOrgManTitle() {
        return this.perOrgManTitle;
    }
    
    public void setPerOrgManTitle(String perOrgManTitle) {
        this.perOrgManTitle = perOrgManTitle;
    }

    
    @Column(name="SIGNATURE_1", length=75)
    public String getSignature1() {
        return this.signature1;
    }
    
    public void setSignature1(String signature1) {
        this.signature1 = signature1;
    }

    
    @Column(name="TITLE_1", length=50)
    public String getTitle1() {
        return this.title1;
    }
    
    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    
    @Column(name="SIGNATURE_2", length=75)
    public String getSignature2() {
        return this.signature2;
    }
    
    public void setSignature2(String signature2) {
        this.signature2 = signature2;
    }

    
    @Column(name="TITLE_2", length=50)
    public String getTitle2() {
        return this.title2;
    }
    
    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    
    @Column(name="SIGNATURE_3", length=75)
    public String getSignature3() {
        return this.signature3;
    }
    
    public void setSignature3(String signature3) {
        this.signature3 = signature3;
    }

    
    @Column(name="TITLE_3", length=50)
    public String getTitle3() {
        return this.title3;
    }
    
    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    
    @Column(name="SIGNATURE_4", length=75)
    public String getSignature4() {
        return this.signature4;
    }
    
    public void setSignature4(String signature4) {
        this.signature4 = signature4;
    }

    
    @Column(name="TITLE_4", length=50)
    public String getTitle4() {
        return this.title4;
    }
    
    public void setTitle4(String title4) {
        this.title4 = title4;
    }

    
    @Column(name="SIGNATURE_5", length=75)
    public String getSignature5() {
        return this.signature5;
    }
    
    public void setSignature5(String signature5) {
        this.signature5 = signature5;
    }

    
    @Column(name="TITLE_5", length=50)
    public String getTitle5() {
        return this.title5;
    }
    
    public void setTitle5(String title5) {
        this.title5 = title5;
    }

    
    @Column(name="SIGNATURE_6", length=75)
    public String getSignature6() {
        return this.signature6;
    }
    
    public void setSignature6(String signature6) {
        this.signature6 = signature6;
    }

    
    @Column(name="TITLE_6", length=50)
    public String getTitle6() {
        return this.title6;
    }
    
    public void setTitle6(String title6) {
        this.title6 = title6;
    }

    
    @Column(name="NOTES", length=250)
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    @Column(name="BH_SIGNATURE_1", length=75)
    public String getBhSignature1() {
        return this.bhSignature1;
    }
    
    public void setBhSignature1(String bhSignature1) {
        this.bhSignature1 = bhSignature1;
    }

    
    @Column(name="BH_TITLE_1", length=50)
    public String getBhTitle1() {
        return this.bhTitle1;
    }
    
    public void setBhTitle1(String bhTitle1) {
        this.bhTitle1 = bhTitle1;
    }

    
    @Column(name="BH_SIGNATURE_2", length=75)
    public String getBhSignature2() {
        return this.bhSignature2;
    }
    
    public void setBhSignature2(String bhSignature2) {
        this.bhSignature2 = bhSignature2;
    }

    
    @Column(name="BH_TITLE_2", length=50)
    public String getBhTitle2() {
        return this.bhTitle2;
    }
    
    public void setBhTitle2(String bhTitle2) {
        this.bhTitle2 = bhTitle2;
    }

    
    @Column(name="BH_SIGNATURE_3", length=75)
    public String getBhSignature3() {
        return this.bhSignature3;
    }
    
    public void setBhSignature3(String bhSignature3) {
        this.bhSignature3 = bhSignature3;
    }

    
    @Column(name="BH_TITLE_3", length=50)
    public String getBhTitle3() {
        return this.bhTitle3;
    }
    
    public void setBhTitle3(String bhTitle3) {
        this.bhTitle3 = bhTitle3;
    }

    
    @Column(name="BH_NOTES", length=250)
    public String getBhNotes() {
        return this.bhNotes;
    }
    
    public void setBhNotes(String bhNotes) {
        this.bhNotes = bhNotes;
    }

    
    @Column(name="BH_GEHA_NAME", length=150)
    public String getBhGehaName() {
        return this.bhGehaName;
    }
    
    public void setBhGehaName(String bhGehaName) {
        this.bhGehaName = bhGehaName;
    }

    
    @Column(name="SIGNATURE_7", length=75)
    public String getSignature7() {
        return this.signature7;
    }
    
    public void setSignature7(String signature7) {
        this.signature7 = signature7;
    }

    
    @Column(name="TITLE_7", length=75)
    public String getTitle7() {
        return this.title7;
    }
    
    public void setTitle7(String title7) {
        this.title7 = title7;
    }

    
    @Column(name="BH_SIGNATURE_4", length=75)
    public String getBhSignature4() {
        return this.bhSignature4;
    }
    
    public void setBhSignature4(String bhSignature4) {
        this.bhSignature4 = bhSignature4;
    }

    
    @Column(name="BH_TITLE_4", length=50)
    public String getBhTitle4() {
        return this.bhTitle4;
    }
    
    public void setBhTitle4(String bhTitle4) {
        this.bhTitle4 = bhTitle4;
    }

    
    @Column(name="BH_SIGNATURE_5", length=75)
    public String getBhSignature5() {
        return this.bhSignature5;
    }
    
    public void setBhSignature5(String bhSignature5) {
        this.bhSignature5 = bhSignature5;
    }

    
    @Column(name="BH_TITLE_5", length=50)
    public String getBhTitle5() {
        return this.bhTitle5;
    }
    
    public void setBhTitle5(String bhTitle5) {
        this.bhTitle5 = bhTitle5;
    }

    
    @Column(name="GENERAL_JOB", length=100)
    public String getGeneralJob() {
        return this.generalJob;
    }
    
    public void setGeneralJob(String generalJob) {
        this.generalJob = generalJob;
    }

    
    @Column(name="ATTENDANCE_PWD", length=15)
    public String getAttendancePwd() {
        return this.attendancePwd;
    }
    
    public void setAttendancePwd(String attendancePwd) {
        this.attendancePwd = attendancePwd;
    }

    
    @Column(name="CHK_TERM", precision=1, scale=0)
    public Boolean getChkTerm() {
        return this.chkTerm;
    }
    
    public void setChkTerm(Boolean chkTerm) {
        this.chkTerm = chkTerm;
    }

    
    @Column(name="CHK_1", precision=1, scale=0)
    public Boolean getChk1() {
        return this.chk1;
    }
    
    public void setChk1(Boolean chk1) {
        this.chk1 = chk1;
    }

    
    @Column(name="CHK_2", precision=1, scale=0)
    public Boolean getChk2() {
        return this.chk2;
    }
    
    public void setChk2(Boolean chk2) {
        this.chk2 = chk2;
    }

    
    @Column(name="CHK_3", precision=1, scale=0)
    public Boolean getChk3() {
        return this.chk3;
    }
    
    public void setChk3(Boolean chk3) {
        this.chk3 = chk3;
    }

    
    @Column(name="CHK_4", precision=1, scale=0)
    public Boolean getChk4() {
        return this.chk4;
    }
    
    public void setChk4(Boolean chk4) {
        this.chk4 = chk4;
    }

    
    @Column(name="CHK_5", precision=1, scale=0)
    public Boolean getChk5() {
        return this.chk5;
    }
    
    public void setChk5(Boolean chk5) {
        this.chk5 = chk5;
    }

    
    @Column(name="CHK_6", precision=1, scale=0)
    public Boolean getChk6() {
        return this.chk6;
    }
    
    public void setChk6(Boolean chk6) {
        this.chk6 = chk6;
    }

    
    @Column(name="CHK_7", precision=1, scale=0)
    public Boolean getChk7() {
        return this.chk7;
    }
    
    public void setChk7(Boolean chk7) {
        this.chk7 = chk7;
    }

    
    @Column(name="CHK_8", precision=1, scale=0)
    public Boolean getChk8() {
        return this.chk8;
    }
    
    public void setChk8(Boolean chk8) {
        this.chk8 = chk8;
    }

    
    @Column(name="CHK_9", precision=1, scale=0)
    public Boolean getChk9() {
        return this.chk9;
    }
    
    public void setChk9(Boolean chk9) {
        this.chk9 = chk9;
    }

    
    @Column(name="CHK_10", precision=1, scale=0)
    public Boolean getChk10() {
        return this.chk10;
    }
    
    public void setChk10(Boolean chk10) {
        this.chk10 = chk10;
    }

    
    @Column(name="CHK_11", precision=1, scale=0)
    public Boolean getChk11() {
        return this.chk11;
    }
    
    public void setChk11(Boolean chk11) {
        this.chk11 = chk11;
    }

    
    @Column(name="CHK_12", precision=1, scale=0)
    public Boolean getChk12() {
        return this.chk12;
    }
    
    public void setChk12(Boolean chk12) {
        this.chk12 = chk12;
    }

    
    @Column(name="CHK_13", precision=1, scale=0)
    public Boolean getChk13() {
        return this.chk13;
    }
    
    public void setChk13(Boolean chk13) {
        this.chk13 = chk13;
    }

    
    @Column(name="CHK_14", precision=1, scale=0)
    public Boolean getChk14() {
        return this.chk14;
    }
    
    public void setChk14(Boolean chk14) {
        this.chk14 = chk14;
    }

    
    @Column(name="CHK_15", precision=1, scale=0)
    public Boolean getChk15() {
        return this.chk15;
    }
    
    public void setChk15(Boolean chk15) {
        this.chk15 = chk15;
    }

    
    @Column(name="CHK_16", precision=1, scale=0)
    public Boolean getChk16() {
        return this.chk16;
    }
    
    public void setChk16(Boolean chk16) {
        this.chk16 = chk16;
    }

    
    @Column(name="CHK_17", precision=1, scale=0)
    public Boolean getChk17() {
        return this.chk17;
    }
    
    public void setChk17(Boolean chk17) {
        this.chk17 = chk17;
    }

    
    @Column(name="CHK_18", precision=1, scale=0)
    public Boolean getChk18() {
        return this.chk18;
    }
    
    public void setChk18(Boolean chk18) {
        this.chk18 = chk18;
    }

    
    @Column(name="CHK_19", precision=1, scale=0)
    public Boolean getChk19() {
        return this.chk19;
    }
    
    public void setChk19(Boolean chk19) {
        this.chk19 = chk19;
    }

    
    @Column(name="CHK_20", precision=1, scale=0)
    public Boolean getChk20() {
        return this.chk20;
    }
    
    public void setChk20(Boolean chk20) {
        this.chk20 = chk20;
    }

    
    @Column(name="CHK_21", precision=1, scale=0)
    public Boolean getChk21() {
        return this.chk21;
    }
    
    public void setChk21(Boolean chk21) {
        this.chk21 = chk21;
    }

    
    @Column(name="CHK_22", precision=1, scale=0)
    public Boolean getChk22() {
        return this.chk22;
    }
    
    public void setChk22(Boolean chk22) {
        this.chk22 = chk22;
    }

    
    @Column(name="CHK_23", precision=1, scale=0)
    public Boolean getChk23() {
        return this.chk23;
    }
    
    public void setChk23(Boolean chk23) {
        this.chk23 = chk23;
    }




}

