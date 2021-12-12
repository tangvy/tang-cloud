package com.tangv.cloud.shardingjdbc.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * author:   tangwei
 * Date:     2021/12/3 22:29
 * Description: 自定义数据源分片策略
 */
@Slf4j
public class PreciseModuloShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> databaseNames, PreciseShardingValue<Integer> preciseShardingValue) {
        log.info("databaseNames: {}", databaseNames.toString());
        log.info("preciseShardingValue: {}", preciseShardingValue.toString());
        for (String databaseName : databaseNames) {
            if (databaseName.endsWith(preciseShardingValue.getValue() % 2 + "")) {
                return databaseName;
            }
        }
        log.error("未匹配到对应数据库");
        return null;
    }
}