//package com.platform.papafood.config;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.MessageSource;
//import org.springframework.stereotype.Component;
//
//import java.util.Locale;
//
//@Component
//public class MessageHelper implements InitializingBean {
//
//    @Autowired
//    @Qualifier("messageResourceBean")
//    private MessageSource messageResourceBean;
//
//    private static MessageHelper instance;
//    private static final Locale VN = new Locale("vi", "VN");
//
//    @Override
//    public void afterPropertiesSet() {
//        MessageHelper.instance = this;
//    }
//
//    public static String translate(String key, Object... args) {
//        return instance.messageResourceBean.getMessage(key, args, VN);
//    }
//}
