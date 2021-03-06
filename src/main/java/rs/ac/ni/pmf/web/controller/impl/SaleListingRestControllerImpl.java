package rs.ac.ni.pmf.web.controller.impl;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.controller.SaleListingRestController;
import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.ResourceException;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;
import rs.ac.ni.pmf.web.model.SaleListingSearchOptions;
import rs.ac.ni.pmf.web.model.api.SaleListingDTO;
import rs.ac.ni.pmf.web.service.SaleListingService;

@RestController
@RequiredArgsConstructor
public class SaleListingRestControllerImpl implements SaleListingRestController {

	private final SaleListingService saleListingService;

	@Override
	public Page<SaleListingDTO> getAllSaleListings(final Float minPrice, final Float maxPrice, final Date fromDate,
			final Date toDate, final Integer page, final Integer pageSize) {
		final SaleListingSearchOptions searchOptions = SaleListingSearchOptions.builder().minPrice(minPrice)
				.maxPrice(maxPrice).fromDate(fromDate).toDate(toDate).page(page).size(pageSize).build();

		return saleListingService.getAllSaleListings(searchOptions);
	}

	@Override
	public SaleListingDTO getSaleListing(final String vehicleVin) throws ResourceNotFoundException {
		return saleListingService.getSaleListing(vehicleVin);
	}

	@Override
	public Double getSaleListingSuggestionScore(final String vehicleVin)
			throws ResourceNotFoundException, NotFoundException {
		Double res = saleListingService.getSaleListingSuggestionScore(vehicleVin);
		System.out.println(res);
		return res;
	}

	@Override
	public SaleListingDTO saveSaleListing(final String vehicleVin, final SaleListingDTO saleListingDto)
			throws ResourceException, BadRequestException {
		return saleListingService.saveSaleListing(vehicleVin, saleListingDto);
	}

	@Override
	public void updateSaleListing(final String vehicleVin, final SaleListingDTO saleListingDto)
			throws ResourceException, BadRequestException {
		saleListingService.updateSaleListing(vehicleVin, saleListingDto);
	}

	@Override
	public void deleteSaleListing(final String vehicleVin) throws ResourceNotFoundException {
		saleListingService.deleteSaleListing(vehicleVin);
	}

}
