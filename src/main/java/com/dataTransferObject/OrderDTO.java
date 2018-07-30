package com.dataTransferObject;import com.dataobject.OrderDetail;import lombok.Data;import java.math.BigDecimal;import java.util.Date;import java.util.List;/** * 数据传输对象，用户数据传输 */@Datapublic class OrderDTO {    /** 订单ID */    private String orderId;    /** 卖家名字 */    private String buyerName;    /** 卖家电话 */    private  String buyerPhone;    /** 买家地址 */    private String buyerAddress;    /** 买家微信ID */    private String buyerOpenid;    /** 订单金额 */    private BigDecimal orderAmount;    /** 订单状态,0=默认新订单，1=完结订单，2=取消订单 */    private Integer orderStatus;    /** 订单支付状态 */    private Integer payStatus;    /** 创建时间 */    private Date createTime;    /** 更新时间 */    private Date updateTime;    /** 订单详情属性 */    private List<OrderDetail> orderDetails;}