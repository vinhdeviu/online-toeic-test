package online_toeic_test_springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Part {
    private int id;
    private int type;
    private String tittle;
    private String direction;
}
