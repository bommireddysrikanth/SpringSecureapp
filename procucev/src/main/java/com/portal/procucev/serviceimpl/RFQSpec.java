package com.portal.procucev.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.portal.procucev.model.Rfq;
import com.portal.procucev.model.RfqItem;

/**
 * 
 * @author venu gopal
 *
 */
public class RFQSpec implements Specification<Rfq> {
	private Integer id = 0;
	private String name = null;
	private String time = null;

	public RFQSpec(Integer id, String name, String time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
	}

	@Override
	public Predicate toPredicate(Root<Rfq> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();

		// criteriaQuery = criteriaQuery.select(root);
		/*
		 * Predicate predicate = criteriaBuilder.equal(resource.get(""), "name");
		 * criteriaQuery.where(predicate); entityManager.createQuery(criteriaQuery);
		 */
		if (null != id) {
			predicates.add(criteriaBuilder.equal(root.get("rfqId"), id));
		}
		if (name != null) {
			predicates.add(criteriaBuilder.equal(root.get("clientName"), name));

		}
		if (time != null) {
			// Join<Rfq, RfqItem> join = root.join("brand", JoinType.LEFT);

			root = criteriaQuery.from(Rfq.class);
			Join<Rfq, List<RfqItem>> resource = root.join("rfqItem");

			predicates.add(criteriaBuilder.equal(resource.get("brand"), time));

		}

		/*
		 * if (time != null) {
		 * predicates.add(criteriaBuilder.equal(root.get("vendorNumber"), time)); }
		 */

		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}
}
