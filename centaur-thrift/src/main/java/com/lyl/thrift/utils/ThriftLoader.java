package com.lyl.thrift.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lyl
 * Date 2018/12/28 16:25
 */
public class ThriftLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftLoader.class);


    public ThriftLoader() {
    }

    public static void main(String[] args) {
        LOGGER.info("ThriftLoader()");
        LOGGER.trace("trace level");
        LOGGER.debug("debug level");
        LOGGER.info("info level");
        LOGGER.warn("warn level");
        LOGGER.error("error level");
    }
}
