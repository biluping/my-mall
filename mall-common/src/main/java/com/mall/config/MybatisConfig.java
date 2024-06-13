package com.mall.config;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class MybatisConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        mybatisPlusInterceptor.addInnerInterceptor(new LogicDeleteInterceptor());
        return mybatisPlusInterceptor;
    }

    /**
     * 逻辑删除拦截器
     */
    public static class LogicDeleteInterceptor implements InnerInterceptor {
        @Override
        public void beforePrepare(StatementHandler sh, Connection connection, Integer transactionTimeout) {
            PluginUtils.MPStatementHandler mpSh = PluginUtils.mpStatementHandler(sh);
            MappedStatement ms = mpSh.mappedStatement();
            SqlCommandType sct = ms.getSqlCommandType();
            if (sct == SqlCommandType.UPDATE) {
                PluginUtils.MPBoundSql mpBs = mpSh.mPBoundSql();
                String sql = mpBs.sql();
                mpBs.sql(sql.replace("del_flag=1", "del_flag=id"));
            }
        }
    }
}
