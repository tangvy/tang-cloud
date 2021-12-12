package com.tangv.cloud.shardingjdbc.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * author:   tangwei
 * Date:     2021/12/3 22:35
 * Description:
 */
@Slf4j
public class PreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<Integer> preciseShardingValue) {
        log.info("tableNames: {}", tableNames.toString());
        log.info("preciseShardingValue: {}", preciseShardingValue);
        for (String tableName : tableNames) {
            if (tableName.endsWith(preciseShardingValue.getValue() % 3 + 1 + "")) {
                return tableName;
            }
        }
        log.error("未匹配到对应表");
        return null;
    }
}