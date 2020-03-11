package com.portal.procucev.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.portal.procucev.customexception.AppException;
import com.portal.procucev.dao.QuotationsDao;
import com.portal.procucev.dao.RFQDao;
import com.portal.procucev.model.Quotation;
import com.portal.procucev.model.Rfq;
import com.portal.procucev.service.RFQService;
import com.portal.procucev.utils.ApplicationConstants;

/**
 * 
 * @author venu gopal
 *
 */
@Service
public class RFQServiceImpl implements RFQService {
	@Autowired
	RFQDao rfqDao;

	@Autowired
	QuotationsDao quotationsDao;

	static Logger logger = LoggerFactory.getLogger(RFQServiceImpl.class);

	/**
	 * Method to create an rfq with the input details
	 */
	@Override
	public boolean rfqCreation(Rfq inputRfqRequest) {
		boolean status = false;
		try {
			rfqDao.save(inputRfqRequest);
			status = true;
		} catch (Exception e) {
			return status;
		}
		return status;
	}

	/**
	 * Return rfq details based on the ID
	 */
	@Override
	public List<Rfq> fetchRfqById(Rfq rfq) {
		List<Rfq> vendorList = rfqDao.findById(rfq.getId());
		if (!CollectionUtils.isEmpty(vendorList)) {
			return vendorList;
		} else {
			logger.error("No vendors available in the database");
			throw new AppException(HttpStatus.NO_CONTENT.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
	}

	/**
	 * Search an rfq based on ID, NAME, TIME
	 */
	@Override
	public List<Rfq> rfqSearch(Integer id, String name, String time) {
		List<Rfq> searchResults = search(id, name, time);
		if (!CollectionUtils.isEmpty(searchResults)) {
			return searchResults;
		} else {
			logger.error("No vendors available in the database");
			throw new AppException(HttpStatus.NO_CONTENT.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
	}

	/**
	 * Method to return all the quotes
	 */
	@Override
	public List<Rfq> fetchRfq() {
		List<Rfq> rfqList = rfqDao.findAll();
		if (!CollectionUtils.isEmpty(rfqList)) {
			return rfqList;
		} else {
			logger.error("No vendors available in the database");
			throw new AppException(HttpStatus.NO_CONTENT.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
	}

	/**
	 * Save a query in rfq by id screen
	 */
	@Override
	public boolean raiseQuery(Rfq inputRfqRequest) {
		boolean status = false;
		try {
			rfqDao.save(inputRfqRequest);
			status = true;
		} catch (Exception e) {
			return status;
		}
		return status;
	}

	/**
	 * 
	 * Method call of rfqSearch
	 * 
	 * @param ID
	 * @param NAME
	 * @param TIME
	 * @return
	 */
	List<Rfq> search(Integer ID, String NAME, String TIME) {
		List<Rfq> list = new ArrayList<Rfq>();
		RFQSpec spec = new RFQSpec(ID, NAME, TIME);
		list = rfqDao.findAll(spec);
		return list;

	}

	/**
	 * 
	 */
	@Override
	public List<Quotation> fetchQuotes() {
		List<Quotation> vendorList = (List<Quotation>) quotationsDao.findAll();
		if (!CollectionUtils.isEmpty(vendorList)) {
			return vendorList;
		} else {
			logger.error("No vendors available in the database");
			throw new AppException(HttpStatus.NO_CONTENT.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
	}

	/**
	 * Upload terms, description and file to the db in the view rfq by id section
	 */
	@Override
	public boolean uploadQuote(Rfq inputRfqRequest) {
		boolean status = false;
		try {
			rfqDao.save(inputRfqRequest);
			status = true;
		} catch (Exception e) {
			return status;
		}
		return status;
	}

	/**
	 * Method to delete a list of rfq's
	 */
	@Override
	public boolean deleteRfq(List<Rfq> rfq) {
		boolean status = false;
		try {
			rfqDao.delete(rfq);
			status = true;
			return status;
		} catch (Exception e) {
			return status;
		}
	}

	/**
	 * Method to read an xl
	 */
	@Override
	public void xlRead(MultipartFile file) {

		try {

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getRowNum() == 0) {
					continue;
				}
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue());
						break;
					}
				}
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
