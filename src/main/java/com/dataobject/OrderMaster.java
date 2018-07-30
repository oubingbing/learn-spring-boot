package com.dataobject;import com.enums.OrderStatusEnum;import com.enums.PayStatusEnum;import lombok.Data;import org.hibernate.annotations.DynamicUpdate;import javax.persistence.Entity;import javax.persistence.Id;import java.math.BigDecimal;import java.util.Date;@Data@Entity@DynamicUpdatepublic class OrderMaster {    /** 订单ID */    @Id    private String orderId;    /** 卖家名字 */    private String buyerName;    /** 卖家电话 */    private  String buyerPhone;    /** 买家地址 */    private String buyerAddress;    /** 买家微信ID */    private String buyerOpenid;    /** 订单金额 */    private BigDecimal orderAmount;    /** 订单状态,0=默认新订单，1=完结订单，2=取消订单 */    private Integer orderStatus = OrderStatusEnum.NEW.getCode();    /** 订单支付状态 */    private Integer payStatus = PayStatusEnum.WAIT.getCode();    /** 创建时间 */    private Date createTime;    /** 更新时间 */    private Date updateTime;    /** 订单详情属性 */    //@Transient    //private List<OrderDetail> orderDetails;}