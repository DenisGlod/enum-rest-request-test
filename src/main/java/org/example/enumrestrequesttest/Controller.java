package org.example.enumrestrequesttest;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.example.enumrestrequesttest.valid.NonNullEnumArray;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Slf4j
@Validated
public class Controller {

    @GetMapping
    public void test(@RequestParam(required = false)
                     @Size(min = 5, max = 15, message = "{size.userForm.username}") String text,

                     @RequestParam(required = false, defaultValue = "A")
                     @NonNullEnumArray(enumClass = MyEnum.class) MyEnum... myenum) {
        //                    if (myEnum == null) throw new ConstraintViolationException("myEnum is null", null);
        String[] array = Arrays.stream(myenum)
                .map(MyEnum::getValue)
                .toArray(String[]::new);
        log.info(Arrays.toString(array));
    }
}
