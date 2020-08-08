package com.xiaofu.vuessmbms.pojo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SmbmsAddress implements Serializable {
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "联系人姓名")
    private String contact;

    @ApiModelProperty(value = "收货地址明细")
    private String addressdesc;

    @ApiModelProperty(value = "邮编")
    private String postcode;

    @ApiModelProperty(value = "联系人电话")
    private String tel;

    @ApiModelProperty(value = "创建者")
    private Long createdby;

    @ApiModelProperty(value = "创建时间")
    private Date creationdate;

    @ApiModelProperty(value = "修改者")
    private Long modifyby;

    @ApiModelProperty(value = "修改时间")
    private Date modifydate;

    @ApiModelProperty(value = "用户ID")
    private Long userid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddressdesc() {
        return addressdesc;
    }

    public void setAddressdesc(String addressdesc) {
        this.addressdesc = addressdesc;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", contact=").append(contact);
        sb.append(", addressdesc=").append(addressdesc);
        sb.append(", postcode=").append(postcode);
        sb.append(", tel=").append(tel);
        sb.append(", createdby=").append(createdby);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", modifyby=").append(modifyby);
        sb.append(", modifydate=").append(modifydate);
        sb.append(", userid=").append(userid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}