package com.lc.demo.bean;

/**
 * @author gmslymhn
 * @date 2023-08-04 21:01
 * @description:资金申请
 */

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

public class ApplyAssets {
    private Integer applyId;
    private float applyAssets;

    public Integer getApplyId() {
        return applyId;
    }

    private Integer applyNameId;
    private String applyName;

    private Integer disposeNameId;
    private String disposeName;

    private String applyDescription;
    private String disposeDescription;

    private Date applyTime;

    private Date disposeTime;

    private String applyState;
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getDisposeDescription() {
        return disposeDescription;
    }

    public void setDisposeDescription(String disposeDescription) {
        this.disposeDescription = disposeDescription;
    }


    public Integer getApplyNameId() {
        return applyNameId;
    }

    public void setApplyNameId(Integer applyNameId) {
        this.applyNameId = applyNameId;
    }

    public Integer getDisposeNameId() {
        return disposeNameId;
    }

    public void setDisposeNameId(Integer disposeNameId) {
        this.disposeNameId = disposeNameId;
    }


    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }




    public float getApplyAssets() {
        return applyAssets;
    }

    public void setApplyAssets(float applyAssets) {
        this.applyAssets = applyAssets;
    }


    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getDisposeName() {
        return disposeName;
    }

    public void setDisposeName(String disposeName) {
        this.disposeName = disposeName;
    }


    public String getApplyDescription() {
        return applyDescription;
    }

    public void setApplyDescription(String applyDescription) {
        this.applyDescription = applyDescription;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getDisposeTime() {
        return disposeTime;
    }

    public void setDisposeTime(Date disposeTime) {
        this.disposeTime = disposeTime;
    }






}
