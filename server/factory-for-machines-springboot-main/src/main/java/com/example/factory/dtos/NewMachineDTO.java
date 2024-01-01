package com.example.factory.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NewMachineDTO {

    private String machineName;
    private Integer itemQuantity;
    private List<Long> subassemblyId;


}
