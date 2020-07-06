package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
	
	@Test
	public void devRetornarTrueParaDatasFuturas() {
		LocalDate date = LocalDate.of(2030, 01, 01);
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
		//System.out.println(DateUtils.isEqualOrFutureDate(date));;
	}
	
	@Test
	public void devRetornarFalseParaDatasPassadas() {
		LocalDate date = LocalDate.of(2010, 01, 01);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
	}
	
	@Test
	public void devRetornarTrueParaDataAtual() {
		LocalDate date = LocalDate.now();
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
	}

}
