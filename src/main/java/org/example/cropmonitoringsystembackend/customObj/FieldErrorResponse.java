package org.example.cropmonitoringsystembackend.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldErrorResponse implements FieldResponse{
    private String status;
    private String message;
}
