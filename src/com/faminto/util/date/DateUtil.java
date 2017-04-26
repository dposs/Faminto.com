package com.faminto.util.date;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	public static Date getDateWithTime(Date data, LocalTime time) {
		LocalDateTime localDateTime = time.atDate(data.toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDate());
		return Date.from(localDateTime.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
	}
}
