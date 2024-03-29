package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Reg3")
public class Register implements Serializable {
    /**
	 * 
	 */
	//private static final long serialVersionUID = -6206009238197715960L;;

	@Id
    private String email;
    private String ename;
    private String mob;
    private String password;
    private String cnpassword;
private String adminmob;
    public Register() {
        // Default constructor
    }

    // Getters and setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnpassword() {
        return cnpassword;
    }

    public void setCnpassword(String cnpassword) {
        this.cnpassword = cnpassword;
    }

    public String getAdminmob() {
        return adminmob;
    }

    public void setAdminmob(String adminmob) {
        this.adminmob = adminmob;
    }

    @Override
    public String toString() {
        return "Register{" +
                "email='" + email + '\'' +
                ", ename='" + ename + '\'' +
                ", mob='" + mob + '\'' +
                ", password='" + password + '\'' +
                ", cnpassword='" + cnpassword + '\'' +
                ", adminmob='" + adminmob + '\'' +
                '}';
    }
}
