package com.xq.service;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Mechrevo
 * @version v1.0
 * 2020/3/13 20:16
 */
public interface UserService {
    Map getUser(Serializable id);
}
