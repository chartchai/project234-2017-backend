package camt.se234.project.config;



import camt.se234.project.utility.LoadDataFromExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * ใช้สำหรับสร้างข้อมูลเบื้องต้น เช่น Theos1CufData, Segment, Scene เพื่อใช้ทดสอบระบบ
 */
@Slf4j
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    LoadDataFromExcel loader;
    @Value("${dataSourceFile}")
    String dataSourceFile;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        loader.loadData(this.getClass().getClassLoader().getResourceAsStream(this.dataSourceFile));
    }
}
