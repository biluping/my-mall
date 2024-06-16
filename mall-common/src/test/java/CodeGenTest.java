import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodeGenTest {

    private static final String entity = "Supplier";
    private static final String moduleName = "mall-product";

    @SneakyThrows
    public static void main(String[] args) {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDirectoryForTemplateLoading(new File("mall-common/src/test/resources/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> data = new HashMap<>();
        data.put("entity", entity);
        data.put("entitySmall", entity.toLowerCase());

        renderMapperJava(cfg, data);
        renderMapperXml(cfg, data);
        renderService(cfg, data);
        renderServiceImpl(cfg, data);

    }

    private static void renderMapperJava(Configuration cfg, Map<String, Object> data) throws IOException, TemplateException {
        File file = new File(moduleName + "/src/main/java/com/mall/mapper/" + entity + "Mapper.java");
        if (!file.exists()) {
            Template template = cfg.getTemplate("mapper.ftl");
            template.process(data, new FileWriter(file));
        }
    }

    private static void renderMapperXml(Configuration cfg, Map<String, Object> data) throws IOException, TemplateException {
        File file = new File(moduleName + "/src/main/resources/mapper/" + entity + "Mapper.xml");
        if (!file.exists()) {
            Template template = cfg.getTemplate("mapperxml.ftl");
            template.process(data, new FileWriter(file));
        }
    }

    private static void renderService(Configuration cfg, Map<String, Object> data) throws IOException, TemplateException {
        File file = new File(moduleName + "/src/main/java/com/mall/service/" + entity + "Service.java");
        if (!file.exists()) {
            Template template = cfg.getTemplate("service.ftl");
            template.process(data, new FileWriter(file));
        }
    }

    private static void renderServiceImpl(Configuration cfg, Map<String, Object> data) throws IOException, TemplateException {
        File file = new File(moduleName + "/src/main/java/com/mall/service/impl/" + entity + "ServiceImpl.java");
        if (!file.exists()) {
            Template template = cfg.getTemplate("serviceimpl.ftl");
            template.process(data, new FileWriter(file));
        }
    }
}
