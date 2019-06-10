package com.dengzhili;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * describe:
 *
 * @author dengzl
 * @date 2019/06/10
 */
public class Goods implements Serializable {

    //未添加@Excel注解，不解析
    private String id;

    //商品编号，主键（Integer类型的取值）
    @Excel(name = "NO",width = 20)
    private Integer no;
    //商品名称（String类型的取值）
    @Excel(name = "商品名称",width = 20)
    private String name;
    //1 食品 2 服装 3 酒水 4 花卉
    //商品所属类别（Integer类型的取值，对应的数值要转成相应的文字）
    @Excel(name = "商品类别",width = 20)
    private Integer type;
    //商品保质器（测试日期值得获取）
    @Excel(name = "保质期",width = 20,exportFormat = "yyyy-MM-dd")
    private Date shelfLife;
    //库存是否还有?0 无 1有(测试Integer类型的三目运算)
    @Excel(name = "库存是否还有",width = 20)
    private Integer isHave;

    //该商品是否经过了审核"0" 未过，"1" 通过(测试String类型的三目运算)
    private String  isAudit;


    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Integer getIsHave() {
        return isHave;
    }

    public void setIsHave(Integer isHave) {
        this.isHave = isHave;
    }

    public String getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Goods() {
    }

    public Goods(Integer no, String name, Integer type, Date shelfLife, Integer isHave, String isAudit) {
        this.no = no;
        this.name = name;
        this.type = type;
        this.shelfLife = shelfLife;
        this.isHave = isHave;
        this.isAudit = isAudit;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", no=" + no +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", shelfLife=" + shelfLife +
                ", isHave=" + isHave +
                ", isAudit='" + isAudit + '\'' +
                '}';
    }
}
