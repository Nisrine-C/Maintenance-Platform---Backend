package com.enset.maintenance_backend.web;

import com.enset.maintenance_backend.dtos.BaseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public interface GenericController<DTO extends BaseDTO,ID> {
    @GetMapping("/")
    public List<DTO> entities();

    @GetMapping("/{id}")
    public DTO getEntity(@PathVariable ID id);

    @PostMapping("/")
    public DTO save(@RequestBody DTO entityDTO);

    @PutMapping("/{id}")
    public DTO update(@PathVariable ID id, @RequestBody DTO entityDTO);

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id);
}
