package com.enset.maintenance_backend.web;

import com.enset.maintenance_backend.dtos.BaseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public interface GenericController<DTO extends BaseDTO,ID> {
    @GetMapping("/")
    List<DTO> entities();

    @GetMapping("/{id}")
    DTO getEntity(@PathVariable ID id);

    @PostMapping("/")
    DTO save(@RequestBody DTO entityDTO);

    @PutMapping("/{id}")
    DTO update(@PathVariable ID id, @RequestBody DTO entityDTO);

    @DeleteMapping("/{id}")
    void delete(@PathVariable ID id);
}
