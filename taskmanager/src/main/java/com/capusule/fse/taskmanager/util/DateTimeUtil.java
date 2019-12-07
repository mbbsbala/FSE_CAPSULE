package com.capusule.fse.taskmanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import com.capusule.fse.taskmanager.enums.ErrorCodes;
import com.capusule.fse.taskmanager.exception.AppException;
import static com.capusule.fse.taskmanager.common.ApplicationConstants.DATE_DDMMYYYY;;

public enum DateTimeUtil {
	INSTANCE;
	
	public String convertDateToString(Date date, String dateFormat) {
		Instant instant = date.toInstant();
		LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		String formattedDate = ldt.format(formatter);
		return formattedDate;
	}
	
	public Date convertStringToDate(String inputDate, String dateFormat) throws AppException {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_DDMMYYYY, Locale.ENGLISH);
		Date date = null;
		try {
			date = formatter.parse(inputDate);
		} catch (ParseException e) {
			throw new AppException(ErrorCodes.SYS_INVALID_REQUEST);
		}
		return date;
	}
}
