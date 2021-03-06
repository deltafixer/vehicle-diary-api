package rs.ac.ni.pmf.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.ResourceException;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;
import rs.ac.ni.pmf.web.model.api.VehicleServiceDTO;

@RequestMapping(path = "/vehicle/{vehicleVin}/service")
public interface VehicleServiceRestController {

	// GET
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	List<VehicleServiceDTO> getVehicleServices(
			@PathVariable(name = "vehicleVin", required = true) final String vehicleVin)
			throws ResourceNotFoundException;

	// POST
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	VehicleServiceDTO addVehicleService(@PathVariable(name = "vehicleVin") final String vehicleVin,
			@RequestBody @Valid final VehicleServiceDTO vehicleServiceDto)
			throws ResourceException, BadRequestException;

	// PUT
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	VehicleServiceDTO updateVehicleService(@PathVariable(name = "vehicleVin") final String vehicleVin,
			@RequestBody @Valid final VehicleServiceDTO vehicleServiceDto)
			throws ResourceException, BadRequestException;

	// DELETE
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping()
	void deleteVehicleService(@PathVariable(name = "vehicleVin") final String vehicleVin,
			@RequestBody final Integer vehicleServiceId) throws ResourceNotFoundException, BadRequestException;

}
