package com.example.demo.model;

public class week {
    public String staff_id;
    public Boolean FirstDay;
    public Boolean SecondDay;
    public Boolean ThirdDay;
    public Boolean FourthDay;
    public Boolean FifthDay;
    public Boolean SixthDay;
    public Boolean SeventhDay;

    public week(String staff_id, Boolean FirstDay, Boolean SecondDay, Boolean ThirdDay, Boolean FourthDay, Boolean FifthDay, Boolean SixthDay, Boolean SeventhDay) {
        this.staff_id = staff_id;
        this.FirstDay = FirstDay;
        this.SecondDay = SecondDay;
        this.ThirdDay = ThirdDay;
        this.FourthDay = FourthDay;
        this.FifthDay = FifthDay;
        this.SixthDay = SixthDay;
        this.SeventhDay = SeventhDay;
    }

    public String getStaff_id() {
        return staff_id;
    }
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
    public Boolean getFirstDay() {
        return FirstDay;
    }
    public void setFirstDay(Boolean FirstDay) {
        this.FirstDay = FirstDay;
    }
    public Boolean getSecondDay() {
        return SecondDay;
    }
    public void setSecondDay(Boolean SecondDay) {
        this.SecondDay = SecondDay;
    }
    public Boolean getThirdDay() {
        return ThirdDay;
    }
    public void setThirdDay(Boolean ThirdDay) {
        this.ThirdDay = ThirdDay;
    }
    public Boolean getFourthDay() {
        return FourthDay;
    }
    public void setFourthDay(Boolean FourthDay) {
        this.FourthDay = FourthDay;
    }
    public Boolean getFifthDay() {
        return FifthDay;
    }
    public void setFifthDay(Boolean FifthDay) {
        this.FifthDay = FifthDay;
    }
    public Boolean getSixthDay() {
        return SixthDay;
    }
    public void setSixthDay(Boolean SixthDay) {
        this.SixthDay = SixthDay;
    }
    public Boolean getSeventhDay() {
        return SeventhDay;
    }
    public void setSeventhDay(Boolean SeventhDay) {
        this.SeventhDay = SeventhDay;
    }
}
