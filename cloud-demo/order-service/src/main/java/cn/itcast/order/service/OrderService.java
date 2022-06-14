package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired//根据类型自动注入
//    @Resource(name = "hello")//根据名称自动注入
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.利用RestTemplate发起http请求，查询用户
        String url = "http://userserver/user/"+order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        // 3.封装user到order
        order.setUser(user);

        // 4.返回
        return order;
    }
}
