package test;

import br.ce.wcaquino.taskbackend.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void validarRetornoDaDataNoPassado(){
        LocalDate data = LocalDate.of(2016, 07, 16);
        Assertions.assertFalse(DateUtils.isEqualOrFutureDate(data));
    }

    @Test
    public void validarRetornoDaDataAtual(){
        LocalDate data = LocalDate.now();
        Assertions.assertTrue(DateUtils.isEqualOrFutureDate(data));
    }

    @Test
    public void validarRetornoDaDataNoFuturo(){
        LocalDate data = LocalDate.of(2030, 06,17);
        Assertions.assertTrue(DateUtils.isEqualOrFutureDate(data));
    }
}
