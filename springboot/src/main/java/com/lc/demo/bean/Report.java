package com.lc.demo.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

public class Report {

    private  Integer sequenceId;
    private Integer reportNameId;
    private String reportName;
    private Integer goodsId;

    private String goodsName;

    private String damageDescription;

    private Date reportTime;

    private Date processTime;

    private String goodsState;
    private Integer disposeNameId;
    private String disposeName;

    public Integer getSequenceId() {
        return sequenceId;
    }

    public Integer getReportNameId() {
        return reportNameId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public Integer getDisposeNameId() {
        return disposeNameId;
    }

    private String disposeDescription;

    public Report() {
    }

    public void setSequenceId(Integer sequenceId) {
        this.sequenceId = sequenceId;
    }

    public void setReportNameId(Integer reportNameId) {
        this.reportNameId = reportNameId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setDisposeNameId(Integer disposeNameId) {
        this.disposeNameId = disposeNameId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
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



