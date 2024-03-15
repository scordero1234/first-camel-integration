package org.apache.camel.learn;
import org.apache.camel.dataformat.bindy.annotation.*;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class CreditCardData {
    
 
    @DataField( pos = 1,name="ID")
    private String id;

     @DataField( pos = 2,name="LIMIT_BAL")
    private String limitBalance;

     @DataField( pos = 3,name="SEX")
    private String sex;

     @DataField( pos = 4,name="EDUCATION")
    private String education;

     @DataField( pos = 5,name="MARRIAGE")
    private String marriage;

     @DataField( pos = 6,name="AGE")
    private String age;

     @DataField( pos = 7,name="PAY_0")
    private String pay_0;

     @DataField( pos = 8,name="PAY_2")
    private String pay_2;

     @DataField( pos = 9,name="PAY_3")
    private String pay_3;

     @DataField( pos = 10,name="PAY_4")
    private String pay_4;

     @DataField( pos = 11,name="PAY_5")
    private String pay_5;


     @DataField( pos = 12,name="PAY_6")
    private String pay_6;

     @DataField( pos = 13,name="BILL_1")
    private String bill1;

     @DataField( pos = 14,name="BILL_2")
    private String bill2;

     @DataField( pos = 15,name="BILL_3")
    private String bill3;

     @DataField( pos = 16,name="BILL_4")
    private String bill4;

     @DataField( pos = 17,name="BILL_5")
    private String bill5;

     @DataField( pos = 18,name="BILL_6")
    private String bill6;

  @DataField( pos = 19,name="PAY_1")
    private String pay1;

    @DataField( pos = 20,name="PAY_2")
    private String pay2;

     @DataField( pos = 21,name="PAY_3")
    private String pay3;

     @DataField( pos = 22,name="PAY_4")
    private String pay4;

     @DataField( pos = 23,name="PAY_5")
    private String pay5;


     @DataField( pos = 24,name="PAY_6")
    private String pay6;
    @DataField( pos = 25,name="DEFAULT_PAYMENT_NEXT_MONTH")
    private String defaultPaymentNextMonth;

    @Override
    public String toString() {
        return "CreditCardData{" +
                "id='" + id + '\'' +
               
                ", bill1='" + bill1 + '\'' +
                ", bill2='" + bill2 + '\'' +
                ", bill3='" + bill3 + '\'' +
                ", bill4='" + bill4 + '\'' +
                ", bill5='" + bill5 + '\'' +
                ", bill6='" + bill6 + '\'' +
                ", pay1='" + pay1 + '\'' +
                ", pay2='" + pay2 + '\'' +
                ", pay3='" + pay3 + '\'' +
                ", pay4='" + pay4 + '\'' +
                ", pay5='" + pay5 + '\'' +
                ", pay6='" + pay6 + '\'' +
              
                '}';
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLimitBalance() {
        return limitBalance;
    }

    public void setLimitBalance(String limitBalance) {
        this.limitBalance = limitBalance;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPay0() {
        return pay_0;
    }

    public void setPay0(String pay0) {
        this.pay_0 = pay0;
    }

    public String getPay_2() {
        return pay_2;
    }

    public void setPay_2(String pay_2) {
        this.pay_2 = pay_2;
    }

    public String getPay_3() {
        return pay_3;
    }

    public void setPay_3(String pay_3) {
        this.pay_3 = pay_3;
    }

    public String getPay_4() {
        return pay_4;
    }

    public void setPay_4(String pay_4) {
        this.pay_4 = pay_4;
    }

    public String getPay_5() {
        return pay_5;
    }

    public void setPay_5(String pay_5) {
        this.pay_5 = pay_5;
    }

    public String getPay_6() {
        return pay_6;
    }

    public void setPay_6(String pay_6) {
        this.pay_6 = pay_6;
    }

    public String getBill1() {
        return bill1;
    }

    public void setBill1(String bill1) {
        this.bill1 = bill1;
    }

    public String getBill2() {
        return bill2;
    }

    public void setBill2(String bill2) {
        this.bill2 = bill2;
    }

    public String getBill3() {
        return bill3;
    }

    public void setBill3(String bill3) {
        this.bill3 = bill3;
    }

    public String getBill4() {
        return bill4;
    }

    public void setBill4(String bill4) {
        this.bill4 = bill4;
    }

    public String getBill5() {
        return bill5;
    }

    public void setBill5(String bill5) {
        this.bill5 = bill5;
    }

    public String getBill6() {
        return bill6;
    }

    public void setBill6(String bill6) {
        this.bill6 = bill6;
    }

    public String getPay1() {
        return pay1;
    }

    public void setPay1(String pay1) {
        this.pay1 = pay1;
    }

    public String getPay2() {
        return pay2;
    }

    public void setPay2(String pay2) {
        this.pay2 = pay2;
    }

    public String getPay3() {
        return pay3;
    }

    public void setPay3(String pay3) {
        this.pay3 = pay3;
    }

    public String getPay4() {
        return pay4;
    }

    public void setPay4(String pay4) {
        this.pay4 = pay4;
    }

    public String getPay5() {
        return pay5;
    }

    public void setPay5(String pay5) {
        this.pay5 = pay5;
    }

    public String getPay6() {
        return pay6;
    }

    public void setPay6(String pay6) {
        this.pay6 = pay6;
    }

    public String getDefaultPaymentNextMonth() {
        return defaultPaymentNextMonth;
    }

    public void setDefaultPaymentNextMonth(String defaultPaymentNextMonth) {
        this.defaultPaymentNextMonth = defaultPaymentNextMonth;
    }
  

 
}
