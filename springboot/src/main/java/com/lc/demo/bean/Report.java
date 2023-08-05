package com.lc.demo.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Date;

public class Report {

    private  int sequenceId;
    private String reportName;

    private int goodsId;

    private String goodsName;

    private String damageDescription;
    @TableField(fill = FieldFill.INSERT)
    private Date reportTime;
    @TableField(fill = FieldFill.UPTATE)
    private DateTimeLiteralExpression.DateTime processTime;

    private int goodsState;

    private String disposeName;

    public Report() {

    }
    public Report(String reportName, int goodsId, String goodsName, String damageDescription, DateTimeLiteralExpression.DateTime reportTime, DateTimeLiteralExpression.DateTime processTime, int goodsState, String disposeName) {
        this.reportName = reportName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.damageDescription = damageDescription;
        this.reportTime = reportTime;
        this.processTime = processTime;
        this.goodsState = goodsState;
        this.disposeName = disposeName;
    }
    public int getSequenceId(){
        return sequenceId;
    }
    public void setSequenceId(String SequenceId){
        this.sequenceId = sequenceId;
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
    public DateTimeLiteralExpression.DateTime getReportTime() {
        return reportTime;
    }
    public void setReportTime(DateTimeLiteralExpression.DateTime reportTime) {
        this.reportTime = reportTime;
    }
    public DateTimeLiteralExpression.DateTime getProcessTime() {
        return processTime;
    }
    public void setProcessTime(DateTimeLiteralExpression.DateTime processTime) {
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
    @Override
    public String toString() {
        return "Report {reportName=" + reportName + '\'' +
                ", goodsId=" + goodsId + '\'' +
                ", goodsName=" + goodsName + '\'' +
                ", damageDescription=" + damageDescription + '\'' +
                ", reportTime=" + reportTime + '\'' +
                ", processTime=" + processTime + '\'' +
                ", goodsState=" + goodsState + '\'' +
                ", disposeName=" + disposeName + '}';
    }
}



