package top.xxgo.mybatisplus;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Scanner;

/**
 *  mybatisPlus  代码自动生成
 * @author xxg
 */
public class GeneratorCodeConfig {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://127.0.0.1:3306/xxgo_sys?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=true&autoReconnect=true";
        String dbUsername = "root";
        String dbPassword = "123456";
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(dbUrl, dbUsername, dbPassword).build();

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator(dataSourceConfig);

        // 全局配置
        String projectPath = System.getProperty("user.dir");

        GlobalConfig globalConfig = new GlobalConfig.Builder().author("xxgo")
                .openDir(false)
                .outputDir(projectPath+"")
//                .enableSwagger()
                .build();
        mpg.global(globalConfig);
        // 包配置
        PackageConfig pc = new PackageConfig.Builder()
                .parent("com.xxgo")
                .service("service")
                .serviceImpl("service.impl")
                .entity("model.auto")
                .mapper("mapper.auto")
                .moduleName("sys")
                .build();
        mpg.packageInfo(pc);

        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig.Builder().mapperXml(null).build();


        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        mpg.template(templateConfig);

        // 策略配置
        StrategyConfig.Builder builder = new StrategyConfig.Builder();
        builder.addTablePrefix(pc.getModuleName() + "_")
            .addInclude(scanner("表名，多个英文逗号分割").split(","));
        builder.entityBuilder()
                .enableLombok()
//                .superClass("")
                .columnNaming(NamingStrategy.underline_to_camel)
                ;
        builder.controllerBuilder().enableRestStyle()
            .enableHyphenStyle();
         // 公共父类
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");

        mpg.strategy(builder.build());
        mpg.execute(new FreemarkerTemplateEngine());
    }
}