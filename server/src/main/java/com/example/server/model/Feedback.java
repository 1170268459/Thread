package com.example.server.model;

import java.util.Date;

public class Feedback {
    private Date tec_ts;
    private Date resp_te;
    private Date ts_diff;

    public Date getTec_ts() {
        return tec_ts;
    }

    public void setTec_ts(Date tec_ts) {
        this.tec_ts = tec_ts;
    }

    public Date getResp_te() {
        return resp_te;
    }

    public void setResp_te(Date resp_te) {
        this.resp_te = resp_te;
    }

    public Date getTs_diff() {
        return ts_diff;
    }

    public void setTs_diff(Date ts_diff) {
        this.ts_diff = ts_diff;
    }


}
