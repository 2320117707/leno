package com.yogo.agent.common.utils.leno.pojo;




import com.yogo.agent.common.utils.leno.anno.LenoField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author 
 * @Date 2020-11-12 14:29:33
 * @Description
 **/
public class Dog {

	/**
	 * 备注
	 */
	@LenoField(isKey = true)
	 private Integer dogId;

	/**
	 * 狗的名字
	 */
	 private String dogName;

	/**
	 * 是不是一条好狗
	 */
	 private Boolean isGoodDog;

	/**
	 * 无备注
	 */
	 private BigDecimal price;

	/**
	 * 狗的性别
	 */
	 private Character dogSex;

	/**
	 * 狗的生日
	 */
	 private Date dogBirthday;

	

	public Integer getDogId() {
		return dogId;
	}

	public void setDogId(Integer dogId) {
		this.dogId = dogId;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public Boolean getIsGoodDog() {
		return isGoodDog;
	}

	public void setIsGoodDog(Boolean isGoodDog) {
		this.isGoodDog = isGoodDog;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Character getDogSex() {
		return dogSex;
	}

	public void setDogSex(Character dogSex) {
		this.dogSex = dogSex;
	}

	public Date getDogBirthday() {
		return dogBirthday;
	}

	public void setDogBirthday(Date dogBirthday) {
		this.dogBirthday = dogBirthday;
	}

}
