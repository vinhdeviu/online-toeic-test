package online_toeic_test_springboot.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Test {
    private Integer id;
    private String testName;
    private String audioLink;
    private Map<Integer, Part> parts;
    private List<Character> examineeSelectedOptions;
}
