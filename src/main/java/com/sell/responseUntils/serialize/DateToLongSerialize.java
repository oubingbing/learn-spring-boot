package com.sell.responseUntils.serialize;import com.fasterxml.jackson.core.JsonGenerator;import com.fasterxml.jackson.databind.JsonSerializer;import com.fasterxml.jackson.databind.SerializerProvider;import java.util.Date;public class DateToLongSerialize extends JsonSerializer<Date> {    @Override    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {        //jsonGenerator.writeNumber(date.getTime()/1000);        //这是可以格式化数据的一种手段，写好之后在对应的数据上使用注解        //@JsonSerializer(using=DateToLongSerialize.class)        //这东西听实用的    }}