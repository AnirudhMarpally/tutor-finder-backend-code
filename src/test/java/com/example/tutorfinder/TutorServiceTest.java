package com.example.tutorfinder;

import com.example.tutorfinder.entity.Tutor;
import com.example.tutorfinder.service.TutorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TutorServiceTest {
    @Autowired private TutorService tutorService;

    @Test
    void searchFiltersByAllCriteria(){
        List<Tutor> results = tutorService.search("Mumbai", "Math", new BigDecimal("600"));
        assertThat(results).hasSize(1);
        Tutor t = results.get(0);
        assertThat(t.getLocation()).containsIgnoringCase("Mumbai");
        assertThat(t.getSubject()).containsIgnoringCase("Math");
        assertThat(t.getFees()).isLessThanOrEqualTo(new BigDecimal("600"));
    }
}
