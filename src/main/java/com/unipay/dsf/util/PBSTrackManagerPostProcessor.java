package com.unipay.dsf.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.unipay.dsf.service.InitService;

/**
 * Filename:PBSTrackManagerPostProcessor.java
 * Description: 启动加载数据到redis
 * @author litong
 * @date 2017年3月9日 下午3:49:04
 */
@Component
public class PBSTrackManagerPostProcessor implements BeanPostProcessor {  
	  
    public Object postProcessAfterInitialization(Object obj, String arg1)  
            throws BeansException {  
        if(obj instanceof InitService) {  
        	((InitService)obj).init(); //调用方法加载数据  
        }  
        return obj;  
    }  
  
    public Object postProcessBeforeInitialization(Object arg0, String arg1)  
            throws BeansException {  
        return arg0;  
    }  
} 