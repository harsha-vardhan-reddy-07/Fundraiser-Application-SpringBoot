package com.fundriser.models;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "donations")
public class DonationsModel {

    public String _id;
    public String donarId;
    public String donarName;
    public String donarEmail;
    public Integer donationAmount;
    public String remark;
    public String fundriserId;
    public String fundriserPurpose;

    public DonationsModel() {
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDonarId() {
        return donarId;
    }

    public void setDonarId(String donarId) {
        this.donarId = donarId;
    }

    public String getDonarName() {
        return donarName;
    }

    public void setDonarName(String donarName) {
        this.donarName = donarName;
    }

    public String getDonarEmail() {
        return donarEmail;
    }

    public void setDonarEmail(String donarEmail) {
        this.donarEmail = donarEmail;
    }

    public Integer getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(Integer donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFundriserId() {
        return fundriserId;
    }

    public void setFundriserId(String fundriserId) {
        this.fundriserId = fundriserId;
    }

    public String getFundriserPurpose() {
        return fundriserPurpose;
    }

    public void setFundriserPurpose(String fundriserPurpose) {
        this.fundriserPurpose = fundriserPurpose;
    }

    @Override
    public String toString() {
        return "DonationsModel{" +
                "_id='" + _id + '\'' +
                ", donarId='" + donarId + '\'' +
                ", donarName='" + donarName + '\'' +
                ", donarEmail='" + donarEmail + '\'' +
                ", remark='" + remark + '\'' +
                ", fundriserId='" + fundriserId + '\'' +
                ", fundriserPurpose='" + fundriserPurpose + '\'' +
                '}';
    }
}
