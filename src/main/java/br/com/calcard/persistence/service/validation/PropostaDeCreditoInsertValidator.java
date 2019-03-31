package br.com.calcard.persistence.service.validation;

import br.com.calcard.controller.exceptions.FieldMessage;
import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.repository.PropostaDeCreditoRepository;
import br.com.calcard.persistence.service.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PropostaDeCreditoInsertValidator implements ConstraintValidator<PropostaDeCreditoInsert, PropostaDeCredito>
{
    @Autowired
    private PropostaDeCreditoRepository propostaDeCreditoRepository;

    @Override
    public void initialize(PropostaDeCreditoInsert ann){}

    @Override
    public boolean isValid(PropostaDeCredito propostaDeCredito, ConstraintValidatorContext context)
    {
        List<FieldMessage> list = new ArrayList<>();

        if(BR.isValidCPF(propostaDeCredito.getCpf()) ){
            list.add(new FieldMessage("CPF", "CPF inválido"));
        }

        for(FieldMessage e : list )
        {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }

        return list.isEmpty();

    }

}