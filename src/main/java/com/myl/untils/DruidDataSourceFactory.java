package com.myl.untils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

public class DruidDataSourceFactory extends PooledDataSourceFactory {

    public DruidDataSourceFactory() {

        //替换Druid数据源
        this.dataSource= new DruidDataSource();

    }
}
