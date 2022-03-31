package com.pickme.pickme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

	public static final String REST_V1 = "/api/v1";

	public static final String getCurrentDate() throws Exception {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return formatter.format(date);
	}
}
