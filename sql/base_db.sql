SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(36) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE=InnoDB;

-- admin
INSERT INTO `sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL);


DROP TABLE IF EXISTS `map_structure`;
CREATE TABLE `map_structure`  (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `templateId` varchar(36) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `map_value`;
CREATE TABLE `map_value`  (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `structure_id` varchar(36) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `system_constant`;
CREATE TABLE `system_constant`  (
  `systemName` varchar(100) NOT NULL,
  `systemValue` varchar(512) NOT NULL,
  PRIMARY KEY (`systemName`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module`  (
  `id` varchar(36) NOT NULL,
  `code` varchar(100) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `template_module`;
CREATE TABLE `template_module`  (
  `id` varchar(36) NOT NULL,
  `code` varchar(100) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `data_template`;
CREATE TABLE `data_template`  (
  `id` varchar(36) NOT NULL,
  `sysCode` varchar(100) DEFAULT NULL,
  `sysName` varchar(100) DEFAULT NULL,
  `islock` varchar(100) DEFAULT NULL,
  `autoComputer` varchar(100) DEFAULT NULL,
  `templateCode` varchar(100) DEFAULT NULL,
  `templateName` varchar(100) DEFAULT NULL,
  `allowDuplicateImport` varchar(100) DEFAULT NULL,
  `autoCreditImport` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `data_template_item`;
CREATE TABLE `data_template_item`  (
  `id` varchar(36) NOT NULL,
  `fieldName` varchar(100) DEFAULT NULL,
  `fieldTitle` varchar(100) DEFAULT NULL,
  `rowNo` varchar(100) DEFAULT NULL,
  `mapField` varchar(100) DEFAULT NULL,
  `fieldType` varchar(100) DEFAULT NULL,
  `fieldLength` varchar(100) DEFAULT NULL,
  `isEnable` varchar(100) DEFAULT NULL,
  `isMandatory` varchar(100) DEFAULT NULL,
  `isUnique` varchar(100) DEFAULT NULL,
  `isCompany` varchar(100) DEFAULT NULL,
  `isAssistAccount` varchar(100) DEFAULT NULL,
  `maskFormat` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `templateId` varchar(36) DEFAULT NULL,
  `isPartner` varchar(36) DEFAULT NULL,
  `isProduct` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;


DROP TABLE IF EXISTS `engine_setting`;
CREATE TABLE `engine_setting`  (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `enableDate` date DEFAULT NULL,
  `invalidDate` date DEFAULT NULL,
  `sysCode` varchar(100) DEFAULT NULL,
  `sysName` varchar(100) DEFAULT NULL,
  `templateCode` varchar(100) DEFAULT NULL,
  `templateName` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `engine_setting_item`;
CREATE TABLE `engine_setting_item`  (
  `id` varchar(36) NOT NULL,
  `subjectId` varchar(100) DEFAULT NULL,
  `loan` varchar(100) DEFAULT NULL,
  `groupName` varchar(100) DEFAULT NULL,
  `collectName` varchar(100) DEFAULT NULL,
  `conditionId` varchar(100) DEFAULT NULL,
  `calculationId` varchar(100) DEFAULT NULL,
  `summaryId` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `enabled` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `engineId` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

-- ----------------------------
-- Table structure for t_subject
-- select id, code, name, description, sys_code, sys_name, template_code, template_name, create_date, update_date from subject
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `code` varchar(100) DEFAULT NULL COMMENT '科目规则代码',
  `name` varchar(100) DEFAULT NULL COMMENT '科目规则名称',
  `enabled` varchar(10) DEFAULT NULL COMMENT '是否启用',
  `sys_code` varchar(100) DEFAULT NULL COMMENT '业务系统代码',
  `sys_name` varchar(100) DEFAULT NULL COMMENT '业务系统名称',
  `template_code` varchar(100) DEFAULT NULL COMMENT '模板代码',
  `template_name` varchar(100) DEFAULT NULL COMMENT '模板名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

-- ----------------------------
-- Table structure for subject_item
-- select id, subject_id, subject_segment, source_type, constant_value, source_value, mapping_structure_id, mapping_structure_name, mapping_value, create_date, update_date from subject_item
-- ----------------------------
DROP TABLE IF EXISTS `subject_item`;
CREATE TABLE `subject_item`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `subject_id` varchar(100) DEFAULT NULL COMMENT '所属科目id',
  `subject_segment` varchar(100) DEFAULT NULL COMMENT '科目段',
  `source_type` varchar(100) DEFAULT NULL COMMENT '来源类型',
  `constant_value` varchar(100) DEFAULT NULL COMMENT '常数',
  `source_value` varchar(100) DEFAULT NULL COMMENT '来源值字段',
  `mapping_structure_id` varchar(36) DEFAULT NULL COMMENT '映射结构id',
  `mapping_structure_name` varchar(100) DEFAULT NULL COMMENT '映射结构名称',
  `mapping_value` varchar(100) DEFAULT NULL COMMENT '映射值字段',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

-- ----------------------------
-- Table structure for condition_rule
-- select id, code, name, description, sys_code, sys_name, template_code, template_name, create_date, update_date from condition_rule
-- ----------------------------
DROP TABLE IF EXISTS `condition_rule`;
CREATE TABLE `condition_rule`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `code` varchar(100) DEFAULT NULL COMMENT '条件规则代码',
  `name` varchar(100) DEFAULT NULL COMMENT '条件规则名称',
  `enabled` varchar(10) DEFAULT NULL COMMENT '是否启用',
  `sys_code` varchar(100) DEFAULT NULL COMMENT '业务系统代码',
  `sys_name` varchar(100) DEFAULT NULL COMMENT '业务系统名称',
  `template_code` varchar(100) DEFAULT NULL COMMENT '模板代码',
  `template_name` varchar(100) DEFAULT NULL COMMENT '模板名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

-- ----------------------------
-- Table structure for condition_rule_item
-- select id, condition_id, sequence, left_brackets, right_brackets, source_column, judgment, compare_value, calculation_id, and_or, create_date, update_date from condition_rule_item
-- ----------------------------
DROP TABLE IF EXISTS `condition_rule_item`;
CREATE TABLE `condition_rule_item`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `condition_id` varchar(36) DEFAULT NULL COMMENT '所属条件规则id',
  `sequence` varchar(100) DEFAULT NULL COMMENT '条件规则组装顺序',
  `left_brackets` varchar(100) DEFAULT NULL COMMENT '左括号组合',
  `right_brackets` varchar(100) DEFAULT NULL COMMENT '右括号组合',
  `source_column` varchar(100) DEFAULT NULL COMMENT '源数据列',
  `judgment` varchar(100) DEFAULT NULL COMMENT '判断符',
  `compare_value` varchar(100) DEFAULT NULL COMMENT '比较值',
  `calculation_id` varchar(36) DEFAULT NULL COMMENT '金额计算规则id',
  `and_or` varchar(100) DEFAULT NULL COMMENT '与/或',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

-- ----------------------------
-- Table structure for amount_calculation
-- select code, name, id, description, sys_code, sys_name, template_code, template_name, create_date, update_date from amount_calculation
-- ----------------------------
DROP TABLE IF EXISTS `amount_calculation`;
CREATE TABLE `amount_calculation`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `code` varchar(100) DEFAULT NULL COMMENT '金额计算规则代码',
  `name` varchar(100) DEFAULT NULL COMMENT '金额计算规则名称',
  `enabled` varchar(10) DEFAULT NULL COMMENT '是否启用',
  `sys_code` varchar(100) DEFAULT NULL COMMENT '业务系统代码',
  `sys_name` varchar(100) DEFAULT NULL COMMENT '业务系统名称',
  `template_code` varchar(100) DEFAULT NULL COMMENT '模板代码',
  `template_name` varchar(100) DEFAULT NULL COMMENT '模板名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

-- ----------------------------
-- Table structure for amount_calculation_item
-- select id, amount_calculation_id, operator, constant_value, source_column_upper, source_column_lower, create_date, update_date from amount_calculation_item
-- ----------------------------
DROP TABLE IF EXISTS `amount_calculation_item`;
CREATE TABLE `amount_calculation_item`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `amount_calculation_id` varchar(36) DEFAULT NULL COMMENT '所属金额计算规则id',
  `operator` varchar(100) DEFAULT NULL COMMENT '运算符',
  `constant_value` varchar(100) DEFAULT NULL COMMENT '比较值',
  `source_column_upper` varchar(100) DEFAULT NULL COMMENT '源数据列上限',
  `source_column_lower` varchar(100) DEFAULT NULL COMMENT '源数据列下限',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

-- ----------------------------
-- Table structure for t_summary
-- select id, code, name, description, sys_code, sys_name, template_code, template_name, create_date, update_date from summary
-- ----------------------------
DROP TABLE IF EXISTS `t_summary`;
CREATE TABLE `t_summary`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `code` varchar(100) DEFAULT NULL COMMENT '摘要规则代码',
  `name` varchar(100) DEFAULT NULL COMMENT '摘要规则名称',
  `enabled` varchar(10) DEFAULT NULL COMMENT '是否启用',
  `sys_code` varchar(100) DEFAULT NULL COMMENT '业务系统代码',
  `sys_name` varchar(100) DEFAULT NULL COMMENT '业务系统名称',
  `template_code` varchar(100) DEFAULT NULL COMMENT '模板代码',
  `template_name` varchar(100) DEFAULT NULL COMMENT '模板名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

-- ----------------------------
-- Table structure for summary_item
-- select id, summary_id, splice, source_type, constant_value, source_value, mapping_structure_id, mapping_structure_name, mapping_value, create_date, update_date from summary_item
-- ----------------------------
DROP TABLE IF EXISTS `summary_item`;
CREATE TABLE `summary_item`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `summary_id` varchar(36) DEFAULT NULL COMMENT '所属摘要规则id',
  `splice` varchar(100) DEFAULT NULL COMMENT '拼接符',
  `source_type` varchar(100) DEFAULT NULL COMMENT '来源类型',
  `constant_value` varchar(100) DEFAULT NULL COMMENT '常数',
  `source_value` varchar(100) DEFAULT NULL COMMENT '来源值字段',
  `mapping_structure_id` varchar(100) DEFAULT NULL COMMENT '映射结构id',
  `mapping_structure_name` varchar(100) DEFAULT NULL COMMENT '映射结构名称',
  `mapping_value` varchar(100) DEFAULT NULL COMMENT '映射值字段',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

-- ----------------------------
-- Table structure for data_manage
-- select id, sys_code, sys_name, import_date, sys_type, import_batch, split_batch_name, company, status, amount, certificate_code, create_date, update_date from data_manage
-- ----------------------------
DROP TABLE IF EXISTS `data_manage`;
CREATE TABLE `data_manage`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `sys_code` varchar(100) DEFAULT NULL COMMENT '业务系统代码',
  `sys_name` varchar(100) DEFAULT NULL COMMENT '业务系统名称',
  `import_date` datetime DEFAULT NULL COMMENT '导入日期',
  `sys_type` varchar(100) DEFAULT NULL COMMENT '业务类型',
  `import_batch` varchar(100) DEFAULT NULL COMMENT '导入批次',
  `split_batch_name` varchar(100) DEFAULT NULL COMMENT '拆分批次名称',
  `company` varchar(100) DEFAULT NULL COMMENT '所属公司',
  `status` varchar(100) DEFAULT NULL COMMENT '状态',
  `amount` varchar(100) DEFAULT NULL COMMENT '数量',
  `certificate_code` varchar(100) DEFAULT NULL COMMENT '凭证编号',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `data_manage_item`;
CREATE TABLE `data_manage_item`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `bill_date` varchar(100) DEFAULT NULL COMMENT '记账日期',
  `account_code` varchar(100) DEFAULT NULL COMMENT '科目代码',
  `account_name` varchar(100) DEFAULT NULL COMMENT '科目名称',
  `debit_num` varchar(100) DEFAULT NULL COMMENT '借方金额',
  `credit_num` varchar(100) DEFAULT NULL COMMENT '贷方金额',
  `summary_name` varchar(100) DEFAULT NULL COMMENT '摘要',
  `client_code` varchar(100) DEFAULT NULL COMMENT '客户',
  `supply_code` varchar(100) DEFAULT NULL COMMENT '供应商',
  `error_log` varchar(100) DEFAULT NULL COMMENT '错误日志',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  `data_manage_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `partner_group`;
CREATE TABLE `partner_group`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `partner_group_name` varchar(100) DEFAULT NULL COMMENT '合伙人组名称',
  `description` varchar(36) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `partner_group_item`;
CREATE TABLE `partner_group_item`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `partner_name` varchar(100) DEFAULT NULL COMMENT '合伙人名称',
  `partner_number` varchar(36) DEFAULT NULL COMMENT '合伙人编号',
	`partner_group_id` varchar(50) DEFAULT NULL COMMENT '合伙人组id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `product_group`;
CREATE TABLE `product_group`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `product_group_name` varchar(100) DEFAULT NULL COMMENT '产品组名称',
  `description` varchar(36) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `product_group_item`;
CREATE TABLE `product_group_item`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `product_name` varchar(100) DEFAULT NULL  COMMENT '产品名称',
  `product_number` varchar(36) DEFAULT NULL COMMENT '产品编号',
	`product_group_id` varchar(50) DEFAULT NULL COMMENT '产品组id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `reconciliation_rule`;
CREATE TABLE `reconciliation_rule`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `rule_code` varchar(100) DEFAULT NULL COMMENT '对账规则代码',
  `description` varchar(36) DEFAULT NULL COMMENT '对账规则描述',
  `sys_code` varchar(100) DEFAULT NULL COMMENT '业务系统代码',
  `sys_name` varchar(100) DEFAULT NULL COMMENT '业务系统名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  `template_code` varchar(100) DEFAULT NULL COMMENT '模板代码',
  `template_name` varchar(100) DEFAULT NULL COMMENT '模板名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `reconciliation_rule_item`;
CREATE TABLE `reconciliation_rule_item`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `field_name` varchar(100) DEFAULT NULL  COMMENT '字段名称',
  `field_title` varchar(36) DEFAULT NULL COMMENT '字段描述',
	`filed_type` varchar(50) DEFAULT NULL COMMENT '字符类型',
	`reconciliation_rule_id` varchar(36) NOT NULL COMMENT '对账规则id',
	`additional_formula_id` varchar(36) NOT NULL COMMENT '附加公式id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;


##  dupei wu


DROP TABLE IF EXISTS `source_system`; ##来源系统
CREATE TABLE `source_system`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `source_system_code` varchar(100) NOT NULL  COMMENT '来源系统代码',
  `source_system_name` varchar(100) NOT NULL COMMENT '来源系统名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `business_type`; ##业务类型
CREATE TABLE `business_type`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `business_type_code` varchar(100) NOT NULL  COMMENT '业务类型代码',
  `business_type_name` varchar(100) NOT NULL COMMENT '业务类型名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `system_business_type`; ##来源系统业务类型
CREATE TABLE `system_business_type`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `source_system_id` varchar(36) NOT NULL  COMMENT '来源系统外键',
  `business_type_id` varchar(36) NOT NULL COMMENT '业务类型外键',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `rule_title`; ##规则标题
CREATE TABLE `rule_title`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `system_business_type_id` varchar(36) DEFAULT NULL  COMMENT '来源系统业务类型外键',
  `data_template_id` varchar(36) DEFAULT NULL COMMENT '模版外键',
  `begin_date` datetime DEFAULT NULL COMMENT '启用日期',
  `end_date` datetime DEFAULT NULL COMMENT '失效日期',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `rule_type`; ##规则类型
CREATE TABLE `rule_type`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `rule_type_name` varchar(100) DEFAULT NULL  COMMENT '规则类型名称',
  `rule_type_desc` varchar(256) DEFAULT NULL COMMENT '规则类型说明',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `revenue_share_rule`; ##收入共享规则
CREATE TABLE `revenue_share_rule`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `rule_title_id` varchar(36) DEFAULT NULL  COMMENT '规则标题外键',
  `rule_type_id` varchar(36) DEFAULT NULL COMMENT '规则类型外键',
  `condition_rule_id` varchar(36) DEFAULT NULL  COMMENT '条件规则外键',
  `amount_calculation_id` varchar(36) DEFAULT NULL COMMENT '金额规则外键',
  `partner_group_id` varchar(36) DEFAULT NULL COMMENT '合伙人组外键',
  `product_group_id` varchar(36) DEFAULT NULL COMMENT '产品组外键',
  `settlement_period` enum('MONTH','QUARTER','YEAR') NOT NULL DEFAULT 'MONTH' COMMENT '结算周期',
  `auto_clear` enum('0','1') NOT NULL DEFAULT '1' COMMENT '自动结算',
  `auto_offset` enum('0','1') NOT NULL DEFAULT '1' COMMENT '自动冲销',
  `remark` varchar(256) NOT NULL COMMENT '备注',
  `begin_date` datetime DEFAULT NULL COMMENT '启用日期',
  `end_date` datetime DEFAULT NULL COMMENT '失效日期',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `revenue_share_data`; ##收入共享数据
CREATE TABLE `revenue_share_data`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `revenue_share_rule_id` varchar(36) DEFAULT NULL  COMMENT '收入共享规则外键',
  `partner_group_id` varchar(36) DEFAULT NULL COMMENT '合伙人组外键',
  `product_group_id` varchar(36) DEFAULT NULL COMMENT '产品组外键',
  `partner_group_item_id` varchar(36) DEFAULT NULL COMMENT '合伙人外键',
  `product_group_item_id` varchar(36) DEFAULT NULL COMMENT '产品外键',
  `trace_id` varchar(100) NOT NULL COMMENT '交易ID',
  `trace_amount` decimal(18,2) NOT NULL COMMENT '交易金额',
  `pay_type` varchar(100) NOT NULL COMMENT '支付方式',
  `batch_id` varchar(100) NOT NULL COMMENT '导入批次',
  `import_date` datetime DEFAULT NULL COMMENT '导入日期',
  `trace_date` datetime DEFAULT NULL COMMENT '交易日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `revenue_share_settlement`; ##收入共享结算
CREATE TABLE `revenue_share_settlement`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `revenue_share_data_id` varchar(36) DEFAULT NULL  COMMENT '收入共享数据外键',
  `settlement_amount` decimal(18,2) NOT NULL COMMENT '结算金额',
  `settlement_date` datetime DEFAULT NULL COMMENT '结算日期',
  `status` enum('ESTIMATE','CONFIRM_ESTIMATE','CONFIRM_SETTLEMENT','REVERSE') NOT NULL DEFAULT 'ESTIMATE' COMMENT '状态',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `accounting_share_rule`; ##会计分摊规则
CREATE TABLE `accounting_share_rule`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `rule_title_id` varchar(36) DEFAULT NULL  COMMENT '规则标题外键',
  `rule_type_id` varchar(36) DEFAULT NULL COMMENT '规则类型外键',
  `share_type` enum('FREQ','PERIOD') NOT NULL DEFAULT 'PERIOD' COMMENT '分摊类型',
  `begin_date` datetime DEFAULT NULL COMMENT '开始日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `date_freq` int DEFAULT NULL COMMENT '第几日',
  `freq_type` enum('WEEK','MONTH','YEAR') DEFAULT NULL COMMENT '频率类型',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `revenue_sale_data`; ##收入销售数据
CREATE TABLE `revenue_sale_data`  (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `system_business_type_id` varchar(36) DEFAULT NULL  COMMENT '来源系统业务类型外键',
  `status` enum('CONFIRM','PART_CONFIRM','UNCONFIRM') NOT NULL DEFAULT 'UNCONFIRM' COMMENT '状态',
  `product_group_id` varchar(36) DEFAULT NULL COMMENT '产品组外键',
  `product_group_item_id` varchar(36) DEFAULT NULL COMMENT '产品外键',
  `trace_id` varchar(100) NOT NULL COMMENT '交易ID',
  `trace_amount` decimal(18,2) NOT NULL COMMENT '交易金额',
  `calculated_amount` decimal(18,2) NOT NULL COMMENT '已计入收入',
  `calculat_amount` decimal(18,2) NOT NULL COMMENT '未计入收入',
  `shared_count` int NOT NULL COMMENT '已分摊次数',
  `share_count` int NOT NULL COMMENT '未分摊次数',
  `pay_type` varchar(100) NOT NULL COMMENT '支付方式',
  `business_department` varchar(100) NOT NULL COMMENT '业务部门',
  `profit_center` datetime DEFAULT NULL COMMENT '利润中心',
  `trace_begin_date` datetime DEFAULT NULL COMMENT '交易开始日期',
  `trace_end_date` datetime DEFAULT NULL COMMENT '交易结束日期',
  `tally_begin_date` datetime DEFAULT NULL COMMENT '记账开始日期',
  `tally_end_date` datetime DEFAULT NULL COMMENT '记账结束日期',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;





