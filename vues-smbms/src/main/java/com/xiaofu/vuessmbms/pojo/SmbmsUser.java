package com.xiaofu.vuessmbms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class SmbmsUser implements Serializable {
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "用户编码")
    private String usercode;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String userpassword;

    @ApiModelProperty(value = "性别（1:女、 2:男）")
    private Integer gender;

    @ApiModelProperty(value = "出生日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+08")
    private Date birthday;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "用户角色（取自角色表-角色id）")
    private Long userrole;

    @ApiModelProperty(value = "用户角色（取自角色表-角色id）")
    private String rolename;

    @ApiModelProperty(value = "创建者（userId）")
    private Long createdby;

    @ApiModelProperty(value = "创建时间")
    private Date creationdate;

    @ApiModelProperty(value = "更新者（userId）")
    private Long modifyby;

    @ApiModelProperty(value = "更新时间")
    private Date modifydate;

    private static final long serialVersionUID = 1L;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserrole() {
        return userrole;
    }

    public void setUserrole(Long userrole) {
        this.userrole = userrole;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usercode=").append(usercode);
        sb.append(", username=").append(username);
        sb.append(", userpassword=").append(userpassword);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", userrole=").append(userrole);
        sb.append(", createdby=").append(createdby);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", modifyby=").append(modifyby);
        sb.append(", modifydate=").append(modifydate);
        sb.append(", rolename=").append(rolename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}