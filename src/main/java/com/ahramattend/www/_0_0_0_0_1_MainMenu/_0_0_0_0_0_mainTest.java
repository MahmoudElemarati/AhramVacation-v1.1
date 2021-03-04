/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_0_1_MainMenu;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpQualification;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerGradePercentage;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpQualification_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerGradePercentage_DAO;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_0_0_mainTest {

    public static void main(String[] args) {
        HibernateSessionCon.OpenCon();
        String employee_id = "2307";
        List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID(employee_id);

        if (pList.isEmpty()) {
            System.out.println("No Such Employee With this Id");
        } else {
            PerEmploymentMasters m = pList.get(0);
            List<PerEmpQualification> perEmpQualificationsList = new PerEmpQualification_DAO().get_Employees_PerEmpQualification(m.getEmployeeId());
            if (perEmpQualificationsList.isEmpty()) {
                System.out.println("لا توجد مؤهلات");
            } else {
                for (PerEmpQualification e : perEmpQualificationsList) {
                    String UniversityName, qualYear, FacultyName, SpecialistName, QualName, GradeStr = "";
                    qualYear = "" + e.getQualYear();
                    try {
                        if (e.getQualYear() != null) {
                            qualYear = "" + e.getQualYear();
                        } else {
                            qualYear = "لا يوجد تاريخ للشهادة";
                        }

                    } catch (Exception ex) {
                        qualYear = "لا يوجد تاريخ للشهادة";
                    }
                    try {
                        if (e.getPerUniversityCode().getUniversityName() != null) {
                            UniversityName = e.getPerUniversityCode().getUniversityName();
                        } else {
                            UniversityName = "لا يوجد بيان مسجل";
                        }

                    } catch (Exception ex) {
                        UniversityName = "لا يوجد بيان مسجل";
                    }
                    try {
                        if (e.getPerFacultyCode().getFacultyName() != null) {
                            FacultyName = e.getPerFacultyCode().getFacultyName();
                        } else {
                            FacultyName = "لا يوجد بيان مسجل";
                        }

                    } catch (Exception ex) {
                        FacultyName = "لا يوجد بيان مسجل";
                    }
                    try {
                        if (e.getPerSpecialistCode().getSpecialistName() != null) {
                            SpecialistName = e.getPerSpecialistCode().getSpecialistName();
                        } else {
                            SpecialistName = "لا توجد درجة مالية";
                        }

                    } catch (Exception ex) {
                        SpecialistName = "لا توجد درجة مالية";
                    }
                    try {
                        if (e.getPerQualCode().getQualName() != null) {
                            QualName = e.getPerQualCode().getQualName();
                        } else {
                            QualName = "لا توجد درجة مالية";
                        }

                    } catch (Exception ex) {
                        QualName = "لا توجد درجة مالية";
                    }
                    double Grade;
                    try {
                        Grade = Double.parseDouble(e.getEmpPercent().toString());
                        List<PerGradePercentage> PerGradePercentageList = new PerGradePercentage_DAO().getAllPerGradePercentage();
                        for (PerGradePercentage x : PerGradePercentageList) {
                            double From = Double.parseDouble(x.getPercentageFrom().toString());
                            double To = Double.parseDouble(x.getPercentageTo().toString());

                            if (Grade >= From && Grade <= To) {
                                GradeStr = x.getGradeName();
                            }
                        }
                    } catch (Exception ex) {
                        GradeStr = "لا توجد تقدير";
                    }
                    System.out.println(" -- EmployeeId     :" + e.getId().getEmployeeId());
                    System.out.println(" -- SerialNo       :" + e.getId().getSerialNo());
                    
                    System.out.println(" -- qualYear       :" + qualYear);
                    System.out.println(" -- UniversityName :" + UniversityName);
                    System.out.println(" -- FacultyName    :" + FacultyName);
                    System.out.println(" -- GradeStr       :" + GradeStr);
                    System.out.println(" -- SpecialistName :" + SpecialistName);
                    System.out.println(" -- QualName       :" + QualName);

                }
            }

            HibernateSessionCon.closeConn();
        }
    }
}
