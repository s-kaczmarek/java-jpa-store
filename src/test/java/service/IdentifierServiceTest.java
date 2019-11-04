package service;

import entity.commons.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import service.exception.WrongRangeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentifierServiceTest {

    @Test
    public void shouldMatchPattern() throws WrongRangeException {
        // given
        ProductCategory productCategory = ProductCategory.CHEMISTRY;
        String s = IdentifierService.generateIdentifier(productCategory);

        // when
        Pattern pattern = Pattern.compile("CHE_\\d\\d");
        Matcher matcher = pattern.matcher(s);
        boolean result = matcher.matches();

        // then
        Assert.assertTrue(result);
    }
}
