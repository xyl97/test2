package com.huangli.demo.pojo;

import lombok.Data;

@Data
public class Teacher {

    private String tno;
    private String tname;
    private String type;
    private String tpassword;

    public Teacher() {
    }

    public Teacher(String tno, String tname, String type, String tpassword) {
        this.tno = tno;
        this.tname = tname;
        this.type = type;
        this.tpassword = tpassword;
    }
}
