package kr.ac.jejunu;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
public class LombokTests {
    @Test
    public void equeals(){
        User user1 = User.builder().id(1).name("hulk").password("1234").build();
        User user2 = User.builder().id(1).name("hulk").password("1234").build();
        System.out.println(user1);
        assertThat(user1, is(user2));
    }
}
