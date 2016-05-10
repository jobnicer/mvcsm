package org.ssm.autocode; 

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
* @Package : generator
* @FileName : Generator
* @Description : 自动生成代码类
* @Author : YJ
* @Date : 2015-7-23 下午02:15:56
*/
public class Generator {
	
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = null;
		try {
			config = cp.parseConfiguration(
			        Generator.class.getResourceAsStream("generatorConfig.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e1) {
			e1.printStackTrace();
		}
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = null;
		
		try {
			myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		} catch (InvalidConfigurationException e1) {
			e1.printStackTrace();
		}
		try {
			myBatisGenerator.generate(null);
			System.out.println("AutoCode Successful!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
 
