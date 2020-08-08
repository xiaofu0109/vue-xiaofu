package com.xiaofu.vuessmbms.pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SmbmsBill implements Serializable {
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "账单编码")
    private String billcode;

    @ApiModelProperty(value = "商品名称")
    private String productname;

    @ApiModelProperty(value = "商品描述")
    private String productdesc;

    @ApiModelProperty(value = "商品单位")
    private String productunit;

    @ApiModelProperty(value = "商品数量")
    private BigDecimal productcount;

    @ApiModelProperty(value = "商品总额")
    private BigDecimal totalprice;

    @ApiModelProperty(value = "是否支付（1：未支付 2：已支付）")
    private Integer ispayment;

    @ApiModelProperty(value = "创建者（userId）")
    private Long createdby;

    @ApiModelProperty(value = "创建时间")
    private Date creationdate;

    @ApiModelProperty(value = "更新者（userId）")
    private Long modifyby;

    @ApiModelProperty(value = "更新时间")
    private Date modifydate;

    @ApiModelProperty(value = "供应商ID")
    private Long providerid;

    @ApiModelProperty(value = "供应商名称")
    private String proname;

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getProductunit() {
        return productunit;
    }

    public void setProductunit(String productunit) {
        this.productunit = productunit;
    }

    public BigDecimal getProductcount() {
        return productcount;
    }

    public void setProductcount(BigDecimal productcount) {
        this.productcount = productcount;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getIspayment() {
        return ispayment;
    }

    public void setIspayment(Integer ispayment) {
        this.ispayment = ispayment;
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

    public Long getProviderid() {
        return providerid;
    }

    public void setProviderid(Long providerid) {
        this.providerid = providerid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", billcode=").append(billcode);
        sb.append(", productname=").append(productname);
        sb.append(", productdesc=").append(productdesc);
        sb.append(", productunit=").append(productunit);
        sb.append(", productcount=").append(productcount);
        sb.append(", totalprice=").append(totalprice);
        sb.append(", ispayment=").append(ispayment);
        sb.append(", createdby=").append(createdby);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", modifyby=").append(modifyby);
        sb.append(", modifydate=").append(modifydate);
        sb.append(", providerid=").append(providerid);
        sb.append(", proname=").append(proname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}