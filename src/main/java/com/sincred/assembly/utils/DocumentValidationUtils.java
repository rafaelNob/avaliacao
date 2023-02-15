package com.sincred.assembly.utils;

import br.com.caelum.stella.validation.CPFValidator;
import com.google.common.base.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DocumentValidationUtils {
    private static final Logger LOGGER = LogManager.getLogger(DocumentValidationUtils.class);

    public Boolean isInvalidCpf(String cpf) {
        var cpfValidator = new CPFValidator();
        return Strings.isNullOrEmpty(cpf) || !cpfValidator.invalidMessagesFor(cpf).isEmpty();
    }

    public String cleanFormatting(String value) {
        return value.replaceAll("[^0-9]", "");
    }

}
