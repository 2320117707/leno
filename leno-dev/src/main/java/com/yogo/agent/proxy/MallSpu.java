package com.yogo.agent.proxy;

                        import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author 
 * @Date 2021-02-02 23:40:59
 * @Description
 **/
public class MallSpu {

	/**
	 * spu id
	 */
	 private Integer id;

	/**
	 * 商户id
	 */
	 private Integer merchantId;

	/**
	 * 无备注
	 */
	 private Integer productCode;

	/**
	 * 商品名称
	 */
	 private String name;

	/**
	 * 副标题，一般是促销信息
	 */
	 private String subTitle;

	/**
	 * 1级类目id
	 */
	 private Integer cid1;

	/**
	 * 2级类目id
	 */
	 private Integer cid2;

	/**
	 * 3级类目id
	 */
	 private Integer cid3;

	/**
	 * 规格id
	 */
	 private String specId;

	/**
	 * 规格id
	 */
	 private String tagId;

	/**
	 * 无备注
	 */
	 private String image;

	/**
	 * 1级店内分类
	 */
	 private Integer cidStore1;

	/**
	 * 二级店内分类
	 */
	 private Integer cidStore;

	/**
	 * 商品类型 0实物商品 1海淘商品
	 */
	 private Integer goodsType;

	/**
	 * 商品所属品牌id
	 */
	 private Integer brandId;

	/**
	 * 产地
	 */
	 private String location;

	/**
	 * 规格类型 默认单规格
	 */
	 private Integer specType;

	/**
	 * 无备注
	 */
	 private String unit;

	/**
	 * 排序
	 */
	 private Integer sort;

	/**
	 * 无备注
	 */
	 private String pricePortal;

	/**
	 * 总销量
	 */
	 private Integer totalSales;

	/**
	 * 无备注
	 */
	 private String priceDisplay;

	/**
	 * 无备注
	 */
	 private String shipping;

	/**
	 * 无备注
	 */
	 private String freightTemplate;

	/**
	 * 无备注
	 */
	 private BigDecimal freight;

	/**
	 * 无备注
	 */
	 private Integer freightSetting;

	/**
	 * 是否上架，0下架，1上架
	 */
	 private Boolean saleable;

	/**
	 * 属性回显字段
	 */
	 private String oriAttribute;

	/**
	 * 前端需要存表格数据
	 */
	 private String oriDataList;

	/**
	 * 前端需要存表头
	 */
	 private String oriCols;

	/**
	 * 添加时间
	 */
	 private Date createTime;

	/**
	 * 最后修改时间
	 */
	 private Date updateTime;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getProductCode() {
		return productCode;
	}

	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getCid1() {
		return cid1;
	}

	public void setCid1(Integer cid1) {
		this.cid1 = cid1;
	}

	public Integer getCid2() {
		return cid2;
	}

	public void setCid2(Integer cid2) {
		this.cid2 = cid2;
	}

	public Integer getCid3() {
		return cid3;
	}

	public void setCid3(Integer cid3) {
		this.cid3 = cid3;
	}

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getCidStore1() {
		return cidStore1;
	}

	public void setCidStore1(Integer cidStore1) {
		this.cidStore1 = cidStore1;
	}

	public Integer getCidStore() {
		return cidStore;
	}

	public void setCidStore(Integer cidStore) {
		this.cidStore = cidStore;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSpecType() {
		return specType;
	}

	public void setSpecType(Integer specType) {
		this.specType = specType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getPricePortal() {
		return pricePortal;
	}

	public void setPricePortal(String pricePortal) {
		this.pricePortal = pricePortal;
	}

	public Integer getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(Integer totalSales) {
		this.totalSales = totalSales;
	}

	public String getPriceDisplay() {
		return priceDisplay;
	}

	public void setPriceDisplay(String priceDisplay) {
		this.priceDisplay = priceDisplay;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getFreightTemplate() {
		return freightTemplate;
	}

	public void setFreightTemplate(String freightTemplate) {
		this.freightTemplate = freightTemplate;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public Integer getFreightSetting() {
		return freightSetting;
	}

	public void setFreightSetting(Integer freightSetting) {
		this.freightSetting = freightSetting;
	}

	public Boolean getSaleable() {
		return saleable;
	}

	public void setSaleable(Boolean saleable) {
		this.saleable = saleable;
	}

	public String getOriAttribute() {
		return oriAttribute;
	}

	public void setOriAttribute(String oriAttribute) {
		this.oriAttribute = oriAttribute;
	}

	public String getOriDataList() {
		return oriDataList;
	}

	public void setOriDataList(String oriDataList) {
		this.oriDataList = oriDataList;
	}

	public String getOriCols() {
		return oriCols;
	}

	public void setOriCols(String oriCols) {
		this.oriCols = oriCols;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
                        