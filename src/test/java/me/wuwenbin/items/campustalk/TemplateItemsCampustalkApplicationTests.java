package me.wuwenbin.items.campustalk;

import me.wuwenbin.items.campustalk.http.jxufe.JxufeSetter;
import me.wuwenbin.items.campustalk.http.jxufe.support.JxufeResult;
import me.wuwenbin.items.campustalk.repository.JxufeJobRepository;
import me.wuwenbin.items.campustalk.repository.JxufeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateItemsCampustalkApplicationTests {

    @Autowired
    JxufeRepository jxufeRepository;
    @Autowired
    JxufeJobRepository jxufeJobRepository;

    @Test
    public void contextLoads() {
        JxufeResult jxufe = JxufeSetter.getJxufeResult(1, 15);
        jxufeRepository.save(jxufe.getTalksInJxufe());
        jxufeJobRepository.save(jxufe.getJobsInJxufe());
    }

}
