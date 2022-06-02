package com.zyz.algorithm.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  选演剧本设备case
 *
 *  背景：
 *      群里有若干个设备，每个设备有多个人设
 *      想要找出可以演剧本的若干个设备（剧本有多个人设）
 *
 * @author yunzhen.zhang
 * @date 2022/04/18
 */
public class PickRoleBackingTracking {


    // 剧本需要人设
    private List<String> roles;


    //每个人设对应的设备
    private Map<String, List<String>> map;


    public Map<String, String> pickDevice(List<String> roles, Map<String, List<String>> map) {


        HashMap<String, String> res = new HashMap<>();
        return dfs(roles, 0, map, res);
    }

    public Map<String, String> dfs(List<String> roles, int length, Map<String, List<String>> map, Map<String, String> deviceRole) {
        if (deviceRole.size() == roles.size()) {
            return deviceRole;
        }

        String role = roles.get(length);
        List<String> deviceNodes = map.get(role);
        Set<String> devices = map.keySet();
        deviceNodes.removeAll(devices);
        for (String device : deviceNodes) {
            deviceRole.put(role, device);
            dfs(roles, length + 1, map, deviceRole);
        }

        return null;
    }


}
