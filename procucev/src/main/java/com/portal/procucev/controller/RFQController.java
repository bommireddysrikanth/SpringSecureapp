package com.portal.procucev.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.procucev.customexception.AppException;
import com.portal.procucev.model.Query;
import com.portal.procucev.model.Quotation;
import com.portal.procucev.model.RFQDocument;
import com.portal.procucev.model.Rfq;
import com.portal.procucev.model.RfqItem;
import com.portal.procucev.service.RFQService;
import com.portal.procucev.utils.ApplicationConstants;

/**
 * This <class> is an entry point of all RFQ related operations by an id i.e..
 * Create,fetch,update and delete
 * 
 * @author venu gopal
 *
 */
@RestController
@RequestMapping("/rest/rfq")
public class RFQController {
	@Autowired
	RFQService rfqService;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	static Logger logger = LoggerFactory.getLogger(RFQController.class);

	/**
	 * Method to create an RFQ
	 * 
	 * @param rfqRequest
	 * @param type
	 * @param inputfile
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/createRfq", consumes = { "multipart/form-data" })
	public ResponseEntity<?> createRfq(@RequestParam("model") String rfqRequest,
			@RequestParam(name = "type", required = false) String type,
			@RequestParam(name = "file", required = false) MultipartFile inputfile) throws Exception {
		logger.info("entered to create an rfq with a given request");
		ObjectMapper mapper = new ObjectMapper();
		Rfq inputRfqRequest = new Rfq();
		inputRfqRequest = mapper.readValue(rfqRequest, Rfq.class);

		if (null != inputfile) {
			logger.info("entered into documents section");
			if (type.equals("Documents")) {
				List<RFQDocument> rfqDocList = new ArrayList<RFQDocument>();
				RFQDocument rfqDoc = inputRfqRequest.getRfqDocument().get(0); // new RFQDocument();
				rfqDoc.setFileName(inputfile.getOriginalFilename());
				rfqDoc.setFile(inputfile.getBytes());
				rfqDocList.add(rfqDoc);
				inputRfqRequest.setRfqDocument(rfqDocList);
			}
		}

		boolean status = rfqService.rfqCreation(inputRfqRequest);
		String statusCode = status ? String.valueOf(ApplicationConstants.SUCCESS)
				: String.valueOf(ApplicationConstants.FAILURE);
		String msg = status ? String.format(ApplicationConstants.CREATE_RFQ, "")
				: String.format(ApplicationConstants.RFQ_EXISTS, "");
		AppException response = new AppException(statusCode, msg, null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Method to fetch an RFQ by an ID
	 * 
	 * @param rfq
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/fetchRfqById")
	public ResponseEntity<?> fetchRfqById(@RequestBody Rfq rfq) {
		List<Rfq> status = rfqService.fetchRfqById(rfq);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	/**
	 * Method to search a RFQ based on ID or NAME or TIME
	 * 
	 * @param id
	 * @param name
	 * @param time
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/rfqSearch")
	public ResponseEntity<?> createRfq(@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "time", required = false) String time) {
		List<Predicate> predicates = new ArrayList<>();
		EntityManager em = entityManagerFactory.createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Rfq> criteriaQuery = builder.createQuery(Rfq.class);
		Root<Rfq> root = criteriaQuery.from(Rfq.class);
		Join<Rfq, List<RfqItem>> resource = root.join("rfqItem");

		predicates.add(builder.equal(resource.get("brand"), time));

		predicates.add(builder.equal(root.get("rfqId"), id));

		// query itself
		criteriaQuery.select(root).where(predicates.toArray(new Predicate[] {}));
		// execute query and do something with result
		List<Rfq> resultList = em.createQuery(criteriaQuery).getResultList();
		if (!CollectionUtils.isEmpty(resultList)) {
			return new ResponseEntity<>(resultList, HttpStatus.OK);
		} else {
			throw new AppException(HttpStatus.OK.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}

	}

	/**
	 * Method to return all the RFQ's
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/fetchRfq")
	public ResponseEntity<?> fetchRfq() {
		List<Rfq> status = rfqService.fetchRfq();
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	/**
	 * Method to delete an RFQ
	 * 
	 * @return
	 */
	@GetMapping("/deleteRfq")
	public ResponseEntity<?> deleteRfq(@RequestBody List<Rfq> rfq) {
		boolean status = rfqService.deleteRfq(rfq);
		String statusCode = status ? String.valueOf(ApplicationConstants.SUCCESS)
				: String.valueOf(ApplicationConstants.FAILURE);
		String msg = status ? String.format(ApplicationConstants.DELETE_RFQ, "")
				: String.format(ApplicationConstants.RFQ_NOT_EXISTS, "");
		AppException response = new AppException(statusCode, msg, null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Method to return all the Quote history
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/quoteHistory")
	public ResponseEntity<?> quoteHistory() {
		List<Quotation> status = rfqService.fetchQuotes();
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	/**
	 * Method to upload a quote in RFQ by id screen
	 * 
	 * @param rfqRequest
	 * @param inputfile
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/uploadQuote", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadQuote(@RequestParam(name = "model", required = false) String rfqRequest,
			@RequestParam(name = "file", required = false) MultipartFile inputfile) throws Exception {
		Rfq inputRfqRequest = new Rfq();
		if (StringUtils.isEmpty(rfqRequest)) {
			ObjectMapper mapper = new ObjectMapper();
			inputRfqRequest = mapper.readValue(rfqRequest, Rfq.class);
		}
		if (null != inputfile) {
			List<Quotation> quotationList = inputRfqRequest.getRfqQuotation();
			for (Quotation quotation : quotationList) {
				quotation.setFileName(inputfile.getOriginalFilename());
				quotation.setFile(inputfile.getBytes());
			}

		}
		boolean status = rfqService.uploadQuote(inputRfqRequest);
		String statusCode = status ? String.valueOf(ApplicationConstants.SUCCESS)
				: String.valueOf(ApplicationConstants.FAILURE);
		String msg = status ? String.format(ApplicationConstants.CREATE_RFQ, "")
				: String.format(ApplicationConstants.RFQ_EXISTS, "");
		AppException response = new AppException(statusCode, msg, null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Method to Create a query in RFQ by an id screen
	 * 
	 * @param raiseQuery
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/raiseQuery")
	public ResponseEntity<?> raiseQuery(@RequestParam(name = "raiseQuery", required = false) String raiseQuery) {
		if (!StringUtils.isEmpty(raiseQuery)) {
			Rfq inputRfqRequest = new Rfq();
			List<Query> querList = new ArrayList<Query>();
			Query query = new Query();
			query.setRaiseQuery(raiseQuery);
			querList.add(query);
			inputRfqRequest.setRfqQuery(querList);
			boolean status = rfqService.raiseQuery(inputRfqRequest);
			String statusCode = status ? String.valueOf(ApplicationConstants.SUCCESS)
					: String.valueOf(ApplicationConstants.FAILURE);
			String msg = status ? String.format(ApplicationConstants.CREATE_RFQ, "")
					: String.format(ApplicationConstants.RFQ_EXISTS, "");
			AppException response = new AppException(statusCode, msg, null, null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			throw new AppException(HttpStatus.OK.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
	}

	/**
	 * Method to read an xl
	 * 
	 * @param file
	 * @return
	 */
	@GetMapping(value = "/xlData", consumes = "multipart/form-data")
	public ResponseEntity<?> getxlData(@RequestParam MultipartFile file) {
		rfqService.xlRead(file);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
