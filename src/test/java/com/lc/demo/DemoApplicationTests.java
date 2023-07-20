package com.lc.demo;

import com.lc.demo.bean.*;
import com.lc.demo.mapper.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoApplicationTests {

    @Autowired
    private  UserMapper userMapper;

    @Autowired
    private  AssetsMapper asssetMapper;

    @Autowired
    private  Assets_LogMapper assets_logMapper;

    @Autowired
    private  GoodsMapper goodsMapper;

    @Autowired
    private  ReportMapper reportsMapper;
}
