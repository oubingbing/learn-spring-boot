package com.sell.enums;import lombok.Getter;@Getterpublic enum OrderStatusEnum implements CodeEnum{    NEW(0,"新订单"),    FINISH(1,"完结订单"),    CANCEL(2,"取消订单");    private Integer code;    private String message;    OrderStatusEnum(Integer code,String message){        this.code = code;        this.message = message;    }    //根据枚举值获取枚举    /*public static OrderStatusEnum getOrderStatusEnum(Integer code){        for (OrderStatusEnum orderStatusEnum:OrderStatusEnum.values()){            if(orderStatusEnum.getCode().equals(code)){                return  orderStatusEnum;            }        }        return null;    }*/}