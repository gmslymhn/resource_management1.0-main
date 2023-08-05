package com.lc.demo.bean;
import java.util.Date;
public class Report {

    private  int sequenceId;
    private int reportNameId;
    private String reportName;
    private int goodsId;

    private String goodsName;

    private String damageDescription;

    private Date reportTime;

    private Date processTime;

    private String goodsState;
    private int disposeNameId;
    private String disposeName;

    private String disposeDescription;

    public Report() {
    }

    public Report(int sequenceId, int reportNameId, String reportName, int goodsId, String goodsName, String damageDescription, Date reportTime, Date processTime, String goodsState, int disposeNameId, String disposeName, String disposeDescription) {
        this.sequenceId = sequenceId;
        this.reportNameId = reportNameId;
        this.reportName = reportName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.damageDescription = damageDescription;
        this.reportTime = reportTime;
        this.processTime = processTime;
        this.goodsState = goodsState;
        this.disposeNameId = disposeNameId;
        this.disposeName = disposeName;
        this.disposeDescription = disposeDescription;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getReportNameId() {
        return reportNameId;
    }

    public void setReportNameId(int reportNameId) {
        this.reportNameId = reportNameId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }

    public int getDisposeNameId() {
        return disposeNameId;
    }

    public void setDisposeNameId(int disposeNameId) {
        this.disposeNameId = disposeNameId;
    }

    public String getDisposeName() {
        return disposeName;
    }

    public void setDisposeName(String disposeName) {
        this.disposeName = disposeName;
    }

    public String getDisposeDescription() {
        return disposeDescription;
    }

    public void setDisposeDescription(String disposeDescription) {
        this.disposeDescription = disposeDescription;
    }

    @Override
    public String toString() {
        return "Report{" +
                "sequenceId=" + sequenceId +
                ", reportNameId=" + reportNameId +
                ", reportName='" + reportName + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", damageDescription='" + damageDescription + '\'' +
                ", reportTime=" + reportTime +
                ", processTime=" + processTime +
                ", goodsState=" + goodsState +
                ", disposeNameId=" + disposeNameId +
                ", disposeName='" + disposeName + '\'' +
                ", disposeDescription='" + disposeDescription + '\'' +
                '}';
    }
}



