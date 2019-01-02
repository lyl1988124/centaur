package com.lyl.thrift.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by lyl
 * Date 2018/12/28 16:25
 */
public class ThriftLoader {

    private static final Logger LOGGER = LogManager.getLogger(ThriftLoader.class);


    public ThriftLoader() {
    }

    public static void main(String[] args) {
        LOGGER.trace("trace level");
        LOGGER.debug("debug level");
        LOGGER.info("info level");
        LOGGER.warn("warn level");
        LOGGER.error("error level");
        LOGGER.fatal("fatal level");
    }
}
