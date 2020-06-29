package com.example.postgresdemo.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
public class ExamMasterBankIdentity {

    @NotNull
    private Long cid;

    @NotNull
    private Long sid;

    @NotNull
    private Long eid;

    public ExamMasterBankIdentity(Long cid, Long sid, Long eid) {
        this.cid = cid;
        this.sid = sid;
        this.eid = eid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamMasterBankIdentity that = (ExamMasterBankIdentity) o;

        if (!cid.equals(that.cid)) return false;
        if (!sid.equals(that.sid)) return false;
        return eid.equals(that.eid);
    }

    @Override
    public int hashCode() {
        int result = cid.hashCode();
        result = 11 * result + sid.hashCode();
        result = 11 * result + eid.hashCode();
        return result;
    }
}
