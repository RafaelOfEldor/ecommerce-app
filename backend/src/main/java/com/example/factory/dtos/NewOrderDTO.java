package com.example.factory.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor
public class NewOrderDTO {

    private String orderName;
    private List<Long> itemId;


}
