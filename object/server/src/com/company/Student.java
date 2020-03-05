//***********************************************************************
// 《物联网系统设计》 实践项目1 客户端与服务器端程序的通讯——服务端程序
// 栗青生  2020年2月
// 学生类 ：和客户端中的Student 类相比，服务器端采用了不同的程序结构
//************************************************************************

package com.company;

import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 111L;
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        if (id != student.id) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return true;
    }

    public int hashCode() {
        return id;
    }
    public String toString() {
        return "Id = " + getId() + " ; Name = " + getName();
    }
}

