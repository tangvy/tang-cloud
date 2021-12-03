package com.tangv.cloud.collections;


import com.tangv.cloud.model.Goods;

import java.util.*;

/**
 * author:   tangwei
 * Date:     2021/8/28 9:55
 * Description:
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(3);
        System.out.println(Runtime.getRuntime().availableProcessors());
        List<String> list = new ArrayList<>(3);
        list.add("a");
        list.add("b");
        list.add("c");
        for (String s : list) {
            list.remove(1);
        }
    }
}