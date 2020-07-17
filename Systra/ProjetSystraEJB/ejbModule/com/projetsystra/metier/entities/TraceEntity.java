package com.projetsystra.metier.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_trace")
public class TraceEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Trace_id")
	private Long TraceID;
	

	
	@Column(name="Trace_email")
	private String TraceEmail;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date TraceDate;
	
	@Column(name="Trace_operation")
	private String TraceOperation;

	
	
	public TraceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TraceEntity( String  traceEmail, Date traceDate, String traceOperation) {
		super();
		TraceEmail = traceEmail;
		TraceDate = traceDate;
		TraceOperation = traceOperation;
	}

	public Long getTraceID() {
		return TraceID;
	}

	public void setTraceID(Long traceID) {
		TraceID = traceID;
	}

	public String getTraceEmail() {
		return TraceEmail;
	}

	public void setTraceEmail(String traceEmail) {
		TraceEmail = traceEmail;
	}

	public Date getTraceDate() {
		return TraceDate;
	}

	public void setTraceDate(Date traceDate) {
		TraceDate = traceDate;
	}

	public String getTraceOperation() {
		return TraceOperation;
	}

	public void setTraceOperation(String traceOperation) {
		TraceOperation = traceOperation;
	}
	
	
	
	
}
