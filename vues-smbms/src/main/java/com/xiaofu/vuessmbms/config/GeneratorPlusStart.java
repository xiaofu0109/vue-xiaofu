package com.xiaofu.vuessmbms.config;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorPlusStart {

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        //mbg执行过程中的警告信息
        List<String> warning = new ArrayList<>();
        //当代码重复是，覆盖原代码
        boolean overwrite = true;

        //读取配置文件
        InputStream is = GeneratorPlusStart.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warning);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建mgb
        MyBatisGenerator generator = new MyBatisGenerator(config,callback,warning);
        generator.generate(null);

        for (String ss:warning){
            System.out.println(ss + "---------------");
        }

    }
}
