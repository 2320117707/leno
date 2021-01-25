package com.yogo.agent.common.utils.leno.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author owen
 * @Date 2020/11/4
 * @Description
 **/

public class TestObject {
    private List<Integer> integerList;

    private BigDecimal freight;
    private String characterString;

    /**
     * false             占1个字节  八位
     */
    private boolean basicBoolean;
    /**
     * "'uoooo'"         占2个字节  16位
     */
    private char basicChar;
    /**
     * (byte)0       占1个字节  八位
     */
    private byte basicByte;
    /**
     * (short)0        占2个字节  八位
     */
    private short basicShort;
    /**
     * 0             占4个字节  32位
     */
    private int basicInt;
    /**
     * 0               占8个字节  64位
     */
    private long basicLong;
    /**
     * 0.0f          占4个字节  32位
     */
    private float basicFloat;
    /**
     * 0.0d          占8个字节  64位
     */
    private double basicDouble;
    private Map<String, String> maps;

    /**
     * 包装类默认值为null
     */
    private Byte packageByte;
    private Short packageShort;
    private Integer packageInteger;
    private Long packageLong;
    private Float packageFloat;
    private Double packageDouble;
    private Character packageCharacter;
    private Boolean packageBoolean;
    /**
     * 时间
     */
    private Date time;

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }



    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getCharacterString() {
        return characterString;
    }

    public void setCharacterString(String characterString) {
        this.characterString = characterString;
    }

    public boolean isBasicBoolean() {
        return basicBoolean;
    }

    public void setBasicBoolean(boolean basicBoolean) {
        this.basicBoolean = basicBoolean;
    }

    public char getBasicChar() {
        return basicChar;
    }

    public void setBasicChar(char basicChar) {
        this.basicChar = basicChar;
    }

    public byte getBasicByte() {
        return basicByte;
    }

    public void setBasicByte(byte basicByte) {
        this.basicByte = basicByte;
    }

    public short getBasicShort() {
        return basicShort;
    }

    public void setBasicShort(short basicShort) {
        this.basicShort = basicShort;
    }

    public int getBasicInt() {
        return basicInt;
    }

    public void setBasicInt(int basicInt) {
        this.basicInt = basicInt;
    }

    public long getBasicLong() {
        return basicLong;
    }

    public void setBasicLong(long basicLong) {
        this.basicLong = basicLong;
    }

    public float getBasicFloat() {
        return basicFloat;
    }

    public void setBasicFloat(float basicFloat) {
        this.basicFloat = basicFloat;
    }

    public double getBasicDouble() {
        return basicDouble;
    }

    public void setBasicDouble(double basicDouble) {
        this.basicDouble = basicDouble;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Byte getPackageByte() {
        return packageByte;
    }

    public void setPackageByte(Byte packageByte) {
        this.packageByte = packageByte;
    }

    public Short getPackageShort() {
        return packageShort;
    }

    public void setPackageShort(Short packageShort) {
        this.packageShort = packageShort;
    }

    public Integer getPackageInteger() {
        return packageInteger;
    }

    public void setPackageInteger(Integer packageInteger) {
        this.packageInteger = packageInteger;
    }

    public Long getPackageLong() {
        return packageLong;
    }

    public void setPackageLong(Long packageLong) {
        this.packageLong = packageLong;
    }

    public Float getPackageFloat() {
        return packageFloat;
    }

    public void setPackageFloat(Float packageFloat) {
        this.packageFloat = packageFloat;
    }

    public Double getPackageDouble() {
        return packageDouble;
    }

    public void setPackageDouble(Double packageDouble) {
        this.packageDouble = packageDouble;
    }

    public Character getPackageCharacter() {
        return packageCharacter;
    }

    public void setPackageCharacter(Character packageCharacter) {
        this.packageCharacter = packageCharacter;
    }

    public Boolean getPackageBoolean() {
        return packageBoolean;
    }

    public void setPackageBoolean(Boolean packageBoolean) {
        this.packageBoolean = packageBoolean;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}





