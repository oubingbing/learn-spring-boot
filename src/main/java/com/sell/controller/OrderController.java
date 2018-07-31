package com.sell.controller;import com.sell.converter.OrderFormToOrderDTO;import com.sell.dataTransferObject.OrderDTO;import com.sell.enums.ResponseEnum;import com.sell.exception.SellException;import com.sell.form.OrderForm;import com.sell.responseUntils.ResponseResult;import com.sell.responseobject.Response;import com.sell.service.OrderService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;import org.springframework.data.domain.PageRequest;import org.springframework.util.CollectionUtils;import org.springframework.util.StringUtils;import org.springframework.validation.BindingResult;import org.springframework.web.bind.annotation.*;import javax.validation.Valid;import java.util.HashMap;import java.util.List;import java.util.Map;@RestController@RequestMapping("/buyer/order")public class OrderController {    @Autowired    private OrderService orderService;    /**     * 新建订单     * 返回的是一个Response，里面的data是一个map键值对     * @param orderForm     * @param bindingResult     * @return     */    @PostMapping("/create")    public Response<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){        //判断表单验证是否有错误        if(bindingResult.hasErrors()){            //获取表单错误信息，bindingResult.getFieldError().getDefaultMessage()            throw new SellException(ResponseEnum.ORDER_NOT_EXIST.getCode(),bindingResult.getFieldError().getDefaultMessage());        }        //表单数据转换成传输数据        OrderDTO orderDTO = OrderFormToOrderDTO.convert(orderForm);        if(CollectionUtils.isEmpty(orderDTO.getOrderDetails())){            throw new SellException(ResponseEnum.ORDER_CART_EMPTY);        }        OrderDTO result = orderService.create(orderDTO);        Map<String,String> map = new HashMap<>();        map.put("order_id", result.getOrderId());        return ResponseResult.success(map);    }    /**     * 获取用户的订单列表     * @param openid     * @param page     * @param size     * @return     */    @GetMapping("/list")    public Response<List<OrderDTO>> list(@RequestParam("openid") String openid,                                         @RequestParam(value = "page",defaultValue = "0") Integer page,                                         @RequestParam(value = "size",defaultValue = "10") Integer size){        if(StringUtils.isEmpty(openid)){            throw new SellException(ResponseEnum.PARAM_ERROR);        }        PageRequest request = new PageRequest(page,size);        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);        return ResponseResult.success(orderDTOPage.getContent());    }}