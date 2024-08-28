package Thymeleaf.SpringThymeleaf.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Singer {

    private String name;
    private String age;
    private List<Album>  alubums;
}
