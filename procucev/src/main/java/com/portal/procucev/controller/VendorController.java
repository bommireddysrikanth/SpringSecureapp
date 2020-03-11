package com.portal.procucev.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.procucev.customexception.AppException;
import com.portal.procucev.model.Organization;
import com.portal.procucev.model.VendorCertificate;
import com.portal.procucev.model.VendorClientReference;
import com.portal.procucev.model.VendorDocument;
import com.portal.procucev.service.VendorService;
import com.portal.procucev.utils.ApplicationConstants;

/**
 * This <class> is an entry point of all vendor related operations i.e..
 * Create,fetch,update and delete
 * 
 * @author venu gopal
 *
 */
@RestController
@RequestMapping("/rest/vendor")
public class VendorController {

	static Logger logger = LoggerFactory.getLogger(VendorController.class);

	@Autowired
	VendorService vendorService;

	/**
	 * Method to create a new vendor
	 * 
	 * @param newVendorModel
	 * @param type
	 * @param inputfile
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/newVendorRegistration", consumes = { "multipart/form-data" })
	public ResponseEntity<?> userRegistration(@RequestParam(name = "model", required = false) String newVendorModel,
			@RequestParam(name = "type", required = false) String type,
			@RequestParam(name = "file", required = false) MultipartFile inputfile) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		Organization newVendor = new Organization();
		logger.info("Converting the model input to class type");
		newVendor = mapper.readValue(newVendorModel, Organization.class);

		if (null != inputfile) {

			if (type.equals("Client Certificates")) {
				List<VendorClientReference> clentList = new ArrayList<VendorClientReference>();
				VendorClientReference ref = newVendor.getClientReference().get(0);
				ref.setFileName(inputfile.getOriginalFilename());
				ref.setFile(inputfile.getBytes());
				clentList.add(ref);
				newVendor.setClientReference(clentList);

			}
			if (type.equals("Documents")) {
				List<VendorDocument> clentList = new ArrayList<VendorDocument>();
				VendorDocument ref = newVendor.getDocuments().get(0);
				ref.setFileName(inputfile.getOriginalFilename());
				ref.setFile(inputfile.getBytes());
				clentList.add(ref);
				newVendor.setDocuments(clentList);
			}
			if (type.equals("Vendor Certificates")) {
				List<VendorCertificate> clentList = new ArrayList<VendorCertificate>();
				VendorCertificate ref = newVendor.getCertificates().get(0);
				ref.setFileName(inputfile.getOriginalFilename());
				ref.setFile(inputfile.getBytes());
				clentList.add(ref);
				newVendor.setCertificates(clentList);
			}
		}
		boolean status = vendorService.userRegistration(newVendor);

		String statusCode = status ? String.valueOf(ApplicationConstants.SUCCESS)
				: String.valueOf(ApplicationConstants.FAILURE);
		String msg = status ? String.format(ApplicationConstants.CREATE_VENDOR, "")
				: String.format(ApplicationConstants.VENDOR_EXISTS, "");
		AppException response = new AppException(statusCode, msg, null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * Method to return all the vendors
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/allVendors")
	public ResponseEntity<?> fetchVendors() throws AppException {
		logger.info("enters to fetch the vendor list");
		List<Organization> vendorList = vendorService.fetchAllVendors();
		return new ResponseEntity<>(vendorList, HttpStatus.OK);
	}

	/**
	 * Method to delete the organizations
	 * 
	 * @param organization
	 * @return
	 */
	@PostMapping("/deleteVendors")
	public ResponseEntity<?> deleteVendors(@RequestBody List<Organization> organization) {
		boolean status = vendorService.deleteVendor(organization);

		String statusCode = status ? String.valueOf(ApplicationConstants.SUCCESS)
				: String.valueOf(ApplicationConstants.FAILURE);
		String msg = status ? String.format(ApplicationConstants.DELETE_VENDOR, "")
				: String.format(ApplicationConstants.DELETE_VENDOR_NOT_EXISTS, "");
		AppException response = new AppException(statusCode, msg, null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * Method to fetch the currency master details
	 * 
	 * @return
	 */
	@GetMapping("/currencyMaster")
	public ResponseEntity<?> currencyMasterList() {
		List<String> currencyMasterList = vendorService.currencyMasteList();
		return new ResponseEntity<>(currencyMasterList, HttpStatus.OK);
	}

	/**
	 * Method to fetch the unit details
	 * 
	 * @return
	 */
	@GetMapping("/unitMaster")
	public ResponseEntity<?> unitMasterList() {
		List<String> currencyUnitist = vendorService.currencyUnitList();
		return new ResponseEntity<>(currencyUnitist, HttpStatus.OK);
	}

}
