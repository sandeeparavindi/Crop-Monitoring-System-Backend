package org.example.cropmonitoringsystembackend.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.customObj.FieldErrorResponse;
import org.example.cropmonitoringsystembackend.dto.impl.FieldDTO;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.service.FieldService;
import org.example.cropmonitoringsystembackend.util.AppUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "api/v1")
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;

    @PostMapping(value = "/fields", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveField(
            @RequestParam("fieldCode") String fieldCode,
            @RequestParam("fieldName") String fieldName,
            @RequestParam("fieldLocation") String fieldLocation,
            @RequestParam("extentSize") Double extentSize,
            @RequestParam("fieldImage1") MultipartFile fieldImage1,
            @RequestParam("fieldImage2") MultipartFile fieldImage2,
            HttpServletRequest request

    ) {
        System.out.println("Content-Type: " + request.getContentType());
        request.getHeaderNames().asIterator().forEachRemaining(header ->
                System.out.println(header + ": " + request.getHeader(header)));

        try {
            System.out.println("FieldCode: " + fieldCode);
            System.out.println("FieldName: " + fieldName);
            System.out.println("FieldLocation: " + fieldLocation);
            System.out.println("ExtentSize: " + extentSize);
            System.out.println("FieldImage1: " + fieldImage1.getOriginalFilename());
            System.out.println("FieldImage2: " + fieldImage2.getOriginalFilename());

            byte[] byteFieldImage1 = fieldImage1.getBytes();
            String base64Image1 = AppUtil.toBase64(byteFieldImage1);

            byte[] byteFieldImage2 = fieldImage2.getBytes();
            String base64Image2 = AppUtil.toBase64(byteFieldImage2);

            FieldDTO fieldDTO = new FieldDTO();
            fieldDTO.setFieldCode(fieldCode);
            fieldDTO.setFieldName(fieldName);
            fieldDTO.setFieldLocation(fieldLocation);
            fieldDTO.setExtentSize(extentSize);
            fieldDTO.setFieldImage1(base64Image1);
            fieldDTO.setFieldImage2(base64Image2);

            fieldService.saveField(fieldDTO);

            return new ResponseEntity<>(new FieldErrorResponse("success",
                    "Field saved successfully"), HttpStatus.CREATED);

        } catch (DataPersistException e) {
            return new ResponseEntity<>(new FieldErrorResponse("error",
                    "Failed to save field: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FieldErrorResponse("error",
                    "Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}