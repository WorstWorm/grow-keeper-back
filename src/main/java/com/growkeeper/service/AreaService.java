package com.growkeeper.service;

import com.growkeeper.domain.Area;
import com.growkeeper.exception.AreaNotFoundException;
import com.growkeeper.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;

    public Area getArea(Integer areaId) {
        return areaRepository.findById(areaId).orElseThrow(AreaNotFoundException::new);
    }

    public List<Area> getAreas() {
        return areaRepository.findAll();
    }

    public void createArea(Area area) {
        areaRepository.save(area);
    }

    public void updateArea(Integer areaId, Area area)  {
        if(areaRepository.findById(areaId).isPresent()) {
            Area areaModificated = areaRepository.findById(areaId).get();
            areaModificated.setAreaMoisture(area.getAreaMoisture());
            areaModificated.setAreaInsolation(area.getAreaInsolation());
            areaModificated.setAreaLength(area.getAreaLength());
            areaModificated.setAreaWidth(area.getAreaWidth());
            areaModificated.setAreaDepth(area.getAreaDepth());
            areaModificated.setAreaScientificName(area.getAreaScientificName());
            areaRepository.save(areaModificated);
        } else {
            throw new AreaNotFoundException();
        }
    }

    public void deleteArea(Integer areaId)  {
        if(areaRepository.findById(areaId).isPresent()) {
            areaRepository.deleteById(areaId);
        } else {
            throw new AreaNotFoundException();
        }
    }
}
