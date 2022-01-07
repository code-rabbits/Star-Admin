package com.star.generator;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  新版mybatis-plus代码生成器(只适用于3.5.1+版本，不兼容以前的老版本)
 *  快速生成
 */
public class  FastGenerator {
    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();  //要生成的数据库表集合
        tables.add("ms_comment");
        tables.add("ms_article_tag");


        /**
         * 快速生成
         */
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/blog2?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC","root","123456")
                .globalConfig(builder -> {
                    builder.author("聂建强")               //作者
                            .outputDir(System.getProperty("user.dir")+"\\src\\main\\java")    //输出路径(写到java目录)
                            .enableSwagger()           //开启swagger
                            .commentDate("yyyy-MM-dd")   //注释日期格式
                            .fileOverride();            //开启覆盖之前生成的文件

                })
                .packageConfig(builder -> {     //包配置
                    builder.parent("com.star")        //父包名
                            .moduleName("blog") //父包模块名
                            .entity("entity")  //Entity 包名
                            .service("service")  //Service 包名
                            .serviceImpl("service.impl") // Service Impl 包名
                            .controller("controller")   //Controller 包名
                            .mapper("mapper")  //Mapper 包名
                            .xml("mapper")    //Mapper XML 包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));  //路径配置信息
                })
                .strategyConfig(builder -> {      //策略配置
                    builder.addInclude(tables)  //配置要生成的表名，这里是一个List
                            .addTablePrefix("ms_")  //过滤表名前缀，如p_test,我们生成的类名只需要test
                            .serviceBuilder()      //service策略配置
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()      //entity策略配置
                            .enableLombok()       //开启lombok
                            .logicDeleteColumnName("deleted")  //说明逻辑删除是哪个字段
                            .enableTableFieldAnnotation()  //开启属性加上说明注解
                            .controllerBuilder()   //controller配置策略
                            .formatFileName("%sController")
                            .enableRestStyle()   //开启restController
                            .mapperBuilder()     //mapper配置策略
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper");
                })
                .execute();
    }

}
