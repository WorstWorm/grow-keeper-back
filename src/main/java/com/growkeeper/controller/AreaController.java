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

    @GetMapping("/{areaId}")
    public ResponseEntity<AreaDto> getArea(@PathVariable("areaId") int areaId) throws AreaNotFoundException {
        return ResponseEntity.ok(areaMapper.mapToAreaDto(areaService.getArea(areaId)));
    }

    @PostMapping()
    public ResponseEntity<Void> createEmptyArea() {
        areaService.createArea();
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/{areaId}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaDto> updateArea(@PathVariable("areaId") int areaId, @RequestBody AreaDto areaDto) {
        areaService.updateArea(areaId, areaMapper.mapToArea(areaDto));
        return ResponseEntity.ok(areaMapper.mapToAreaDto(areaService.getArea(areaDto.getAreaId())));
    }

    @DeleteMapping("/{areaId}")
    public ResponseEntity<Void> deleteArea(@PathVariable("areaId") int areaId) throws AreaNotFoundException {
        areaService.deleteArea(areaId);
        return ResponseEntity.ok().build();
    }
}
