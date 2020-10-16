/**
 * coder4j.cn
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule.apollo.degrade;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author buhao
 * @version ParamFlowRuleApolloPublisher.java, v 0.1 2019-09-06 11:01 buhao
 */
@Component("degradeRuleApolloPublisher")
public class DegradeRuleApolloPublisher implements DynamicRulePublisher<List<DegradeRuleEntity>> {

    @Autowired
    private ApolloCommonService apolloCommonService;
    @Value("${degrade.key.suffix:degrade}")
    private String degradeDataIdSuffix;

    @Override
    public void publish(String app, List<DegradeRuleEntity> rules) throws Exception {
        apolloCommonService.publishRules(app, degradeDataIdSuffix, JSON.toJSONString(rules));
    }
}
