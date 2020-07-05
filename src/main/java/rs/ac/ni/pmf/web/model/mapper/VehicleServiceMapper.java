package rs.ac.ni.pmf.web.model.mapper;

import org.springframework.stereotype.Component;

import rs.ac.ni.pmf.web.model.api.VehicleServiceDTO;
import rs.ac.ni.pmf.web.model.entity.VehicleServiceEntity;

@Component
public class VehicleServiceMapper {

	public VehicleServiceDTO toDto(final VehicleServiceEntity vehicleServiceEntity) {
		return VehicleServiceDTO.builder().dateTaken(vehicleServiceEntity.getDateTaken()).build();
	}

	public VehicleServiceEntity toEntity(final VehicleServiceDTO vehicleServiceDto) {
		return VehicleServiceEntity.builder().dateTaken(vehicleServiceDto.getDateTaken()).build();
	}

}