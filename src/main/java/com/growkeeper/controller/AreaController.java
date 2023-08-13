package com.growkeeper.controller;

import com.growkeeper.dto.AreaDto;
import com.growkeeper.exception.AreaNotFoundException;
import com.growkeeper.mapper.AreaMapper;
import com.growkeeper.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/area")
@RequiredArgsConstructor
public class AreaController {
    private final AreaService areaService;
    private final AreaMapper areaMapper;

    @GetMapping()
    public ResponseEntity<List<AreaDto>> getAreas() {
        return ResponseEntity.ok(areaMapper.mapToAreaDtoList(areaService.getAreas()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDto> getArea(@PathVariable("id") int id) throws AreaNotFoundException {
        return ResponseEntity.ok(areaMapper.mapToAreaDto(areaService.getArea(id)));
    }

    @PostMapping()
    public ResponseEntity<Void> createArea() {
        areaService.createArea();
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/{id}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaDto> updateArea(@PathVariable("id") int id, @RequestBody AreaDto areaDto) {
        areaService.updateArea(id, areaMapper.mapToArea(areaDto));
        return ResponseEntity.ok(areaMapper.mapToAreaDto(areaService.getArea(areaDto.getAreaId())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable("id") int id) throws AreaNotFoundException {
        areaService.deleteArea(id);
        return ResponseEntity.ok().build();
    }
}
