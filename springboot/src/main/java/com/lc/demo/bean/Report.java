package com.lc.demo.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

public class Report {

    private int sequenceId;
    private String reportName;

    private int goodsId;

    private String goodsName;

    private String damageDescription;

    private Date reportTime;

    private Date processTime;

    private int goodsState;

    private String disposeName;

    private float applyAssets;

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public float getApplyAssets() {
        return applyAssets;
    }

    public void setApplyAssets(float applyAssets) {
        this.applyAssets = applyAssets;
    }

    public Report() {

    }
    public Report(String reportName, int goodsId, String goodsName, String damageDescription, Date reportTime, Date processTime, int goodsState, String disposeName) {
        this.reportName = reportName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.damageDescription = damageDescription;
        this.reportTime = reportTime;
        this.processTime = processTime;
        this.goodsState = goodsState;
        this.disposeName = disposeName;
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
    public int getGoodsState() {
        return goodsState;
    }
    public void setGoodsState(int goodsState) {
        this.goodsState = goodsState;
    }
    public String getDisposeName() {
        return disposeName;
    }
    public void setDisposeName(String disposeName) {
        this.disposeName = disposeName;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Override
    public String toString() {
        return "Report{" +
                "sequenceId=" + sequenceId +
                ", reportName='" + reportName + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", damageDescription='" + damageDescription + '\'' +
                ", reportTime=" + reportTime +
                ", processTime=" + processTime +
                ", goodsState=" + goodsState +
                ", disposeName='" + disposeName + '\'' +
                '}';
    }
}



