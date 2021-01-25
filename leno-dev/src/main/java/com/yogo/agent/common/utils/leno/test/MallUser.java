package com.yogo.agent.common.utils.leno.test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author 
 * @Date 2020-11-12 11:42:28
 * @Description
 **/
public class MallUser {

	/**
	 * 无备注
	 */
	 private Integer id;

	/**
	 * 商城id
	 */
	 private Integer merchantId;

	/**
	 * 用户名
	 */
	 private String userName;

	/**
	 * 密码，加密存储
	 */
	 private String password;

	/**
	 * 昵称
	 */
	 private String nickName;

	/**
	 * 性别(1男，2女，0保密)
	 */
	 private Boolean sex;

	/**
	 * 注册手机号
	 */
	 private String phone;

	/**
	 * 邮箱
	 */
	 private String email;

	/**
	 * 会员等级
	 */
	 private Integer vipId;

	/**
	 * 只有在用户将公众号绑定到微信开放平台账号后，才会出现该字段
	 */
	 private String unionId;

	/**
	 * 注册时间
	 */
	 private Date createTime;

	/**
	 * 金额
	 */
	 private BigDecimal money;

	/**
	 * 会员来源(0是普通注册，1是添加，2，微信 3，手机，4，小程序)
	 */
	 private String source;

	/**
	 * 状态（1正常，0锁定）
	 */
	 private Boolean state;

	/**
	 * 更新时间
	 */
	 private Date updateTime;

	/**
	 * 头像地址
	 */
	 private String headImage;

	/**
	 * 微信唯一标志
	 */
	 private String weOpenId;

	/**
	 * 所在地区
	 */
	 private String location;

	/**
	 * 用户特权信息，json数组，如微信沃卡用户（chinaunicom）
	 */
	 private String wxPrivilege;

	/**
	 * 修改用户名权限
	 */
	 private Boolean changeUserName;

	/**
	 * 账户积分
	 */
	 private String integral;

	/**
	 * 支付密码
	 */
	 private Integer payPassword;

	/**
	 * 个性签名
	 */
	 private String signature;

	/**
	 * 客户分群id
	 */
	 private Integer customerLabelId;

	/**
	 * 生日
	 */
	 private Character birthday;

	/**
	 * 无备注
	 */
	 private String repairSign;

	

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getVipId() {
		return vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getWeOpenId() {
		return weOpenId;
	}

	public void setWeOpenId(String weOpenId) {
		this.weOpenId = weOpenId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWxPrivilege() {
		return wxPrivilege;
	}

	public void setWxPrivilege(String wxPrivilege) {
		this.wxPrivilege = wxPrivilege;
	}

	public Boolean getChangeUserName() {
		return changeUserName;
	}

	public void setChangeUserName(Boolean changeUserName) {
		this.changeUserName = changeUserName;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public Integer getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(Integer payPassword) {
		this.payPassword = payPassword;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getCustomerLabelId() {
		return customerLabelId;
	}

	public void setCustomerLabelId(Integer customerLabelId) {
		this.customerLabelId = customerLabelId;
	}

	public Character getBirthday() {
		return birthday;
	}

	public void setBirthday(Character birthday) {
		this.birthday = birthday;
	}

	public String getRepairSign() {
		return repairSign;
	}

	public void setRepairSign(String repairSign) {
		this.repairSign = repairSign;
	}

}