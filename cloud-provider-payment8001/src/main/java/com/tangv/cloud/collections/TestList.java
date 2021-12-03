package com.tangv.cloud.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * author:   tangwei
 * Date:     2021/8/28 7:44
 * Description:
 */
@Slf4j
public class TestList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(5);
        list.add(9);
        list.add(null);
        list.add(5);
        list.add(null);
        list.add(null);
        System.out.println(list);
        list.remove(null);
        System.out.println(list);
    }
}