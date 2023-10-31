package com.fundriser.models;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "fundrisers")
public class FundriserModel {

    public String _id;
    public String applicantId;
    public String applicantName;
    public String applicantEmail;
    public String applicantMobile;
    public String title;
    public String description;
    public String bannerImage;
    public String fundriserPurpose;
    public String deadline;
    public Integer targetAmount;
    public Integer collectedAmount;
    public String extraImg1;
    public String extraImg2;
    public String extraImg3;

    public FundriserModel() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getFundriserPurpose() {
        return fundriserPurpose;
    }

    public void setFundriserPurpose(String fundriserPurpose) {
        this.fundriserPurpose = fundriserPurpose;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Integer getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Integer targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Integer getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(Integer collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public String getExtraImg1() {
        return extraImg1;
    }

    public void setExtraImg1(String extraImg1) {
        this.extraImg1 = extraImg1;
    }

    public String getExtraImg2() {
        return extraImg2;
    }

    public void setExtraImg2(String extraImg2) {
        this.extraImg2 = extraImg2;
    }

    public String getExtraImg3() {
        return extraImg3;
    }

    public void setExtraImg3(String extraImg3) {
        this.extraImg3 = extraImg3;
    }

    @Override
    public String toString() {
        return "FundriserModel{" +
                "_id='" + _id + '\'' +
                ", applicantId='" + applicantId + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", applicantEmail='" + applicantEmail + '\'' +
                ", applicantMobile='" + applicantMobile + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", bannerImage='" + bannerImage + '\'' +
                ", fundriserPurpose='" + fundriserPurpose + '\'' +
                ", deadline='" + deadline + '\'' +
                ", extraImg1='" + extraImg1 + '\'' +
                ", extraImg2='" + extraImg2 + '\'' +
                ", extraImg3='" + extraImg3 + '\'' +
                '}';
    }
}
