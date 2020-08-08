package com.xiaofu.vuessmbms.pojo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SmbmsProvider implements Serializable {
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "供应商编码")
    private String procode;

    @ApiModelProperty(value = "供应商名称")
    private String proname;

    @ApiModelProperty(value = "供应商详细描述")
    private String prodesc;

    @ApiModelProperty(value = "供应商联系人")
    private String procontact;

    @ApiModelProperty(value = "联系电话")
    private String prophone;

    @ApiModelProperty(value = "地址")
    private String proaddress;

    @ApiModelProperty(value = "传真")
    private String profax;

    @ApiModelProperty(value = "创建者（userId）")
    private Long createdby;

    @ApiModelProperty(value = "创建时间")
    private Date creationdate;

    @ApiModelProperty(value = "更新时间")
    private Date modifydate;

    @ApiModelProperty(value = "更新者（userId）")
    private Long modifyby;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcode() {
        return procode;
    }

    public void setProcode(String procode) {
        this.procode = procode;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProdesc() {
        return prodesc;
    }

    public void setProdesc(String prodesc) {
        this.prodesc = prodesc;
    }

    public String getProcontact() {
        return procontact;
    }

    public void setProcontact(String procontact) {
        this.procontact = procontact;
    }

    public String getProphone() {
        return prophone;
    }

    public void setProphone(String prophone) {
        this.prophone = prophone;
    }

    public String getProaddress() {
        return proaddress;
    }

    public void setProaddress(String proaddress) {
        this.proaddress = proaddress;
    }

    public String getProfax() {
        return profax;
    }

    public void setProfax(String profax) {
        this.profax = profax;
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

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", procode=").append(procode);
        sb.append(", proname=").append(proname);
        sb.append(", prodesc=").append(prodesc);
        sb.append(", procontact=").append(procontact);
        sb.append(", prophone=").append(prophone);
        sb.append(", proaddress=").append(proaddress);
        sb.append(", profax=").append(profax);
        sb.append(", createdby=").append(createdby);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", modifydate=").append(modifydate);
        sb.append(", modifyby=").append(modifyby);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}