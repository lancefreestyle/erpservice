package com.capgemini.cn.erpmanage;

import com.capgemini.cn.erp.vo.*;
import com.google.gson.Gson;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={BasicServiceApplication.class})
public class Test {

    @org.junit.Test
    public void test() {
        Gson gson = new Gson();

//        SourceSystemVo sourceSystemVo = new SourceSystemVo();
//        sourceSystemVo.setId("1");
//
//        BusinessTypeVo businessTypeVo = new BusinessTypeVo();
//        businessTypeVo.setId("1");

        SystemBusinessTypeVo systemBusinessTypeVo = new SystemBusinessTypeVo();
        systemBusinessTypeVo.setId("1");

        DataTemplateVo dataTemplateVo = new DataTemplateVo();
        dataTemplateVo.setId("102082400775503872");

        RuleTitleVo ruleTitleVo = new RuleTitleVo();
        ruleTitleVo.setId("1"); // 后台生成
        ruleTitleVo.setSystemBusinessTypeVo(systemBusinessTypeVo);
        ruleTitleVo.setDataTemplateVo(dataTemplateVo);

        RuleTypeVo ruleTypeVo = new RuleTypeVo();
        ruleTypeVo.setId("1"); // 后台生成

        AccountingShareRuleVo vo = new AccountingShareRuleVo();
        vo.setId("1"); // 后台生成
        vo.setRuleTitleVo(ruleTitleVo);
        vo.setRuleTypeVo(ruleTypeVo);

        System.out.println(gson.toJson(vo));
    }
}
