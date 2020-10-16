/**
 * coder4j.cn
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule.apollo.degrade;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author buhao
 * @version DegradeRuleApolloProvider.java, v 0.1 2019-09-09 21:59 buhao
 */
@Component("degradeRuleApolloProvider")
public class DegradeRuleApolloProvider implements DynamicRuleProvider<List<DegradeRuleEntity>> {

    @Autowired
    private ApolloCommonService apolloCommonService;
    @Value("${degrade.key.suffix:degrade}")
    private String degradeDataIdSuffix;

    @Override
    public List<DegradeRuleEntity> getRules(String appName) throws Exception {
        return apolloCommonService.getRules(appName, degradeDataIdSuffix, DegradeRuleEntity.class);
    }
}