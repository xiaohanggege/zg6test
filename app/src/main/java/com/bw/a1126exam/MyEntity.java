package com.bw.a1126exam;

public class MyEntity {

    public MyEntity(String num, boolean isno) {
        this.num = num;
        this.isno = isno;
    }

    private String num;
    boolean isno;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public boolean isIsno() {
        return isno;
    }

    public void setIsno(boolean isno) {
        this.isno = isno;
    }
}
