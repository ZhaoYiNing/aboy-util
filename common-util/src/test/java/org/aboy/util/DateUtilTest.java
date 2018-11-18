package org.aboy.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import org.junit.Test;

/**
 * @Title: DateUtilTest
 * @Description: TODO
 * @author: zhaoyining1113@126.com
 * @date 2018/11/18 16:01
 * @since JDK 1.8
 */
public class DateUtilTest {

  @Test
  public void tryTest(){
    LocalDateTime dateTime = LocalDate.now().atTime(23,59,59);
    System.out.println(dateTime.toString());
  }
}
